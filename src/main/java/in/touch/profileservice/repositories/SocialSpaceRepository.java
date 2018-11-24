package in.touch.profileservice.repositories;

import java.util.List;

import in.touch.profileservice.models.Profile;
import in.touch.profileservice.models.SocialSpace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface SocialSpaceRepository extends CrudRepository<SocialSpace, Long> {

    List<SocialSpace> findById(String id);
}
