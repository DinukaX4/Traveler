package lk.ijse.spring.rest.traveler.service.impl;

import lk.ijse.spring.rest.traveler.dto.LocationCategoryDTO;
import lk.ijse.spring.rest.traveler.dto.LocationDTO;
import lk.ijse.spring.rest.traveler.entity.*;
import lk.ijse.spring.rest.traveler.repository.LocationRepository;
import lk.ijse.spring.rest.traveler.service.LocationService;
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
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public ArrayList<LocationDTO> mostUseLocation() throws Exception {
        List<Location> locations = locationRepository.mostUseLocation();
        ArrayList<LocationDTO> locationDTOS = new ArrayList<>();
//        for (Location location : locations) {
//            LocationDTO locationDTO = new LocationDTO(location.getLocationName(), location.getLat(), location.getLng());
//            locationDTOS.add(locationDTO);
//        }
        return locationDTOS;
    }

    @Override
    public boolean newLocation(LocationDTO locationDTO) throws Exception {
        List<LocationCategoryDTO> categoryDTO = locationDTO.getCategoryDTO();
        List<LocationCategory> locationCategories = new ArrayList<>();
        for (LocationCategoryDTO dto : categoryDTO) {
            LocationCategory locationCategory = new LocationCategory(dto.getName(), dto.getDiscription());
            locationCategories.add(locationCategory);
        }
        Location_PK location_pk = new Location_PK(locationDTO.getLat(), locationDTO.getLng());
        List<Media> mediaList = new ArrayList<>();
        MultipartFile[] files = locationDTO.getFiles();
        for (MultipartFile file : files) {
            if (!file.getOriginalFilename().isEmpty()) {
                BufferedOutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream(
                                new File("D:/GDSE 42/working directory/3rd semester/Traveler/backendServer/img/locations/" + file.getOriginalFilename())));
                outputStream.write(file.getBytes());
                outputStream.flush();
                outputStream.close();
            }
            Media media = new Media();
            media.setPath(file.getName());
            Media_PK media_pk = new Media_PK(locationDTO.getLocationName(), "http://localhost:8080/api/v1/images/download1?path=D:/GDSE 42/working directory/3rd semester/Traveler/backendServer/img/locations/" + file.getOriginalFilename());
            media.setMedia_pk(media_pk);
            mediaList.add(media);
        }
        Location location = new Location(locationDTO.getLocationName(), locationDTO.getLat(), locationDTO.getLng(), locationCategories, mediaList, location_pk);
        locationRepository.save(location);
        return true;
    }
}
