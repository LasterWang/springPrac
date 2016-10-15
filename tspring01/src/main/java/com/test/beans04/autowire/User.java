package com.test.beans04.autowire;

public class User {
	private String name;
	private Bike bike;
	private Address address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bike getBike() {
		return bike;
	}
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", bike=" + bike + ", address=" + address + "]";
	}
	
}
