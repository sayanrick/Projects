package com.ms.dao;

import com.ms.entity.Students;

public interface StudentsDao {

	void studentRegistration(Students student);

	Students fetchStudent(int sroll);

	void addStudentIssues(int sroll, String issue);
}
