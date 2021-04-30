package com.natan.alelotest.DTO;

import com.natan.alelotest.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO  extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long key;

    private String plate;
    private String model;
    private String manufacturer;
    private String color;
    private Boolean status;

    public VehicleDTO(Vehicle vehicle) {

        this.key = vehicle.getId();
        this.plate = vehicle.getPlate();
        this.model = vehicle.getModel();
        this.manufacturer = vehicle.getManufacturer();
        this.color = vehicle.getColor();
        this.status = vehicle.getStatus();
    }
}
