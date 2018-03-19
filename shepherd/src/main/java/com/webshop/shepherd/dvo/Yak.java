package com.webshop.shepherd.dvo;

import javax.xml.bind.annotation.XmlAttribute;

import com.webshop.shepherd.common.ItemProducer;

public class Yak implements ItemProducer  {
	
	
	//The name given to the Yak
	private String name;
	
	// The age of the yak 
	private Float age;
	
	private String sex;
	
	//Used to store the last shave day;
	private Float ageLastShaved;
	
	public Yak() {
		ageLastShaved = age;
	}

	public Yak(String name, Float age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.ageLastShaved = age;
	}

	@XmlAttribute(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(name="age")
	public Float getAge() {
		return age;
	}

	public void setAge(Float age) {
		this.age = age;
		if (ageLastShaved == null) {
			ageLastShaved = age;
		}
	}

	@XmlAttribute(name="sex")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Float getAgeLastShaved() {
		return ageLastShaved;
	}

	public void setAgeLastShaved(Float ageLastShaved) {
		this.ageLastShaved = ageLastShaved;
	}
	

	
	
	


}
