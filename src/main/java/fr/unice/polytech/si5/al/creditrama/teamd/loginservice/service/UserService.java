package fr.unice.polytech.si5.al.creditrama.teamd.loginservice.service;

import fr.unice.polytech.si5.al.creditrama.teamd.loginservice.model.User;
import fr.unice.polytech.si5.al.creditrama.teamd.loginservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserByName(String name) {
        return userRepository.findByUsername(name);
    }
}
