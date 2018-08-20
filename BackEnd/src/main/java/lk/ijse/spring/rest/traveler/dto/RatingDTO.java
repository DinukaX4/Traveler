package lk.ijse.spring.rest.traveler.dto;

public class RatingDTO {
    private String userName;
    private ArticleDTO articleDTO;
    private int star;
    private String ratedDay;

    public RatingDTO() {
    }

    public RatingDTO(String userName, ArticleDTO articleDTO, int star, String ratedDay) {
        this.userName = userName;
        this.articleDTO = articleDTO;
        this.star = star;
        this.ratedDay = ratedDay;
    }

    public ArticleDTO getArticleDTO() {
        return articleDTO;
    }

    public void setArticleDTO(ArticleDTO articleDTO) {
        this.articleDTO = articleDTO;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
