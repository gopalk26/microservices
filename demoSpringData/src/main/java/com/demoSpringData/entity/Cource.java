package com.demoSpringData.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cource {
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	String name;
	String courceName;
	Double courceFee;
	String InstituteName;
	public Cource() {
		super();
	}
	public Cource(Integer id, String name, String courceName, Double courceFee, String instituteName) {
		super();
		Id = id;
		this.name = name;
		this.courceName = courceName;
		this.courceFee = courceFee;
		this.InstituteName = instituteName;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourceName() {
		return courceName;
	}
	public void setCourceName(String courceName) {
		this.courceName = courceName;
	}
	public Double getCourceFee() {
		return courceFee;
	}
	public void setCourceFee(Double courceFee) {
		this.courceFee = courceFee;
	}
	public String getInstituteName() {
		return InstituteName;
	}
	public void setInstituteName(String instituteName) {
		this.InstituteName = instituteName;
	}

	
	

}
