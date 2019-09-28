package com.rrn.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@Column(name = "car_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "car_brand")
	private String brand;

	@Column(name = "car_model")
	private String model;

	@Column(name = "car_isAutomatic")
	@Type(type = "numeric_boolean")
	private boolean Automatic;

	@Column(name = "car_hasAc")
	@Type(type = "numeric_boolean")
	private boolean Ac;

	@Column(name = "car_pricePerDay")
	private int pricePerDay;

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isAutomatic() {
		return Automatic;
	}

	public void setAutomatic(boolean isAutomatic) {
		this.Automatic = isAutomatic;
	}

	public boolean isAc() {
		return Ac;
	}

	public void setHasAc(boolean hasAc) {
		this.Ac = hasAc;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	
	
}
