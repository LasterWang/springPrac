package com.test.beans11.anonation.repository;

import org.springframework.stereotype.Repository;

@Repository("userRepository2")
public class UserRepositoryImpl2 implements UserRepository {

	public void save() {
		System.out.println("UserRepository save...");
	}

}
