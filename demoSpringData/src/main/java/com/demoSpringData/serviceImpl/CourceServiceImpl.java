package com.demoSpringData.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoSpringData.entity.Cource;
import com.demoSpringData.repository.CourceRepository;
import com.demoSpringData.service.CourceService;

@Service
public class CourceServiceImpl  implements CourceService{

	 @Autowired
   private  CourceRepository  courceRepository;
	 
	 
	 @Override
	 public String SaveAndUpdate(Cource cource) {
		  courceRepository.save(cource);
	 	return "success";
	 }


	 
	 
	 @Override
	 public List<Cource> SaveAndUpadate(List<Cource> cources) {
	            
	return 	 courceRepository.saveAll(cources);
	 	
	 }



@Override
public List<Cource> getAllCourses() {
	
	return courceRepository.findAll();
		
}


public Cource findById(Integer id) {
  Optional<Cource> findByid =  courceRepository.findById(id);    
    if(findByid.isPresent()) {
    	return findByid.get();
    }
	return null;
}

@Override
public String deleteById(Integer id) {
	
	if(courceRepository.existsById(id)) {
		courceRepository.deleteById(id);
		return "delete Success";
	
	} 
	else {
	       return "record not found";
	}
       
	}

  @Override
public String deleteAll() {
	courceRepository.deleteAll();
	return "deleted all records succefully";
}







}
