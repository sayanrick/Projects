package com.ms.util;

import org.modelmapper.ModelMapper;

import com.ms.dto.AdminDto;
import com.ms.dto.MarksDto;
import com.ms.dto.StudentDto;
import com.ms.dto.StudentIssueDto;
import com.ms.entity.Admin;
import com.ms.entity.Marks;
import com.ms.entity.Students;
import com.ms.entity.StudentsIssues;

public class Converter {

	private ModelMapper modelMapper = new ModelMapper();

// ------------------------------------ Admin Coneverter ------------------------------------

	// DTO -> Entity
	public Admin DTOtoEntity_Admin(AdminDto adminDTO) {
		Admin admin = new Admin();

		if (adminDTO != null) {
			// Converting AdminDTO to Admin Entity
			admin = modelMapper.map(adminDTO, Admin.class);
		}
		return admin;
	}

	// Entiry -> DTO
	public AdminDto EntitytoDTO_Admin(Admin admin) {
		AdminDto adminDTO = new AdminDto();

		// Converting Admin Entity to AdminDTO
		if (admin != null) {
			adminDTO = modelMapper.map(admin, AdminDto.class);
		}
		return adminDTO;
	}


// ------------------------------------ Marks Coneverter ------------------------------------
	// DTO -> Entity
	public Marks DTOtoEntity_Marks(MarksDto marksdto) {

		Marks marks = new Marks();

		if (marksdto != null) {
			// Converting MarksDto to Marks
			marks = modelMapper.map(marksdto, Marks.class);
		}

		return marks;

	}

	// Entiry -> DTO
	public MarksDto EntitytoDTO_Marks(Marks marks) {

		MarksDto marksDto = new MarksDto();

		// Converting Marks Entity to MarksDto
		if (marks != null) {
			marksDto = modelMapper.map(marks, MarksDto.class);
		}

		return marksDto;

	}

// ------------------------------------ Students Coneverter ------------------------------------
	// DTO -> Entity
	public Students DTOtoEntity_Students(StudentDto studentdto) {

		Students students = new Students();

		if (studentdto != null) {
			// Converting StudnetDto to Students
			students = modelMapper.map(studentdto, Students.class);
		}

		return students;

	}

	// Entiry -> DTO
	public StudentDto EntitytoDTO_Students(Students students) {

		StudentDto studentdto = new StudentDto();

		if (students != null) {
			// Converting Students to StudnetDto
			studentdto = modelMapper.map(students, StudentDto.class);
		}

		return studentdto;

	}

// ------------------------------------ StudebtIsuues Coneverter ------------------------------------
	// DTO -> Entity
	public StudentsIssues DTOtoEntity_StudentsIssues(StudentIssueDto stdissuedto) {

		StudentsIssues stdissues = new StudentsIssues();

		if (stdissuedto != null) {
			// Converting StudentIssueDto to StudentsIssues
			stdissues = modelMapper.map(stdissuedto, StudentsIssues.class);
		}

		return stdissues;

	}

	// Entiry -> DTO
	public StudentIssueDto DTOtoEntity_StudentIssueDto(StudentsIssues stdissues) {

		StudentIssueDto stdissuedto = new StudentIssueDto();

		if (stdissues != null) {
			// Converting StudentsIssues to StudentIssueDto
			stdissuedto = modelMapper.map(stdissues, StudentIssueDto.class);
		}

		return stdissuedto;

	}

}
