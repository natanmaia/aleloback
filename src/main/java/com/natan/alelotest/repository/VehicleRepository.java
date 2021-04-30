package com.natan.alelotest.repository;

import com.natan.alelotest.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("from Vehicle where plate like concat(?1, '%') ")
    List<Vehicle> listByPlate(String plate);

    @Query("from Vehicle where status = ?1 ")
    List<Vehicle> listByStatus(Boolean status);
}
