package lk.ijse.spring.rest.traveler.controller;

import lk.ijse.spring.rest.traveler.dto.UserDTO;
import lk.ijse.spring.rest.traveler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void travelerUsers() {
        System.out.println("Working");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean newRequestedUser(@RequestBody UserDTO userDTO) {
        try {
            return service.save(userDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean canAuthenticate(@RequestBody UserDTO userDTO) {

        try {
            return service.canAuthenticate(userDTO.getUserName(),userDTO.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/logout", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean logOut(@RequestBody UserDTO dto) {
        try {
            return service.logOut(dto.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
