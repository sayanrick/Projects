package com.ams.dao;

import java.util.List;

import com.ams.entity.Alumni;

public interface AlumniDAO {
	
	void addAlumni(Alumni alumni);
	
	List<Alumni> fetchAlumni(long alroll, String alpassword);
	
	Alumni changePassword(long alroll, String alpassword, Alumni alumni);
}
