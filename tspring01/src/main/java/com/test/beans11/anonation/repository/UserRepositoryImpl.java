package com.test.beans11.anonation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.beans01.basic.Test;

//@Repository("userRepository")
@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired(required=false)//ʹ��required������falseֵ��ʾ������Ϊ�Ǳ�Ҫע�����ԣ����������û�У���ֱ����Ϊnull
	private Test te;
	public void save() {
		System.out.println("UserRepository save...");
		System.out.println(te);
	}

}
