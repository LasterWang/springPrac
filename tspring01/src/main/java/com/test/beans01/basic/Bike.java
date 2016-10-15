package com.test.beans01.basic;

public class Bike {
	public Bike() {
		super();
	}
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
	
}
