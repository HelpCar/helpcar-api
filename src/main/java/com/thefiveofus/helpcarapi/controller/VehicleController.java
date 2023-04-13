package com.thefiveofus.helpcarapi.controller;


import com.thefiveofus.helpcarapi.model.Vehicle;
import com.thefiveofus.helpcarapi.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String registerUser(@RequestBody Vehicle vehicle){
        vehicleService.createVehicle(vehicle);
        return "Vehicle created Successfully!";
    }

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public List<Vehicle> getAllVehilces(@PathVariable String email){
        return vehicleService.getAllVehicles(email);
    }

    @GetMapping("/single/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Vehicle> getSingleVehicle(@PathVariable String id){
        return vehicleService.getSingleVehicle(id);
    }

    @PutMapping("/single/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateSingleVehilce(@PathVariable String id,@RequestBody Vehicle vehicle){
        vehicleService.updateSingleVehicle(id,vehicle);
        return "Vehicle updated Successfully!";
    }


}
