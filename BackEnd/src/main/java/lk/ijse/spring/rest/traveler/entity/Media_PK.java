package lk.ijse.spring.rest.traveler.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Media_PK implements Serializable {
    private String name;
    private String path;

    public Media_PK() {
    }

    public Media_PK(String name, String path) {
        this.name = name;
        this.path = path;
    }
}
