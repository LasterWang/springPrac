package com.test.beans11.anonation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.beans01.basic.Test;

//@Repository("userRepository")
@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired(required=false)//使用required参数的false值表示该属性为非必要注入属性，如果容器中没有，则直接置为null
	private Test te;
	public void save() {
		System.out.println("UserRepository save...");
		System.out.println(te);
	}

}
