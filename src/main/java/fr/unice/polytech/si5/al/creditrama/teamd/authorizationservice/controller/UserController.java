package fr.unice.polytech.si5.al.creditrama.teamd.authorizationservice.controller;

import fr.unice.polytech.si5.al.creditrama.teamd.authorizationservice.model.User;
import fr.unice.polytech.si5.al.creditrama.teamd.authorizationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class UserController {
    UserService userDetailService;

    @Autowired
    public UserController(UserService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping("/user/me")
    public Authentication user(Authentication principal) {
        return principal;
    }

    @GetMapping("/user/me/id")
    public int userId(Authentication principal) {
        Optional<User> user =userDetailService.findUserByName(principal.getName());
        if(user.isPresent()){
            return user.get().getUserId();
        }
        return 0;
    }
}