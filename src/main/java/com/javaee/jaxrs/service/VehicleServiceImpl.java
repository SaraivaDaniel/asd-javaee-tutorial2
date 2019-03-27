package com.javaee.jaxrs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.javaee.jaxrs.domain.Vehicle;
import com.javaee.jaxrs.service.VehicleService;

public class VehicleServiceImpl implements VehicleService {

	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private Integer actualId = 9;

	public VehicleServiceImpl() {
		for (int i = 0; i < 10; i++) {
			Vehicle vehicle = new Vehicle();
			vehicle.setId(i);
			vehicle.setName("Subaru " + i);
			vehicle.setYear(2019 - i);
			vehicles.add(vehicle);
		}
	}

	@Override
	public List<Vehicle> getAll() {
		System.out.println(vehicles.size());
		return vehicles;
	}

	@Override
	public Vehicle findById(Integer id) {
		Optional<Vehicle> vehicleOptional = vehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst();
		return vehicleOptional.orElse(null);
	}

	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		if (vehicle.getId() != null) {
			this.deleteById(vehicle.getId());
		} else {
			actualId++;
			vehicle.setId(actualId);
		}
		this.vehicles.add(vehicle);
		System.out.println(vehicle.getId());
		return vehicle;
	}

	@Override
	public void deleteById(Integer id) {
		this.vehicles.removeIf(vehicle -> vehicle.getId().equals(id));
	}

}
