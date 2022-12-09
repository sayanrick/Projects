package com.ms.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ms.dao.AdminDao;
import com.ms.daoimpl.AdminDaoimpl;
import com.ms.dto.StudentDto;
import com.ms.dto.StudentIssueDto;
import com.ms.entity.Admin;
import com.ms.entity.Marks;
import com.ms.entity.Students;
import com.ms.entity.StudentsIssues;
import com.ms.exception.GlobalException;
import com.ms.service.AdminService;
import com.ms.util.Converter;

public class AdminServiceImpl implements AdminService {
	// declaring globally so each method can have access of these objects
	Converter converter = new Converter();
	AdminDao adminDao = new AdminDaoimpl();
	private static final Logger logger = LogManager.getLogger(AdminServiceImpl.class);

	@Override
	public void addAdmin(Admin admin) {
		adminDao.addAdmin(admin);
		logger.info("new admin A/c created " + admin + " and creation time is " + new java.util.Date());

	}

	@Override
	public void addMarks(int sroll, Marks marks) {
		adminDao.addMarks(sroll, marks);
		logger.info("marks added successfully " + " and creation time is " + new java.util.Date());

	}

	@Override
	public StudentDto fetchStudent(int sRoll) throws GlobalException {
		Students students = adminDao.fetchStudent(sRoll);
		logger.info("Student data fetched " + " and time is " + new java.util.Date());

		// converting to DTO
		StudentDto adminDTO = converter.EntitytoDTO_Students(students);

		// null validation and returning
		return Optional.of(adminDTO).orElseThrow(() -> new GlobalException("Department does not exists"));
	}

	@Override
	public StudentDto updateStudent(int sroll, int marks, int press) throws GlobalException {
		Students students = adminDao.updateStudent(sroll, marks, press);
		logger.info("Student data updated " + " and time is " + new java.util.Date());

		// converting to DTO
		StudentDto adminDTO = converter.EntitytoDTO_Students(students);

		// null validation and returning
		return Optional.of(adminDTO).orElseThrow(() -> new GlobalException("Department does not exists"));
	}

	//@Override
	//public List<StudentIssueDto> fetchStudentsissues() throws GlobalException {
		//List<StudentsIssues> studentIssues = adminDao.fetchStudentsissues();
		//logger.info("department data fetched " + " and time is " + new java.util.Date());

		// converting list of department into list of departmentDTO
	//	List<StudentIssueDto> studentIssueDto = studentIssues.stream().map(x -> converter.EntitytoDTO_StudentIssue(x))
			//	.collect(Collectors.toList());

		// null validation and returning
		//return Optional.of(studentIssueDto).orElseThrow(() -> new GlobalException("Department does not exists"));
	//}

	@Override
	public void deleteStudent(int sroll) {
		adminDao.deleteStudent(sroll);
		logger.info(sroll + "alumni account deleted and time is " + new java.util.Date());

	}

	@Override
	public List<StudentIssueDto> fetchStudentsissues() throws GlobalException {
		// TODO Auto-generated method stub
		return null;
	}

}
