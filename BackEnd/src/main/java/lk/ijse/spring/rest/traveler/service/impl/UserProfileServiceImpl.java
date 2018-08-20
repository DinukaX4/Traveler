package lk.ijse.spring.rest.traveler.service.impl;

import lk.ijse.spring.rest.traveler.dto.OnlineUsersDTO;
import lk.ijse.spring.rest.traveler.dto.UserProfileDTO;
import lk.ijse.spring.rest.traveler.entity.*;
import lk.ijse.spring.rest.traveler.repository.UserProfileRepository;
import lk.ijse.spring.rest.traveler.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean createProfileForUser(UserProfileDTO dto) throws Exception {
        User user = new User();
        user.setUserName(dto.getUserDTO().getUserName());
        UserProfile_PK userProfile_pk = new UserProfile_PK(dto.getUserDTO().getUserName());

        UserProfile userProfile = new UserProfile();
        userProfile.setCurrentTown(dto.getCurrentTown());
        userProfile.setFaceBook(dto.getFaceBook());
        userProfile.setFirstName(dto.getFirstName());
        userProfile.setHomeTown(dto.getHomeTown());
        userProfile.setUserProfile_pk(userProfile_pk);
        userProfile.setUser(user);
        userProfile.setOnline(true);
        userProfile.setLastName(dto.getLastName());
        userProfile.setTwitter(dto.getTwitter());
        userProfile.setWorks(dto.getWorks());

        userProfile.setCurrentCoverImage(dto.getCurrentCIPath());
        userProfile.setCurrentProfilePicture(dto.getCurrentPCPath());
        Optional<UserProfile> byId = repository.findById(userProfile_pk);
        if (byId.isPresent()) {
            System.out.println("lol1");
            return false;
        } else {
            File userFile = new File("D:/GDSE 42/working directory/3rd semester/Traveler/backendServer/img/" + dto.getUserDTO().getUserName());
            File imageFIle=new File("D:/GDSE 42/working directory/3rd semester/Traveler/backendServer/img/" + dto.getUserDTO().getUserName()+"/images");
            File article=new File("D:/GDSE 42/working directory/3rd semester/Traveler/backendServer/img/" + dto.getUserDTO().getUserName()+"/images/article");
            File cover=new File("D:/GDSE 42/working directory/3rd semester/Traveler/backendServer/img/" + dto.getUserDTO().getUserName()+"/images/cover");
            File profile=new File("D:/GDSE 42/working directory/3rd semester/Traveler/backendServer/img/" + dto.getUserDTO().getUserName()+"/images/profile");
//            System.out.println(imageFIle.mkdirs());
            if (userFile.mkdirs()&& imageFIle.mkdirs() && article.mkdirs() && cover.mkdirs() && profile.mkdirs() ) {
                repository.save(userProfile);
                return true;
            } else {
                System.out.println("LOL2");
                return false;
            }
        }
    }

    @Override
    public ArrayList<OnlineUsersDTO> onlineUsers() throws Exception {
//        List<Object[]> users = repository.onlineUsers();
        List<UserProfile> onlineUsers = repository.onlineUsers();
        ArrayList<OnlineUsersDTO> dtos = new ArrayList<>();
        for (UserProfile onlineUser : onlineUsers) {
            OnlineUsersDTO dto =
                    new OnlineUsersDTO(
                            onlineUser.getUser().getUserName(),
                            onlineUser.getCurrentProfilePicture(),
                            onlineUser.getTwitter(), onlineUser.getFaceBook(),
                            onlineUser.getFirstName(),
                            onlineUser.getWorks()
                    );
            dtos.add(dto);
        }
        return dtos;
    }


}
