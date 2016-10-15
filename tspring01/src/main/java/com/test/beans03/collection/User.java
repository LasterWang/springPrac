package com.test.beans03.collection;

import java.util.Map;

public class User {
	public String name;
	public Map<String,Bike> bikeMap;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Bike> getBikeMap() {
		return bikeMap;
	}
	public void setBikeMap(Map<String, Bike> bikeMap) {
		this.bikeMap = bikeMap;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", bikeMap=" + bikeMap + "]";
	}
	
}
