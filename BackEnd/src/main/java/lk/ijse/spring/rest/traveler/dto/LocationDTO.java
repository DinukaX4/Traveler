package lk.ijse.spring.rest.traveler.dto;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

public class LocationDTO {

    private String locationName;
    private BigDecimal lat;
    private BigDecimal lng;
    private List<LocationCategoryDTO> categoryDTO;
    private List<MediaDTO> locationImage;
    private MultipartFile[] files;
    public LocationDTO() {
    }

    public LocationDTO(String locationName, BigDecimal lat, BigDecimal lng, List<LocationCategoryDTO> categoryDTO, List<MediaDTO> locationImage, MultipartFile[] files) {
        this.setLocationName(locationName);
        this.setLat(lat);
        this.setLng(lng);
        this.setCategoryDTO(categoryDTO);
        this.setLocationImage(locationImage);
        this.setFiles(files);
    }


    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public List<LocationCategoryDTO> getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(List<LocationCategoryDTO> categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public List<MediaDTO> getLocationImage() {
        return locationImage;
    }

    public void setLocationImage(List<MediaDTO> locationImage) {
        this.locationImage = locationImage;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
