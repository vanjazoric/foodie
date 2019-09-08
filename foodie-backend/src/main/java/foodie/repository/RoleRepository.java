package foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import foodie.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);
}
