package com.ams.util;

import org.modelmapper.ModelMapper;

import com.ams.dto.AdminDTO;
import com.ams.dto.AlumniDTO;
import com.ams.dto.DepartmentDTO;
import com.ams.entity.Admin;
import com.ams.entity.Alumni;
import com.ams.entity.Department;

//this class will convert Entity -> DTO and vice versa
public class Converter {
	private ModelMapper modelMapper = new ModelMapper();

//========================//
//Alumni converter methods//
//========================//
	
	//DTO -> Entity
	public Alumni DTOtoEntity_Alumni(AlumniDTO almDTO) {
		Alumni alm = new Alumni();
		
		if(almDTO != null) {
			//Converting AlumniDTO to Alumni Entity
			alm = modelMapper.map(almDTO, Alumni.class);
			return alm;
		}
		return null;
	}
	
	//Entiry -> DTO
	public AlumniDTO EntitytoDTO_Alumni(Alumni alm) {
		AlumniDTO almDTO = new AlumniDTO();
		
		//Converting Alumni Entity to AlumniDTO
		if(alm != null) {
			almDTO = modelMapper.map(alm, AlumniDTO.class);
			return almDTO;
		}
		return null;
	}
//============================//
//Department converter methods//
//============================//
	//DTO -> Entity
	public Department DTOtoEntity_Dept(DepartmentDTO deptDTO) {
		Department dept = new Department();
		
		if(deptDTO != null) {
			//Converting DepartmentDTO to Department Entity
			dept = modelMapper.map(deptDTO, Department.class);
			return dept;
		}
		return null;
	}
	
	//Entiry -> DTO
	public DepartmentDTO EntitytoDTO_Dept(Department dept) {
		DepartmentDTO deptDTO = new DepartmentDTO();
		
		//Converting Department Entity to DepartmentDTO
		if(dept != null) {
			deptDTO = modelMapper.map(dept, DepartmentDTO.class);
			return deptDTO;
		}
		return null;
	}
//============================//
//Admin converter methods//
//============================//
	//DTO -> Entity
	public Admin DTOtoEntity_Admin(AdminDTO adminDTO) {
		Admin admin = new Admin();
		
		if(adminDTO != null) {
			//Converting AdminDTO to Admin Entity
			admin = modelMapper.map(adminDTO, Admin.class);
		}
		return admin;
	}
	
	//Entiry -> DTO
	public AdminDTO EntitytoDTO_Admin(Admin admin) {
		AdminDTO adminDTO = new AdminDTO();
		
		//Converting Admin Entity to AdminDTO
		if(admin != null) {
			adminDTO = modelMapper.map(admin, AdminDTO.class);
		}
		return adminDTO;
	}
}
