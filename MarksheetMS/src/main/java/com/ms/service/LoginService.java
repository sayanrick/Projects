package com.ms.service;

import com.ms.dto.AdminDto;
import com.ms.dto.StudentDto;
import com.ms.exception.GlobalException;

public interface LoginService {

//	void adminLogin(int loginid, String adpassword);
//	
//	void studentLogin(int sroll, String spassword);
	
	AdminDto adminLogin(Integer loginId,String password) throws GlobalException;
	
	StudentDto studentLogin(Integer sroll,String password) throws GlobalException;
	
}
