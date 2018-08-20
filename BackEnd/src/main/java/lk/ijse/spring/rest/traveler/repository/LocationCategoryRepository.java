package lk.ijse.spring.rest.traveler.repository;

import lk.ijse.spring.rest.traveler.entity.LocationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationCategoryRepository extends JpaRepository<LocationCategory,String> {
}
