package in.touch.profileservice.controllers;

import in.touch.profileservice.models.Profile;
import in.touch.profileservice.repositories.ProfileRepository;
import in.touch.profileservice.response.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@RestController
public class ProfileController2 {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/profiles")
    public Iterable<Profile> retrieveAllProfiles() {
        return profileRepository.findAll();
    }

    @GetMapping("/profiles/{id}")
    public Profile retrieveStudent(@PathVariable long id) {
        Optional<Profile> profile = profileRepository.findById(id);

        if (!profile.isPresent())
            throw new NotFoundException();

        return profile.get();
    }

    @PostMapping("/profiles")
    public ResponseEntity<Object> createStudent(@RequestBody Profile profile) {
        Profile savedProfile = profileRepository.save(profile);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProfile.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/profiles/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Profile profile, @PathVariable long id) {

        Optional<Profile> profileOptional = profileRepository.findById(id);

        if (!profileOptional.isPresent())
            return ResponseEntity.notFound().build();

        profile.setId(id);

        profileRepository.save(profile);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/profiles/{id}")
    public void deleteStudent(@PathVariable long id) {
        profileRepository.deleteById(id);
    }

}

