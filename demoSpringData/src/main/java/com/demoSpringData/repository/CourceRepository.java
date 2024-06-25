package com.demoSpringData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoSpringData.entity.Cource;

@Repository

public interface CourceRepository   extends JpaRepository<Cource ,Integer> {

}
