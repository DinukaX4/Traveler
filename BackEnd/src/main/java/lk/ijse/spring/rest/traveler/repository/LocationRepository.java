package lk.ijse.spring.rest.traveler.repository;

import lk.ijse.spring.rest.traveler.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location,Integer>{

    @Query(value="select l from Location l")
    List<Location> mostUseLocation();
}
