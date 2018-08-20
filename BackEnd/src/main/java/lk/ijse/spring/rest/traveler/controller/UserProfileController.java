package lk.ijse.spring.rest.traveler.controller;

import lk.ijse.spring.rest.traveler.dto.OnlineUsersDTO;
import lk.ijse.spring.rest.traveler.dto.UserProfileDTO;
import lk.ijse.spring.rest.traveler.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/userProfiles")
public class UserProfileController {

    @Autowired
    private UserProfileService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean newTravelerProfile(@RequestBody UserProfileDTO dto) {

        try {
            return service.createProfileForUser(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/online")
    public ArrayList<OnlineUsersDTO> onlineUsers(){
        try {
            return service.onlineUsers();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
