package foodie.service;

import foodie.model.Vehicle;

public interface VehicleService {

	Vehicle create(Vehicle vehicle);

	Vehicle update(Vehicle vehicle);

	void delete(Long id);
}
