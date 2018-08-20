package lk.ijse.spring.rest.traveler.service.impl;

import lk.ijse.spring.rest.traveler.dto.ArticleDTO;
import lk.ijse.spring.rest.traveler.dto.MediaDTO;
import lk.ijse.spring.rest.traveler.dto.RatingDTO;
import lk.ijse.spring.rest.traveler.entity.*;
import lk.ijse.spring.rest.traveler.repository.RatingRepository;
import lk.ijse.spring.rest.traveler.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;


    @Override
    public boolean rate(RatingDTO dto) throws Exception {
        User user = new User();
        user.setUserName(dto.getUserName());
        ArticleDTO articleDTO = dto.getArticleDTO();

        UserProfile_PK userProfile_pk = new UserProfile_PK(articleDTO.getUserDTO().getUserName());
        UserProfile userProfile = new UserProfile();
        userProfile.setUserProfile_pk(userProfile_pk);
        ArrayList<MediaDTO> medias = articleDTO.getMedias();
        ArrayList<Media> mediaList = new ArrayList<>();
        for (MediaDTO media : medias) {
            Media media1 = new Media();
            media1.setPath(media.getPath());
            Media_PK media_pk = new Media_PK(articleDTO.getArticleName(), media.getPath());
            media1.setMedia_pk(media_pk);
            mediaList.add(media1);
        }

        Location_PK location_pk = new Location_PK(articleDTO.getLocationDTO().getLat(), articleDTO.getLocationDTO().getLng());
        Location location = new Location();
        location.setLocation_pk(location_pk);

        Article article = new Article(articleDTO.getArticleName(), articleDTO.getTittle(), articleDTO.getContent(), articleDTO.getPostedDate(), userProfile, mediaList, location);
        Rating_PK rating_pk = new Rating_PK(dto.getUserName(), articleDTO.getArticleName());
        Rating rating = new Rating(dto.getUserName(), articleDTO.getArticleName(), user, article, dto.getStar(), dto.getRatedDay(), rating_pk);
        ratingRepository.save(rating);
        return true;
    }
}
