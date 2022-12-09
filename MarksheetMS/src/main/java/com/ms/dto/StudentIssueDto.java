package com.ms.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.ms.entity.Students;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class StudentIssueDto {

	//id validation
	@NotNull(message="{stdissue.id.null_check}")
	@Digits(integer = 5, fraction = 0, message="{stdissue.id.digits_check}")
	@Positive(message="{stdissue.id.positive_check}")
	private int iid;
	
	// issue validation
	@NotNull(message = "{stdissue.issue.null_check}")
	@Size(min = 5, max = 150, message = "{stdissue.isse.size_check}")
	private String issue;

	// ManyToOne BiDirectional relationship with Students class
	@ManyToOne(targetEntity = Students.class)
	@JoinColumn
	private Students students;
}
