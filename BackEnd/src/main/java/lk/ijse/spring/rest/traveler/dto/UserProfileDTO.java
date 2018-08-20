package lk.ijse.spring.rest.traveler.dto;

public class UserProfileDTO {

    private String firstName;
    private String lastName;
    private String twitter;
    private String faceBook;
    private String homeTown;
    private String currentTown;
    private String works;
    private boolean online;
    private UserDTO userDTO;
    private String currentPCPath;
    private String currentCIPath;

    public UserProfileDTO() {
    }

    public UserProfileDTO(String firstName, String lastName, String twitter, String faceBook, String homeTown, String currentTown, String works, boolean online, UserDTO userDTO) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setTwitter(twitter);
        this.setFaceBook(faceBook);
        this.setHomeTown(homeTown);
        this.setCurrentTown(currentTown);
        this.setWorks(works);
        this.setOnline(online);
        this.setUserDTO(userDTO);
    }

    public UserProfileDTO(String firstName, String lastName, String twitter, String faceBook, String homeTown, String currentTown, String works, boolean online, UserDTO userDTO, String currentPCPath, String currentCIPath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.twitter = twitter;
        this.faceBook = faceBook;
        this.homeTown = homeTown;
        this.currentTown = currentTown;
        this.works = works;
        this.online = online;
        this.userDTO = userDTO;
        this.setCurrentPCPath(currentPCPath);
        this.setCurrentCIPath(currentCIPath);
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }


    public String getCurrentPCPath() {
        return currentPCPath;
    }

    public void setCurrentPCPath(String currentPCPath) {
        this.currentPCPath = currentPCPath;
    }

    public String getCurrentCIPath() {
        return currentCIPath;
    }

    public void setCurrentCIPath(String currentCIPath) {
        this.currentCIPath = currentCIPath;
    }
}
