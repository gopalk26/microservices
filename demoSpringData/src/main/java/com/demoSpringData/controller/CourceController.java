package com.demoSpringData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demoSpringData.entity.Cource;
import com.demoSpringData.service.CourceService;

@RestController
public class CourceController {
	
	@Autowired
 private   CourceService   CourceService;
    
	
	
	@GetMapping("/welcome")
	public String demo() {
		return "welcome";
	}
	
	@PostMapping("/Create")
	public  ResponseEntity<String> CreateCource(@RequestBody Cource cource) {
		
		String result =   CourceService.SaveAndUpdate(cource); 
		
		return new ResponseEntity<>( result, HttpStatus.CREATED);
		
		
	}
	
	@PostMapping("/CreateMultiple")
	public List<Cource> CreateCource(@RequestBody List<Cource> cources) {
		
       return  CourceService.SaveAndUpadate(cources);
	
  
	
	}
	
	@GetMapping("/getAllCources")
	public ResponseEntity<List<Cource>>  getAllCources(){
		
		List<Cource> allCource =CourceService.getAllCourses();
		return new ResponseEntity<>( allCource, HttpStatus.OK);
	}

	
	@GetMapping("/cource/{id}")
	public ResponseEntity<Cource> getCource( @PathVariable Integer id){
		
		Cource cource = CourceService.findById(id);
		return new ResponseEntity<>(cource , HttpStatus.OK);


		
		
	}
	
//	@PutMapping("/course")
//	public ResponseEntity<String> updateCourse(@RequestBody Cource course) {
//		String status = CourceService.SaveAndUpadate(course);
//		return new ResponseEntity<>(status, HttpStatus.OK);
//	}

	
	
     @DeleteMapping("/delete/{id}")
     
     public ResponseEntity<String> deleteCource(@PathVariable Integer id){
    	 
    	 
    	 String status = CourceService.deleteById(id);
    	 return new ResponseEntity<>(status,HttpStatus.OK);
    
     }
//     
//     @DeleteMapping("/deleteAll")
//	public ResponseEntity<String> DeleteAll() {
//       String result =  CourceService.deleteAll();
//    return new ResponseEntity<>(result,HttpStatus.OK);
//     }

     
     @DeleteMapping("/deleteAll")
 	public String DeleteAll() {
        String result =  CourceService.deleteAll();
     return result;
      }

}
