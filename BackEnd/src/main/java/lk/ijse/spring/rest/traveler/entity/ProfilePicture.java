package lk.ijse.spring.rest.traveler.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ProfilePicture implements Serializable {

    @Column(insertable = false, updatable = false)
    private String path;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userName", referencedColumnName = "userName", updatable = false, insertable = false)
    private UserProfile profile;
    @EmbeddedId
    private ProfilePicture_PK profilePicture_pk;

    public ProfilePicture() {
    }

    public ProfilePicture(String userName, String path, UserProfile profile, ProfilePicture_PK profilePicture_pk) {
        this.setPath(path);
        this.setProfile(profile);
        this.profilePicture_pk = new ProfilePicture_PK(userName, path);
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public ProfilePicture_PK getProfilePicture_pk() {
        return profilePicture_pk;
    }

    public void setProfilePicture_pk(ProfilePicture_PK profilePicture_pk) {
        this.profilePicture_pk = profilePicture_pk;
    }


    @Override
    public String toString() {
        return "ProfilePicture{" +
                "path='" + path + '\'' +
                ", profile=" + profile +
                ", profilePicture_pk=" + profilePicture_pk +
                '}';
    }
}
