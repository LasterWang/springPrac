package com.test.beans11.anonation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.test.beans11.anonation.repository.UserRepository;

@Service
public class UserService {
	
	//������������Ʊ����UserRepository ��һ��ʵ���������õ�����һ�£������޷����ע��
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("userRepositoryImpl")
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public void add()
	{
		System.out.println("user service add...");
		userRepository.save();
	}
}
