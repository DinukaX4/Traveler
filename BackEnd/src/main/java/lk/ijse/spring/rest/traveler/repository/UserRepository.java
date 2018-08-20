package lk.ijse.spring.rest.traveler.repository;

import lk.ijse.spring.rest.traveler.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
