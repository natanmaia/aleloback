package com.natan.alelotest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    private String plate;
    private String model;
    private String manufacturer;
    private String color;
    private Boolean status;
}
