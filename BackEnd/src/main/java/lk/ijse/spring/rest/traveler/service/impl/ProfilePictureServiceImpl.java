package lk.ijse.spring.rest.traveler.service.impl;

import lk.ijse.spring.rest.traveler.dto.CoverImageDTO;
import lk.ijse.spring.rest.traveler.dto.ProfilePictureDTO;
import lk.ijse.spring.rest.traveler.dto.UserProfileDTO;
import lk.ijse.spring.rest.traveler.entity.*;
import lk.ijse.spring.rest.traveler.repository.CoverImageRepository;
import lk.ijse.spring.rest.traveler.repository.ProfilePictureRepository;
import lk.ijse.spring.rest.traveler.service.ProfilePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class ProfilePictureServiceImpl implements ProfilePictureService {

    @Autowired
    private ProfilePictureRepository profilePictureRepository;
    @Autowired
    private CoverImageRepository coverImageRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean newProfilePicture(ProfilePictureDTO dto) throws Exception {
        MultipartFile file = dto.getFile();
        if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(
                            new File("D:/GDSE 42/working directory/3rd semester/Traveler/backendServer/img/" + dto.getDto().getUserDTO().getUserName() + "/images/profile", file.getOriginalFilename())));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();


            UserProfileDTO userProfileDTO = dto.getDto();
            User user = new User();
            user.setUserName(userProfileDTO.getUserDTO().getUserName());
            UserProfile_PK userProfile_pk = new UserProfile_PK(userProfileDTO.getUserDTO().getUserName());

            UserProfile userProfile = new UserProfile();
            userProfile.setCurrentTown(userProfileDTO.getCurrentTown());
            userProfile.setFaceBook(userProfileDTO.getFaceBook());
            userProfile.setFirstName(userProfileDTO.getFirstName());
            userProfile.setHomeTown(userProfileDTO.getHomeTown());
            userProfile.setUserProfile_pk(userProfile_pk);
            userProfile.setUser(user);
            userProfile.setOnline(true);
            userProfile.setLastName(userProfileDTO.getLastName());
            userProfile.setTwitter(userProfileDTO.getTwitter());
            userProfile.setWorks(userProfileDTO.getWorks());

            userProfile.setCurrentCoverImage(userProfileDTO.getCurrentCIPath());
            userProfile.setCurrentProfilePicture(userProfileDTO.getCurrentPCPath());

            user.setUserName(dto.getDto().getUserDTO().getUserName());
            userProfile.setUser(user);
            userProfile.setCurrentProfilePicture("http://localhost:8080/api/v1/images/download1?path=D:/GDSE 42/working directory/3rd semester/Traveler/backendServer/img/Dinuka/images/i.png");
            ProfilePicture profilePicture = new ProfilePicture();
            ProfilePicture_PK profilePicture_pk = new ProfilePicture_PK(dto.getDto().getUserDTO().getUserName(), "assets/images/Dinuka/images/i.png");
//        profilePicture.setPath(http://localhost:8080/api/v1/images/download1?path=?D:/GDSE 42/working directory/3rd semester/Traveler/backendServer/img/" + dto.getDto().getUserDTO().getUserName() + "/images/profile/"+file.getName());
            profilePicture.setPath("http://localhost:8080/api/v1/images/download1?path=D:/GDSE 42/working directory/3rd semester/Traveler/backendServer/img/Dinuka/images/i.png");
            profilePicture.setProfile(userProfile);
            profilePicture.setProfilePicture_pk(profilePicture_pk);
            profilePictureRepository.save(profilePicture);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean newCoverImage(CoverImageDTO dto) throws Exception {

        MultipartFile file = dto.getFile();
        if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(
                            new File("D:/GDSE 42/working directory/3rd semester/Traveler/backendServer/img/" + dto.getDto().getUserDTO().getUserName() + "/images/cover", file.getOriginalFilename())));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();


            UserProfileDTO userProfileDTO = dto.getDto();
            User user = new User();
            user.setUserName(userProfileDTO.getUserDTO().getUserName());
            UserProfile_PK userProfile_pk = new UserProfile_PK(userProfileDTO.getUserDTO().getUserName());

            UserProfile userProfile = new UserProfile();
            userProfile.setCurrentTown(userProfileDTO.getCurrentTown());
            userProfile.setFaceBook(userProfileDTO.getFaceBook());
            userProfile.setFirstName(userProfileDTO.getFirstName());
            userProfile.setHomeTown(userProfileDTO.getHomeTown());
            userProfile.setUserProfile_pk(userProfile_pk);
            userProfile.setUser(user);
            userProfile.setOnline(true);
            userProfile.setLastName(userProfileDTO.getLastName());
            userProfile.setTwitter(userProfileDTO.getTwitter());
            userProfile.setWorks(userProfileDTO.getWorks());

            userProfile.setCurrentCoverImage(userProfileDTO.getCurrentCIPath());
            userProfile.setCurrentProfilePicture(userProfileDTO.getCurrentPCPath());


            user.setUserName(dto.getDto().getUserDTO().getUserName());
            userProfile.setUser(user);
            CoverImage coverImage = new CoverImage();
            ProfilePicture_PK profilePicture_pk = new ProfilePicture_PK(dto.getDto().getUserDTO().getUserName(), file.getName());
            coverImage.setProfilePicture_pk(profilePicture_pk);
            coverImage.setPath(dto.getDto().getUserDTO().getUserName());
            coverImage.setProfile(userProfile);
            coverImageRepository.save(coverImage);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<CoverImageDTO> oldCoverImages(String userName) throws Exception {
        List<CoverImage> coverImages = coverImageRepository.oldCoverImages(userName);
        ArrayList<CoverImageDTO> dtos = new ArrayList<>();
        for (CoverImage coverImage : coverImages) {
            CoverImageDTO coverImageDTO = new CoverImageDTO(coverImage.getPath());
            dtos.add(coverImageDTO);
        }
        return dtos;
    }

    @Override
    public ArrayList<ProfilePictureDTO> oldProfilePictures(String userName) throws Exception {
        List<ProfilePicture> oldProfilePictures = profilePictureRepository.oldProfilePictures(userName);
        ArrayList<ProfilePictureDTO> dtos = new ArrayList<>();
        for (ProfilePicture profilePicture : oldProfilePictures) {
            ProfilePictureDTO profilePictureDTO = new ProfilePictureDTO(profilePicture.getPath());
            dtos.add(profilePictureDTO);
        }
        return dtos;
    }
}
