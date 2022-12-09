package com.ms.dao;

import com.ms.entity.Admin;
import com.ms.entity.Students;

public interface LoginDao {

	Admin adminLogin(Integer loginId, String password);

	Students studentLogin(Integer sroll, String password);

}
