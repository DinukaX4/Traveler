package lk.ijse.spring.rest.traveler.controller;

import lk.ijse.spring.rest.traveler.dto.LocationDTO;
import lk.ijse.spring.rest.traveler.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/locations")
public class LocationController {

    @Autowired
    private LocationService service;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<LocationDTO> locations() {
        try {
            return service.mostUseLocation();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean newLocation(@RequestBody LocationDTO dto) {
        try {
            return service.newLocation(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
