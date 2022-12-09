package com.ams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ams.dto.DepartmentDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class DepartmentDTO_Test {
	private static final Logger l = LogManager.getLogger(DepartmentDTO_Test.class);
	private static Validator validator;
	
//	settings.put(Environment.HBM2DDL_AUTO, "create");
//	change HBM2DDL_AUTO to "create" if it is "update"
	
	@BeforeAll
	public static void setUp() {
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	validator = factory.getValidator();
	l.info("validator ready!!!");
	}
	
	//dept name null testing
	@Test
	public void IsDeptNameNullTest() {
	l.info("NEGATIVE TEST CASE...");
	DepartmentDTO dept = new DepartmentDTO(null, "deptHead1");

	Set<ConstraintViolation<DepartmentDTO>> constraintViolations = validator.validate(dept);

	assertEquals(2, constraintViolations.size());
	assertEquals("{dept.id.null_check}", constraintViolations.iterator().next().getMessage());
	}
	
	//dept head name is null testing
	@Test
	public void IsDeptHeadNameNullTest() {
		l.info("NEGATIVE TEST CASE");
		DepartmentDTO dept = new DepartmentDTO("dept1", null);

		Set<ConstraintViolation<DepartmentDTO>> constraintViolations = validator.validate(dept);

		assertEquals(2, constraintViolations.size());
		assertEquals("{dept.head.null_check}", constraintViolations.iterator().next().getMessage());
	}
	
	//dept name Null validation test
	@Test
	public void nameSizeLessThanThreeTest() {
	l.info("NEGATIVE TEST CASE...");
	DepartmentDTO dept = new DepartmentDTO("de", "deptHead1");

	Set<ConstraintViolation<DepartmentDTO>> constraintViolations = validator.validate(dept);

	assertEquals(2, constraintViolations.size());
	assertEquals("{dept.id.null_check}", constraintViolations.iterator().next().getMessage());
	}
	
	//dept head Null validation test
	@Test
	public void DeptHeadSizeTest() {
	l.info("NEGATIVE TEST CASE...");
	DepartmentDTO dept = new DepartmentDTO("dept1", "de");

	Set<ConstraintViolation<DepartmentDTO>> constraintViolations = validator.validate(dept);

	assertEquals(2, constraintViolations.size());
	assertEquals("{dept.id.null_check}", constraintViolations.iterator().next().getMessage());
	}
	
	
}
