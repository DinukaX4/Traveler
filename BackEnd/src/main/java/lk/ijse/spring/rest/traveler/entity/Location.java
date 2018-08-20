package lk.ijse.spring.rest.traveler.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Location implements Serializable {

    private String locationName;
    @Column(nullable = false, precision = 19, scale = 5, insertable = false, updatable = false)
    private BigDecimal lat;
    @Column(nullable = false, precision = 19, scale = 5, insertable = false, updatable = false)
    private BigDecimal lng;
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "categoryName", referencedColumnName = "name", updatable = false, foreignKey = @ForeignKey)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<LocationCategory> locationCategories;
    @OneToMany(cascade = CascadeType.PERSIST)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Media> image;
    @EmbeddedId
    private Location_PK location_pk;

    public Location() {
    }

    public Location(String locationName, BigDecimal lat, BigDecimal lng, List<LocationCategory> locationCategories, List<Media> image, Location_PK location_pk) {
        this.setLocationName(locationName);
        this.setLat(lat);
        this.setLng(lng);
        this.setLocationCategories(locationCategories);
        this.setImage(image);
        this.setLocation_pk(new Location_PK(lat, lng));
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

    public List<LocationCategory> getLocationCategories() {
        return locationCategories;
    }

    public void setLocationCategories(List<LocationCategory> locationCategories) {
        this.locationCategories = locationCategories;
    }

    public List<Media> getImage() {
        return image;
    }

    public void setImage(List<Media> image) {
        this.image = image;
    }

    public Location_PK getLocation_pk() {
        return location_pk;
    }

    public void setLocation_pk(Location_PK location_pk) {
        this.location_pk = location_pk;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationName='" + locationName + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", locationCategories=" + locationCategories +
                ", image=" + image +
                ", location_pk=" + location_pk +
                '}';
    }
}
