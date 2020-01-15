package fr.unice.polytech.si5.al.creditrama.teamd.authorizationservice.repository;

import fr.unice.polytech.si5.al.creditrama.teamd.authorizationservice.model.OauthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthClientDetailsRepository  extends JpaRepository<OauthClientDetails, String > {
}
