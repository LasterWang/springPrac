package com.test.beans11.anonation;

import org.springframework.stereotype.Component;

@Component
public class Bike {
	
	private String brand;
	private int speed;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Bike(String brand, int speed) {
		super();
		this.brand = brand;
		this.speed = speed;
	}
	public Bike() {
		super();
	}
}
