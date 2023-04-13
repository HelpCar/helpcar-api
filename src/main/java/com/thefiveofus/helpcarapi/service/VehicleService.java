package com.thefiveofus.helpcarapi.service;


import com.thefiveofus.helpcarapi.model.Vehicle;
import com.thefiveofus.helpcarapi.repository.VehicleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleService {
    private final VehicleRepo  vehicleRepo;

    public void createVehicle(Vehicle vehicle){
        vehicle = Vehicle.builder()
                .type(vehicle.getType())
                .model(vehicle.getModel())
                .manufacture(vehicle.getManufacture())
                .manufacturedYear(vehicle.getManufacturedYear())
                .powerSource(vehicle.getPowerSource())
                .transmission(vehicle.getTransmission())
                .userEmail(vehicle.getUserEmail())
                .build();

        vehicleRepo.save(vehicle);
        log.info("Vehicle {} is saved", vehicle.getId());

    }

    public List<Vehicle> getAllVehicles(String email) {
        List<Vehicle> vehicles = vehicleRepo.findAll();
        List<Vehicle> myList = new ArrayList<Vehicle>();
        for (int i = 0; i < vehicles.size(); i++) {
            if(vehicles.get(i).getUserEmail().equals(email)) {
                myList.add(vehicles.get(i));
            }
        }
        return myList;
    }

    public Optional<Vehicle> getSingleVehicle(String id) {
        Optional<Vehicle> vehicles = vehicleRepo.findById(id);
        return vehicles;
    }

    public void updateSingleVehicle(String id,Vehicle vehicle) {
        Optional<Vehicle> updatedVehicle = vehicleRepo.findById(id);
        Vehicle updated=updatedVehicle.get();
        updated.setType(vehicle.getType());
        updated.setManufacture(vehicle.getManufacture());
        updated.setModel(vehicle.getModel());
        updated.setManufacturedYear(vehicle.getManufacturedYear());
        updated.setPowerSource(vehicle.getPowerSource());
        updated.setTransmission(vehicle.getTransmission());

        vehicleRepo.save(updated);
        log.info("Vehicle {} is updated", vehicle.getId());
    }
}
