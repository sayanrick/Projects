package com.ms.dao;


import com.ms.entity.Admin;
import com.ms.entity.Marks;
import com.ms.entity.Students;



public interface AdminDao {

	void addAdmin(Admin admin);

	void addMarks(int sroll, Marks marks);

	Students fetchStudent(int sRoll);

	Students updateStudent(int sroll, int marks, int press);

	Students fetchStudentsissues(int sroll);

	void deleteStudent(int sroll);

}
