package lk.ijse.spring.rest.traveler.service;

import lk.ijse.spring.rest.traveler.dto.RatingDTO;

public interface RatingService {

    public boolean rate(RatingDTO dto)throws Exception;
}
