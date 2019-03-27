package com.javaee.jaxrs.service;

import java.util.List;

import com.javaee.jaxrs.domain.Vehicle;

public interface VehicleService {

	List<Vehicle> getAll();

	Vehicle findById(Integer id);

	Vehicle saveVehicle(Vehicle vehicle);

	void deleteById(Integer id);

}
