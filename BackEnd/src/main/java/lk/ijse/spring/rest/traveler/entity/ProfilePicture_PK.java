package lk.ijse.spring.rest.traveler.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProfilePicture_PK implements Serializable {
    private String userName;
    private String path;

    public ProfilePicture_PK() {
    }

    public ProfilePicture_PK(String userName, String path) {
        this.userName = userName;
        this.path = path;
    }

    public ProfilePicture_PK(String userName) {
        this.userName = userName;
    }
}
