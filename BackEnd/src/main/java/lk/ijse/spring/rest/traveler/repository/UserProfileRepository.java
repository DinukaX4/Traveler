package lk.ijse.spring.rest.traveler.repository;

import lk.ijse.spring.rest.traveler.entity.UserProfile;
import lk.ijse.spring.rest.traveler.entity.UserProfile_PK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserProfileRepository extends JpaRepository<UserProfile, UserProfile_PK> {

    //    @Query(value = "select u.userName,p.path,u.twitter,u.faceBook,u.firstName,u.works from userprofile u, profilePicture p where u.userName=p.userName && u.online=true",nativeQuery = true)
    @Query(value = "select u from UserProfile u where u.online=true ")
    List<UserProfile> onlineUsers();

}
