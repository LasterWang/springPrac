package com.test.beans03.collection;

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
	@Override
	public String toString() {
		return "Bike [brand=" + brand + ", speed=" + speed + "]";
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
