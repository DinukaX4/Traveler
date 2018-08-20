package lk.ijse.spring.rest.traveler.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserProfile_PK implements Serializable {

    private String userName;

    public UserProfile_PK() {
    }

    public UserProfile_PK(String userName) {
        this.userName = userName;
    }

}
