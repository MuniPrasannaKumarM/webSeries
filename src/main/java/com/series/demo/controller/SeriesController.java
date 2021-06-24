package com.series.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.series.demo.Dao.Series_Dao;
import com.series.demo.model.Series_model;
@RestController
public class SeriesController {

	@Autowired
	private Series_Dao repo;
	
	@PostMapping("/addSeries")
	@ResponseBody
	public String addSeries(@RequestBody Series_model model)
	{
		repo.save(model);
		return "Inserted";
	}
	
	
	@GetMapping("/series")
	@ResponseBody
	public List<Series_model> getAllSeries()
	{
		return repo.findAll();
	}
	
	@GetMapping("/series/id/{id}")
	@ResponseBody
	public Optional<Series_model> getSeriesById(@PathVariable("id") int id)
	{
		return repo.findById(id);
	}
	
	@GetMapping("/series/name/{name}")
	@ResponseBody
	public Optional<Series_model> getSeriesByName(@PathVariable("name") String name)
	{
		return repo.findByName(name);
	}
	
	@PutMapping("/update")
	@ResponseBody
	public String update(@RequestBody Series_model model)
	{
		repo.save(model);
		return "updated";
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") int id)
	{
		String result = "Series Removed ! "+id;
		repo.deleteById(id);
		return result;
	}
}

