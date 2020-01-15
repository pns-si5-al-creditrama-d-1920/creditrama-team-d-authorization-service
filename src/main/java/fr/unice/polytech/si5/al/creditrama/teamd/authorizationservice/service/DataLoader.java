package fr.unice.polytech.si5.al.creditrama.teamd.authorizationservice.service;

import fr.unice.polytech.si5.al.creditrama.teamd.authorizationservice.model.OauthClientDetails;
import fr.unice.polytech.si5.al.creditrama.teamd.authorizationservice.repository.OauthClientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private OauthClientDetailsRepository oauthClientDetailsRepository;

    public void run(ApplicationArguments args) {
         OauthClientDetails oauthClientDetails = OauthClientDetails.builder()
                 .client_id("mobile")
                 .client_secret("{bcrypt}$2a$10$gPhlXZfms0EpNHX0.HHptOhoFD1AoxSr/yUIdTqA8vtjeP4zi0DDu")
                 .web_server_redirect_uri("http://localhost:8080/code")
                 .scope("READ,WRITE")
                 .access_token_validity(3600)
                 .refresh_token_validity(1000)
                 .authorized_grant_types("authorization_code,password,refresh_token,implicit")
                 .additional_information("{}").build();
        if(!oauthClientDetailsRepository.existsById(oauthClientDetails.getClient_id())){
            oauthClientDetailsRepository.save(oauthClientDetails);
        }
    }
}