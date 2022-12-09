package com.ms.service;

import com.ms.dto.StudentDto;
import com.ms.entity.Students;
import com.ms.exception.GlobalException;

public interface StudentService {

//	List<StudentDto> fetchStudent() throws GlobalException;
//	
//	StudentIssueDto updateStudentIssues();
	
	void studentRegistration(Students student);
	
	StudentDto fetchStudent(int sroll) throws GlobalException;
	
	void addStudentIssues(int sroll,String issue);
	
}
