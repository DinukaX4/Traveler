package lk.ijse.spring.rest.traveler.repository;

import lk.ijse.spring.rest.traveler.entity.Rating;
import lk.ijse.spring.rest.traveler.entity.Rating_PK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,Rating_PK> {
}
