package lk.ijse.spring.rest.traveler.dto;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.ArrayList;

public class ArticleDTO {

    private String articleName;
    private String tittle;
    private String content;
    private String postedDate;
    private UserDTO userDTO;
    private MultipartFile[] files;
    private ArrayList<MediaDTO> medias;
    private LocationDTO locationDTO;


    public ArticleDTO() {
    }

    public ArticleDTO(String articleName, String tittle, String content, String postedDate, UserDTO userDTO, MultipartFile[] files) {
        this.setArticleName(articleName);
        this.setTittle(tittle);
        this.setContent(content);
        this.setPostedDate(postedDate);
        this.setUserDTO(userDTO);
        this.setFiles(files);
    }

    public ArticleDTO(String articleName, String tittle, String content, String postedDate, UserDTO userDTO, ArrayList<MediaDTO> medias) {
        this.articleName = articleName;
        this.tittle = tittle;
        this.content = content;
        this.postedDate = postedDate;
        this.userDTO = userDTO;
        this.setMedias(medias);
    }

    public ArticleDTO(String articleName, String tittle, String content, String postedDate, UserDTO userDTO, MultipartFile[] files, ArrayList<MediaDTO> medias, LocationDTO locationDTO) {
        this.articleName = articleName;
        this.tittle = tittle;
        this.content = content;
        this.postedDate = postedDate;
        this.userDTO = userDTO;
        this.files = files;
        this.medias = medias;
        this.setLocationDTO(locationDTO);
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public ArrayList<MediaDTO> getMedias() {
        return medias;
    }

    public void setMedias(ArrayList<MediaDTO> medias) {
        this.medias = medias;
    }


    public LocationDTO getLocationDTO() {
        return locationDTO;
    }

    public void setLocationDTO(LocationDTO locationDTO) {
        this.locationDTO = locationDTO;
    }
}
