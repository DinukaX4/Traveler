package lk.ijse.spring.rest.traveler.repository;

import lk.ijse.spring.rest.traveler.entity.CoverImage;
import lk.ijse.spring.rest.traveler.entity.ProfilePicture_PK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoverImageRepository extends JpaRepository<CoverImage, ProfilePicture_PK> {
    @Query("select c from  CoverImage c where lower(c.profile)= lower(:userName)")
    List<CoverImage> oldCoverImages(@Param("userName") String userName);

}
