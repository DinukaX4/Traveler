package lk.ijse.spring.rest.traveler.controller;

import lk.ijse.spring.rest.traveler.dto.RatingDTO;
import lk.ijse.spring.rest.traveler.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean rate(@RequestBody RatingDTO ratingDTO) {
        try {
            return ratingService.rate(ratingDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
