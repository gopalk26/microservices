package com.demoSpringData.service;

import java.util.List;

import com.demoSpringData.entity.Cource;


public interface CourceService {
	
	
	public String SaveAndUpdate(Cource cource);
	
	public  List<Cource> SaveAndUpadate(List<Cource> cources);
	
	public Cource findById(Integer id);

	public List<Cource> getAllCourses();
	public String deleteById(Integer id);
	
	public String deleteAll();
	

	
	
	
	
}