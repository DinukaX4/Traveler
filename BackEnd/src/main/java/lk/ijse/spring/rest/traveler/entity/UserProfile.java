package lk.ijse.spring.rest.traveler.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class UserProfile implements Serializable {

    private String firstName;
    private String lastName;
    private String twitter;
    private String faceBook;
    private String homeTown;
    private String currentTown;
    private String works;
    private boolean online;
    @OneToOne(cascade = CascadeType.REFRESH)
    private User user;
    private String currentProfilePicture;
    private String currentCoverImage;
    @EmbeddedId
    private UserProfile_PK userProfile_pk = new UserProfile_PK();

    public UserProfile() {
    }


    public UserProfile(String userName, String firstName, String lastName, String twitter, String faceBook, String homeTown, String currentTown, String works, boolean online, User user, String currentProfilePicture, String currentCoverImage, UserProfile_PK userProfile_pk) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.twitter = twitter;
        this.faceBook = faceBook;
        this.homeTown = homeTown;
        this.currentTown = currentTown;
        this.works = works;
        this.online = online;
        this.user = user;
        this.setCurrentProfilePicture(currentProfilePicture);
        this.setCurrentCoverImage(currentCoverImage);
        this.userProfile_pk = new UserProfile_PK(userName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFaceBook() {
        return faceBook;
    }

    public void setFaceBook(String faceBook) {
        this.faceBook = faceBook;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getCurrentTown() {
        return currentTown;
    }

    public void setCurrentTown(String currentTown) {
        this.currentTown = currentTown;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserProfile_PK getUserProfile_pk() {
        return userProfile_pk;
    }

    public void setUserProfile_pk(UserProfile_PK userProfile_pk) {
        this.userProfile_pk = userProfile_pk;
    }


    public String getCurrentProfilePicture() {
        return currentProfilePicture;
    }

    public void setCurrentProfilePicture(String currentProfilePicture) {
        this.currentProfilePicture = currentProfilePicture;
    }

    public String getCurrentCoverImage() {
        return currentCoverImage;
    }

    public void setCurrentCoverImage(String currentCoverImage) {
        this.currentCoverImage = currentCoverImage;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", twitter='" + twitter + '\'' +
                ", faceBook='" + faceBook + '\'' +
                ", homeTown='" + homeTown + '\'' +
                ", currentTown='" + currentTown + '\'' +
                ", works='" + works + '\'' +
                ", online=" + online +
                ", user=" + user +
                ", currentProfilePicture='" + currentProfilePicture + '\'' +
                ", currentCoverImage='" + currentCoverImage + '\'' +
                ", userProfile_pk=" + userProfile_pk +
                '}';
    }
}
