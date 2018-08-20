package lk.ijse.spring.rest.traveler.service;

import lk.ijse.spring.rest.traveler.dto.LocationDTO;

import java.util.ArrayList;

public interface LocationService {

    public ArrayList<LocationDTO> mostUseLocation() throws Exception;

    public boolean newLocation(LocationDTO locationDTO)throws Exception;
}
