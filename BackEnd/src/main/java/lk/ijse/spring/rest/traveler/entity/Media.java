package lk.ijse.spring.rest.traveler.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Media implements Serializable {
    @Column(insertable = false,updatable = false)
    private String path;
    @EmbeddedId
    private Media_PK media_pk;

    public Media() {
    }

    public Media(String name,String path, Media_PK media_pk) {
        this.setPath(path);
        media_pk =new Media_PK(name,path);
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Media_PK getMedia_pk() {
        return media_pk;
    }

    public void setMedia_pk(Media_PK media_pk) {
        this.media_pk = media_pk;
    }

    @Override
    public String toString() {
        return "Media{" +
                "path='" + path + '\'' +
                ", media_pk=" + media_pk +
                '}';
    }
}
