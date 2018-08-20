package lk.ijse.spring.rest.traveler.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Article implements Serializable {

    @Id
    private String articleName;
    @Column(nullable = false)
    private String tittle;
    private String content;
    private String postedDate;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "userName", referencedColumnName = "userName", nullable = false, updatable = false, foreignKey = @ForeignKey)
    private UserProfile profile;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Media> media;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "location",referencedColumnName = "lat",foreignKey = @ForeignKey,updatable = false)
    })
    private Location location;

    public Article() {
    }

    public Article(String articleName, String tittle, String content, String postedDate, UserProfile profile, List<Media> media, Location location) {
        this.setArticleName(articleName);
        this.setTittle(tittle);
        this.setContent(content);
        this.setPostedDate(postedDate);
        this.setProfile(profile);
        this.setMedia(media);
        this.setLocation(location);
    }


    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }


    @Override
    public String toString() {
        return "Article{" +
                "articleName='" + articleName + '\'' +
                ", tittle='" + tittle + '\'' +
                ", content='" + content + '\'' +
                ", postedDate=" + postedDate +
                ", profile=" + profile +
                ", media=" + media +
                '}';
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
