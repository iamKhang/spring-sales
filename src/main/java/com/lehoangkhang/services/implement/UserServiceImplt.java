package com.lehoangkhang.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lehoangkhang.models.User;
import com.lehoangkhang.repository.UserRepository;
import com.lehoangkhang.services.UserService;

@Service
public class UserServiceImplt implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}
	
	

}
