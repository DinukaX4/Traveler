package lk.ijse.spring.rest.traveler.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProfilePictureDTO {

    private MultipartFile file;
    private UserProfileDTO dto;
    private String path;

    public ProfilePictureDTO() {
    }

    public ProfilePictureDTO(MultipartFile file, UserProfileDTO dto) {
        this.setFile(file);
        this.setDto(dto);
    }

    public ProfilePictureDTO(String path) {
        this.setPath(path);
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


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}
