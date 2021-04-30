package com.natan.alelotest.controller;

import com.natan.alelotest.service.VehicleService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
public class VehicleControllerTest {

    @InjectMocks
    private VehicleController vehicleController;
    @Mock
    private VehicleService vehicleService;
    @Test
    void Test(){

    }
}