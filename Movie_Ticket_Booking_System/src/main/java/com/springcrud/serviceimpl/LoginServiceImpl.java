package com.springcrud.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcrud.entity.Login;
import com.springcrud.repositoy.LoginRepository;
import com.springcrud.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepository lrepo;
	

	@Override
	public Login loginUser(String userName, String password) {
		Login user = lrepo.findByUserNameAndPassword(userName, password);
		return user;
	}

}