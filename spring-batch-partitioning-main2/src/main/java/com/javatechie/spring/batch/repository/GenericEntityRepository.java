package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericEntityRepository extends JpaRepository<GenericEntity, Long> {
    // Additional query methods if needed
}
