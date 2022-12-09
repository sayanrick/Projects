package com.ams.service;

import java.util.List;

import com.ams.dto.AlumniDTO;
import com.ams.entity.Alumni;
import com.ams.exception.GlobalException;

public interface AlumniService {
	
	void addAlumni(Alumni alumni);
	
	List<AlumniDTO> fetchAlumni(long alroll, String alpassword) throws GlobalException;
	
	AlumniDTO changePassword(long alroll, String alpassword, Alumni alumni) throws GlobalException;
	
}
