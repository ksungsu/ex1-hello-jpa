package hellojpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Movie extends Item{

    private String director;
    private String actor;

    public String getDirector() {
        return director;
    }

    public String getActor() {
        return actor;
    }

    //setter 사용x
    public void InChargeOf(String director, String actor) {
        this.director = director;
        this.actor = actor;
    }
}
