package lk.ijse.spring.rest.traveler.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;

@Embeddable
public class Location_PK implements Serializable {
    @Column(precision = 19,scale = 5)
    private BigDecimal lat;
    @Column(precision = 19,scale = 5)
    private BigDecimal lng;

    public Location_PK() {
    }

    public Location_PK(BigDecimal lat, BigDecimal lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
