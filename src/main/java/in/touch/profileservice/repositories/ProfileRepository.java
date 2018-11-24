package in.touch.profileservice.repositories;

import java.util.List;

import in.touch.profileservice.models.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ProfileRepository extends CrudRepository<Profile, Long> {

    List<Profile> findById(String id);
}