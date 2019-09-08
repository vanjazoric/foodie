package foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import foodie.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
