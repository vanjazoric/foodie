package oauth2.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import oauth2.authserver.entity.CustomClientDetails;

@Repository
public interface ClientDetailsRepository extends JpaRepository<CustomClientDetails, Integer> {

	CustomClientDetails findByClientId(String clientId);
}
