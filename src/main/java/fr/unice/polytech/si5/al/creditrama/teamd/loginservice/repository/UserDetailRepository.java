package fr.unice.polytech.si5.al.creditrama.teamd.loginservice.repository;

import fr.unice.polytech.si5.al.creditrama.teamd.loginservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
