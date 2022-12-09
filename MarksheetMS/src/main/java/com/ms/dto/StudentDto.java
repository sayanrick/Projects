package com.ms.dto;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.ms.entity.Marks;
import com.ms.entity.StudentsIssues;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class StudentDto {

	// roll no validation
	@NotNull(message = "{std.roll.null_Check}")
	@Digits(integer = 12, fraction = 0, message = "{std.roll.digits_check}")
	@Positive(message = "{std.roll.positive_check}")
	private int sroll;

	// password validation
	@NotNull(message = "{std.pass.null_Check}")
	@Size(min = 3, max = 10, message = "{std.pass.size_check}")
	private String password;

	// name validation
	@NotNull(message = "{std.name.null_Check}")
	@Size(min = 5, max = 25, message = "{std.name.size_check}")
	private String sname;

	// address validation
	@NotNull(message = "{std.address.null_Check}")
	@Size(min = 5, max = 35, message = "{std.address.size_check}")
	private String saddress;

	// conatct validation
	@NotNull(message = "{std.contact.null_Check}")
	@Digits(integer = 12, fraction = 0, message = "{std.contact.digits_check}")
	@Positive(message = "{std.contact.positive_check}")
	private long scontact;

	// email validation
	@NotNull(message = "{std.email.null_Check}")
	@Size(min = 5, max = 25, message = "{std.email.size_check}")
	@Email(message = "{std.email.pattern_check}")
	private String semail;

	// department validation
	@NotNull(message = "{std.dept.null_Check}")
	@Size(min = 5, max = 12, message = "{std.dept.size_check}")
	private String sDept;

	// UniDirectional OneToOne relationship with marks class with join cloumn mid
	@OneToOne(targetEntity = Marks.class)
	@JoinColumn(name = "mid")
	private Marks marks;

	// Bidirectional OneToMany relationship with studnetissues class
	@OneToMany(targetEntity = StudentsIssues.class)
	private List<StudentsIssues> studentsissues;
}
