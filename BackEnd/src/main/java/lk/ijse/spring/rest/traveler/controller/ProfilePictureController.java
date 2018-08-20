package lk.ijse.spring.rest.traveler.controller;

import lk.ijse.spring.rest.traveler.dto.CoverImageDTO;
import lk.ijse.spring.rest.traveler.dto.ProfilePictureDTO;
import lk.ijse.spring.rest.traveler.service.ProfilePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/profilePictures")
public class ProfilePictureController {
    @Autowired
    private ProfilePictureService profilePictureService;


    @PostMapping(value = "/profilePicture", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean newProfilePicture(@RequestBody ProfilePictureDTO dto) {
        try {
            return profilePictureService.newProfilePicture(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/coverImage", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean newCoverImage(@RequestBody CoverImageDTO coverImageDTO) {
        try {
            return profilePictureService.newCoverImage(coverImageDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping(value = "/coverImages/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CoverImageDTO> oldCoverImages(@PathVariable("userName") String userName) {
        try {
            return profilePictureService.oldCoverImages(userName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "/profilePictures/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CoverImageDTO> oldProfilePictures(@PathVariable("userName") String userName) {
        try {
            return profilePictureService.oldCoverImages(userName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
