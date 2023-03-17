package com.example.itlittlecrm.repo;

import com.example.itlittlecrm.models.Building;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuildingRepository extends CrudRepository<Building, Long> {
    List<Building> findByBuildingNameContains(String buildingName);
    Building findByBuildingName(String buildingName);
}
