package com.natan.alelotest.service;

import com.natan.alelotest.DTO.VehicleDTO;
import com.natan.alelotest.exception.DataIntegrityViolationException;
import com.natan.alelotest.exception.ResourceNotFoundException;
import com.natan.alelotest.model.Vehicle;
import com.natan.alelotest.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle findById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        return vehicle.orElseThrow(() -> new ResourceNotFoundException("veículo não encontrado! Id:" + id));
    }



    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public List<Vehicle> findByPlate(String plate) {
        return vehicleRepository.listByPlate(plate);
    }

    public List<Vehicle> findByStatus(Boolean status) {
        return vehicleRepository.listByStatus(status);
    }

    public Page<Vehicle> findAll(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }


    public Vehicle create(Vehicle vehicle) {
        vehicle.setId(null);
        return vehicleRepository.save(vehicle);
    }

    public Vehicle update(Long id, VehicleDTO vehicleDTO) {
        Vehicle vehicle = findById(id);
        vehicle.setStatus(vehicleDTO.getStatus());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setPlate(vehicleDTO.getPlate());
        vehicle.setManufacturer(vehicleDTO.getManufacturer());
        vehicle.setColor(vehicleDTO.getColor());

        return vehicleRepository.save(vehicle);
    }

    public void delete(Long id) {
        findById(id);
        try {
            vehicleRepository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Veículo não pode ser deletado! Verifique se a informação não está sendo utilizada.");
        }
    }


}
