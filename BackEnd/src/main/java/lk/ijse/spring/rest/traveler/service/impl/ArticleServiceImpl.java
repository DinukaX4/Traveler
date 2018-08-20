package lk.ijse.spring.rest.traveler.service.impl;


import lk.ijse.spring.rest.traveler.dto.*;
import lk.ijse.spring.rest.traveler.entity.*;
import lk.ijse.spring.rest.traveler.repository.ArticleRepository;
import lk.ijse.spring.rest.traveler.service.ArticleService;
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
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository repository;


    @Override
    public boolean publishArcticel(ArticleDTO dto) throws Exception {
        MultipartFile[] files = dto.getFiles();
        ArrayList<Media> mediaList = new ArrayList<>();
//        for (MultipartFile file : files) {
//
//            if (!file.getOriginalFilename().isEmpty()) {
//                BufferedOutputStream outputStream = new BufferedOutputStream(
//                        new FileOutputStream(
//                                new File("D:/GDSE 42/working directory/3rd semester/Traveler/backendServer/img/" + dto.getUserDTO().getUserName() + "/images/article", file.getOriginalFilename())));
//                outputStream.write(file.getBytes());
//                outputStream.flush();
//                outputStream.close();
//
//            }
//
//            Media media = new Media();
//            media.setPath(file.getName());
//            Media_PK media_pk = new Media_PK(dto.getArticleName(), "http://localhost:8080/api/v1/images/download1?path=D:/GDSE 42/working directory/3rd semester/Traveler/backendServer/img/" + dto.getUserDTO().getUserName() + "/Articles/images/" + file.getName());
//            media.setMedia_pk(media_pk);
//            mediaList.add(media);
//
//        }
        UserProfile_PK userProfile_pk = new UserProfile_PK(dto.getUserDTO().getUserName());
        UserProfile userProfile = new UserProfile();
        userProfile.setUserProfile_pk(userProfile_pk);

        LocationDTO locationDTO = dto.getLocationDTO();
        Location_PK location_pk = new Location_PK(locationDTO.getLat(), locationDTO.getLng());
        Location location = new Location();
        location.setLat(locationDTO.getLat());
        location.setLng(locationDTO.getLng());
        location.setLocation_pk(location_pk);

        Article article = new Article(dto.getArticleName(), dto.getTittle(), dto.getContent(), dto.getPostedDate(), userProfile, mediaList, location);
        repository.save(article);
        return true;
    }

    @Override
    public ArrayList<ArticleDTO> blogs() throws Exception {
        List<Article> articles = repository.findAll();

        ArrayList<ArticleDTO> articleDTOS = new ArrayList<>();
        for (Article article : articles) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserName(article.getProfile().getUser().getUserName());
            Location location = article.getLocation();
            LocationDTO locationDTO = new LocationDTO();
            List<LocationCategory> locationCategories = location.getLocationCategories();
            List<LocationCategoryDTO> locationCategoryDTOS = new ArrayList<>();
            for (LocationCategory category : locationCategories) {
                LocationCategoryDTO locationCategoryDTO = new LocationCategoryDTO(category.getName(), category.getDiscription());
                locationCategoryDTOS.add(locationCategoryDTO);
            }
            locationDTO.setCategoryDTO(locationCategoryDTOS);
            locationDTO.setLat(location.getLat());
            locationDTO.setLng(location.getLng());
            List<Media> locationImage = location.getImage();
            ArrayList<MediaDTO> locationMedias = new ArrayList<>();
            for (Media media : locationImage) {
                MediaDTO mediaDTO = new MediaDTO(media.getPath());
                locationMedias.add(mediaDTO);
            }
            locationDTO.setLocationImage(locationMedias);
            List<Media> medias = article.getMedia();
            ArrayList<MediaDTO> mediaDTOS = new ArrayList<>();
            for (Media media : medias) {
                MediaDTO mediaDTO = new MediaDTO(media.getPath());
                mediaDTOS.add(mediaDTO);
            }

            ArticleDTO articleDTO = new ArticleDTO(
                    article.getArticleName(),
                    article.getTittle(),
                    article.getContent(),
                    article.getPostedDate(),
                    userDTO,
                    mediaDTOS
            );
            articleDTO.setLocationDTO(locationDTO);
            articleDTOS.add(articleDTO);
        }
        return articleDTOS;
    }

    @Override
    public ArrayList<ArticleDTO> topTenRatedBlogs() throws Exception {
        List<Object[]> objects = repository.ratingBloges();
        for (Object[] object : objects) {
            ArticleDTO articleDTO = new ArticleDTO();
            System.out.println(object[0].toString());
        }
        return null;
    }
}
