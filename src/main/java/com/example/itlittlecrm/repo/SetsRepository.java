package com.example.itlittlecrm.repo;
import com.example.itlittlecrm.models.Products;
import com.example.itlittlecrm.models.Sets;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SetsRepository extends CrudRepository<Sets, Long> {
    List<Sets> findByProductsContains(Products products);
}
