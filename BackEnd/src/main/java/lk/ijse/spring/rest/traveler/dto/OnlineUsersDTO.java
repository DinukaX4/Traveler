package lk.ijse.spring.rest.traveler.dto;

public class OnlineUsersDTO {

    private String userName;
    private String pcPath;
    private String twitter;
    private String faceBook;
    private String firstName;
    private String works;


    public OnlineUsersDTO() {
    }

    public OnlineUsersDTO(String userName, String pcPath, String twitter, String faceBook, String firstName, String works) {
        this.setUserName(userName);
        this.setPcPath(pcPath);
        this.setTwitter(twitter);
        this.setFaceBook(faceBook);
        this.setFirstName(firstName);
        this.setWorks(works);

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPcPath() {
        return pcPath;
    }

    public void setPcPath(String pcPath) {
        this.pcPath = pcPath;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }


}
