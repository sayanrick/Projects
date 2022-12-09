package com.springcrud.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcrud.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{
	public Login findByUserNameAndPassword(String userName, String password);
}
