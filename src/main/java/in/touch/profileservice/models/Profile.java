package in.touch.profileservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<SocialSpace> links;

    @JsonProperty("friends")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Profile> friends;

    protected Profile() {}

    public Profile(List<SocialSpace> links){
        this.links = links;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("links")
    public List<SocialSpace> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, links='%s']",
                id, links);
    }

}
