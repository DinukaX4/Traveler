package lk.ijse.spring.rest.traveler.dto;

import org.springframework.web.multipart.MultipartFile;

public class MediaDTO {
    private String path;
    private MultipartFile[] files;

    public MediaDTO() {
    }

    public MediaDTO(MultipartFile[] files) {

        this.setFiles(files);
    }
    public MediaDTO(String path, MultipartFile[] files) {
        this.setPath(path);
        this.files = files;
    }

    public MediaDTO(String path) {
        this.path = path;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }



    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
