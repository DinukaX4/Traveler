package lk.ijse.spring.rest.traveler.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Rating implements Serializable {
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "userName", referencedColumnName = "userName", updatable = false, insertable = false)
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "articleName", referencedColumnName = "articleName", updatable = false, insertable = false)
    private Article article;
    @Column(nullable = false)
    private int star;
    @Column(nullable = false)
    private String ratedDay;
    @EmbeddedId
    private Rating_PK rating_pk;

    public Rating() {
    }

    public Rating(String userName, String articleName, User user, Article article, int star, String ratedDay, Rating_PK rating_pk) {
        this.user = user;
        this.article = article;
        this.star = star;
        this.ratedDay = ratedDay;
        this.rating_pk = new Rating_PK(userName, articleName);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getRatedDay() {
        return ratedDay;
    }

    public void setRatedDay(String ratedDay) {
        this.ratedDay = ratedDay;
    }

    public Rating_PK getRating_pk() {
        return rating_pk;
    }

    public void setRating_pk(Rating_PK rating_pk) {
        this.rating_pk = rating_pk;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "user=" + user +
                ", article=" + article +
                ", star=" + star +
                ", ratedDay='" + ratedDay + '\'' +
                ", rating_pk=" + rating_pk +
                '}';
    }
}
