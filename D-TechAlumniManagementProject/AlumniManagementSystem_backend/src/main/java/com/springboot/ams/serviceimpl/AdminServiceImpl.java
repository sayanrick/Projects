package com.springboot.ams.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ams.entity.Admin;
import com.springboot.ams.entity.Alumni;
import com.springboot.ams.entity.Department;
import com.springboot.ams.repository.AdminRepository;
import com.springboot.ams.repository.AlumniRepository;
import com.springboot.ams.repository.DepartmentRepository;
import com.springboot.ams.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService { // service implementation class

	// autowiring the entity repositories to use JpaRespository methods
	@Autowired
	private DepartmentRepository deptRepo;
	@Autowired
	private AlumniRepository alumniRepo;
	@Autowired
	private AdminRepository adminRepo;
	

	@Override
	public Admin createAdmin(Admin admin) {
		// saving admin details using save() of JpaRepository
		Optional<Admin> ad = adminRepo.findById(admin.getAdusername());
		if(ad.isEmpty()) {
			return adminRepo.save(admin);
		}else if(ad.isPresent()) {
			throw new EntityNotFoundException("Admin is already exists");
		}
		return null;
	}

	@Override
	public List<Alumni> fetchAlumnis() {
		// fetching alumni details based on id using findById() of JpaRepository
		return alumniRepo.findAll();
	}

	@Override
	public List<Department> fetchDepartments() {
		// fetching departments details based on id using findAll() of JpaRepository
		return deptRepo.findAll();
	}

	@Override
	public Alumni fetchAlumniByRoll(long alroll) {
		// fetching alumni detail based on id using findById() of JpaRepository
		Alumni alm = alumniRepo.findById(alroll)
							   .orElseThrow(() -> new EntityNotFoundException("Alumni is not exist"));
		
		return alm; 

	}
	
	@Override
	public Admin verifyAdmin(String username, String password) {
		// fetching admin detail based on id using findByAdusernameAndAdpassword() of JpaRepository
		return Optional.of(adminRepo.findByAdusernameAndAdpassword(username, password))
					   .orElseThrow(() -> new EntityNotFoundException("Admin is not exist"));
		
	}

	@Override
	public Admin updateAdmin(String username, Admin admin) {
		// fetching admin by id
		Admin newAdmin = adminRepo.findById(username)
				.orElseThrow(() -> new EntityNotFoundException("Admin not exists"));

		// updating value
		newAdmin.setAdname(admin.getAdname());
		newAdmin.setAdusername(admin.getAdusername());
		newAdmin.setAdpassword(admin.getAdpassword());
		newAdmin.setAdemail(admin.getAdemail());
		
		// saving updated value
		adminRepo.save(newAdmin);
		// returning updated entity
		return newAdmin;
	}
	
	@Override
	public Alumni updateAlumni(long alroll, Alumni alumni) {
		// fetching alumni by id
		Alumni newAlumni = alumniRepo.findById(alroll)
									 .orElseThrow(() -> new EntityNotFoundException("Alumni not exists"));
		
		// updating value
		newAlumni.setAlroll(alumni.getAlroll());
		newAlumni.setAlname(alumni.getAlname());
		newAlumni.setAlemail(alumni.getAlemail());
		newAlumni.setAlphone(alumni.getAlphone());
		newAlumni.setAladdress(alumni.getAladdress());
		newAlumni.setAlpassyear(alumni.getAlpassyear());
		
		// saving updated value
		alumniRepo.save(newAlumni);
		// returning updated entity
		return newAlumni;
	}

	@Override
	public void deleteAdmin(String username) {

		// fetching admin by id
		adminRepo.findById(username)
				 .orElseThrow(() -> new EntityNotFoundException("Admin not exists"));

		// deleting admin by id
		adminRepo.deleteById(username);
	}

	@Override
	public void deleteAlumni(Long alroll) {
		// fetching admin by id
		alumniRepo.findById(alroll)
				  .orElseThrow(() -> new EntityNotFoundException("Alumni not exists"));
		
		// deleting alumni by id
		alumniRepo.deleteById(alroll);
	}

}
