package lk.ijse.spring.rest.traveler.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Rating_PK implements Serializable{

    private String userName;
    private String articleName;

    public Rating_PK() {
    }

    public Rating_PK(String userName, String articleName) {
        this.userName = userName;
        this.articleName = articleName;
    }
}
