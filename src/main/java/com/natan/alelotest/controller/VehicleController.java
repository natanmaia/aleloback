package com.natan.alelotest.controller;

import com.natan.alelotest.DTO.VehicleDTO;
import com.natan.alelotest.model.Vehicle;
import com.natan.alelotest.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping({"/vehicles"})
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vehicle> findById(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.findById(id);
        return ResponseEntity.ok().body(vehicle);
    }

    @GetMapping(value = "/filter")
    public ResponseEntity<List<Vehicle>> findByFilter(@RequestParam(required = false) String plate, @RequestParam(required = false) Boolean status) {
        if (!plate.isEmpty()){
            return ResponseEntity.ok().body(vehicleService.findByPlate(plate));
        }
        else {
            return ResponseEntity.ok().body(vehicleService.findByStatus(status));
        }
    }

//    @GetMapping
//    public ResponseEntity<List<VehicleDTO>> findAll() {
//        List<Vehicle> categories = vehicleService.findAll();
//        List<VehicleDTO> vehicleDTOS = categories.stream().map(VehicleDTO::new).collect(Collectors.toList());
//
//        return ResponseEntity.ok().body(vehicleDTOS);
//    }

    @GetMapping
    public ResponseEntity<Page<Vehicle>> findAll(Pageable pageable){
        return ResponseEntity.ok(vehicleService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle) {
        vehicle = vehicleService.create(vehicle);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vehicle.getId()).toUri();

        return ResponseEntity.created(uri).body(vehicle);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VehicleDTO> update(@PathVariable Long id, @RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleService.update(id, vehicleDTO);

        return ResponseEntity.ok().body(new VehicleDTO(vehicle));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehicleService.delete(id);

        return ResponseEntity.noContent().build();

    }



}
