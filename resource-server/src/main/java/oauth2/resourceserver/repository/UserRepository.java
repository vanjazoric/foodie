package oauth2.resourceserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import oauth2.resourceserver.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
