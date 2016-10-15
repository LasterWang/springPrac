package com.test.beans02.property;

import java.util.List;

public class User {
	public String name;
	public List<Bike> bikeList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Bike> getBikeList() {
		return bikeList;
	}
	public void setBikeList(List<Bike> bikeList) {
		this.bikeList = bikeList;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", bikeList=" + bikeList + "]";
	}
	
}
