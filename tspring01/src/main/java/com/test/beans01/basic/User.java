package com.test.beans01.basic;

public class User {
	public User() {
		System.out.println("user's constructor");
	}
	public String name;
	
	public void setName(String name) {
		System.out.println("user's set");
		this.name = name;
	}

	public void sayHi()
	{
		System.out.println("hello "+this.name);
	}
	
	
}
