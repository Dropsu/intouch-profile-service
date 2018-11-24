package in.touch.profileservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class SocialSpace {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @JsonProperty("link")
    private String link;

    protected SocialSpace() {}

    public SocialSpace(String link){
        this.link = link;
    }

    @Override
    public String toString() {
        return String.format(
                "Social Space[id=%d, link='%s']",
                id, link);
    }
}
