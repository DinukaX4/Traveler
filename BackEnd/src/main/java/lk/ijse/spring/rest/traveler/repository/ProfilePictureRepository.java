package lk.ijse.spring.rest.traveler.repository;


import lk.ijse.spring.rest.traveler.entity.ProfilePicture;
import lk.ijse.spring.rest.traveler.entity.ProfilePicture_PK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfilePictureRepository extends JpaRepository<ProfilePicture, ProfilePicture_PK> {
    @Query("select p from  ProfilePicture p where lower(p.profile)= lower(:userName)")
    List<ProfilePicture> oldProfilePictures(@Param("userName") String userName);
}
