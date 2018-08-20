package lk.ijse.spring.rest.traveler.dto;

import org.springframework.web.multipart.MultipartFile;

public class CoverImageDTO {

    private MultipartFile file;
    private UserProfileDTO dto;
    private String imagePath;

    public CoverImageDTO() {
    }

    public CoverImageDTO(MultipartFile file, UserProfileDTO dto) {
        this.setFile(file);
        this.setDto(dto);
    }

    public CoverImageDTO(String imagePath) {
        this.setImagePath(imagePath);
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public UserProfileDTO getDto() {
        return dto;
    }

    public void setDto(UserProfileDTO dto) {
        this.dto = dto;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
