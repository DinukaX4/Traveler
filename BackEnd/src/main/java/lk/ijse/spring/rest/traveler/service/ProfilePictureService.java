package lk.ijse.spring.rest.traveler.service;

import lk.ijse.spring.rest.traveler.dto.CoverImageDTO;
import lk.ijse.spring.rest.traveler.dto.ProfilePictureDTO;

import java.util.ArrayList;

public interface ProfilePictureService {

    public boolean newProfilePicture(ProfilePictureDTO dto) throws Exception;

    public boolean newCoverImage(CoverImageDTO dto) throws Exception;

    public ArrayList<CoverImageDTO> oldCoverImages(String userName) throws Exception;

    public ArrayList<ProfilePictureDTO> oldProfilePictures(String userName) throws Exception;
}
