package com.series.demo.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.series.demo.model.Series_model;

public interface Series_Dao extends JpaRepository<Series_model,Integer> {

	Optional<Series_model> findByName(String name);
}
 