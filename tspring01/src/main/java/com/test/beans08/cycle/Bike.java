package com.test.beans08.cycle;

public class Bike {
	
	private String brand;
	private int speed;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
		System.out.println("setter method..");
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
		System.out.println("constructor with 2 param....");
	}
	public Bike() {
		super();
		System.out.println("constructor with 0 param....");
	}
	public void init(){
		System.out.println("init method...");
	}
	public void destroy()
	{
		System.out.println("destroy method...");
	}
	
}
