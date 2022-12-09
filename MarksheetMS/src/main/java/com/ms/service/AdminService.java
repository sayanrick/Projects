package com.ms.service;

import java.util.List;

import com.ms.dto.StudentDto;
import com.ms.dto.StudentIssueDto;
import com.ms.entity.Admin;
import com.ms.entity.Marks;
import com.ms.exception.GlobalException;

public interface AdminService {

//	void addAlldetails(AdminDto admindto);
//	
//	List<StudentDto> fetchStudent(int sroll) throws GlobalException;
//	
//	List<StudentIssueDto> fetchStudentsissues(int sroll) throws GlobalException;
//	
//	AdminDto changePassword(int loginid, String adpassword) throws GlobalException;
//	
//	StudentDto updateStudent(Students student) throws GlobalException;
//	
//	void deleteStudent(int sroll);
	
	
	void addAdmin(Admin admin);
	
	void addMarks(int sroll,Marks marks);
	
	StudentDto fetchStudent(int sRoll) throws GlobalException;
	
	StudentDto updateStudent(int sroll,int marks,int press) throws GlobalException;
	
	List<StudentIssueDto> fetchStudentsissues() throws GlobalException;
	
	void deleteStudent(int sroll);
	
}
