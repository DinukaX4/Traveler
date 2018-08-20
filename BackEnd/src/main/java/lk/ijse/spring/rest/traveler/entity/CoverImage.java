package lk.ijse.spring.rest.traveler.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CoverImage implements Serializable {
    @Column(insertable = false, updatable = false)
    private String path;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "userName", referencedColumnName = "userName", updatable = false, insertable = false)
    private UserProfile profile;
    @EmbeddedId
    private ProfilePicture_PK profilePicture_pk;


    public CoverImage() {
    }

    public CoverImage(String userName, String path, UserProfile profile, ProfilePicture_PK profilePicture_pk) {
        this.setPath(path);
        this.setProfile(profile);
        profilePicture_pk = new ProfilePicture_PK(userName, path);
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
        return "CoverImageDTO{" +
                "path='" + path + '\'' +
                ", profile=" + profile +
                ", profilePicture_pk=" + profilePicture_pk +
                '}';
    }
}
