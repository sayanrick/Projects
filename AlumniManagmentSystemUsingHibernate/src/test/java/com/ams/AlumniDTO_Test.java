package com.ams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ams.dto.AlumniDTO;
import com.ams.entity.Department;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class AlumniDTO_Test {
	private static final Logger l = LogManager.getLogger(AlumniDTO_Test.class);
	private static Validator validator;
	
//	settings.put(Environment.HBM2DDL_AUTO, "create");
//	change HBM2DDL_AUTO to "create" if it is "update"
	
	@BeforeAll
	public static void setUp() {
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	validator = factory.getValidator();
	l.info("validator ready!!!");
	}
	
	//roll no Possitive digit validation test
	@Test
	public void rollPositiveDigitTest() {
		l.info("NEGATIVE TEST CASE");
		
		Department dept = null;
		AlumniDTO alm = new AlumniDTO(-1111111111l, "admin1", "admin singh", "somewhere", 6102734737L, "admin1@admin.com", 2022, dept);

		Set<ConstraintViolation<AlumniDTO>> constraintViolations = validator.validate(alm);

		assertEquals(1, constraintViolations.size());
		assertEquals("{alm.roll.positive_check}", constraintViolations.iterator().next().getMessage());
	}
	
	//password Null validation test
	@Test
	public void IsPassNullTest() {
	l.info("NEGATIVE TEST CASE...");
	Department dept = null;
	AlumniDTO alm = new AlumniDTO(2222222222l, null, "admin singh", "somewhere", 6202734737L, "admin2@admin.com", 2022, dept);

	Set<ConstraintViolation<AlumniDTO>> constraintViolations = validator.validate(alm);

	assertEquals(1, constraintViolations.size());
	assertEquals("{alm.pass.null_Check}", constraintViolations.iterator().next().getMessage());
	}
	
	//name validation test
	@Test
	public void nameSizeLessThanThreeTest() {
	l.info("NEGATIVE TEST CASE...");
	Department dept = null;
	AlumniDTO alm = new AlumniDTO(3333333333l, "admin3", "ad", "somewhere", 6302734737L, "admin3@admin.com", 2022, dept);

	Set<ConstraintViolation<AlumniDTO>> constraintViolations = validator.validate(alm);

	assertEquals(1, constraintViolations.size());
	assertEquals("{alm.name.size_check}", constraintViolations.iterator().next().getMessage());
	}
	
	//address validation test
	@Test
	public void addressSizeLessThanEightTest() {
		l.info("POSITIVE TEST CASE...");
		Department dept = null;
		AlumniDTO alm = new AlumniDTO(4444444444l, "admin4", "admin singh", "where", 6402734737L, "admin4@admin.com", 2022, dept);
		
		Set<ConstraintViolation<AlumniDTO>> constraintViolations = validator.validate(alm);
		
		assertEquals(1, constraintViolations.size());
		assertEquals("{alm.address.size_check}", constraintViolations.iterator().next().getMessage());
	}
	
	//phone validation test
	@Test
	public void phoneSizeTest() {
		l.info("NEGATIVE TEST CASE...");
		Department dept = null;
		AlumniDTO alm = new AlumniDTO(55555555555l, "admin5", "admin singh", "somewhere", 650273473L, "admin5@admin.com", 2022, dept);
		
		Set<ConstraintViolation<AlumniDTO>> constraintViolations = validator.validate(alm);
		
		assertEquals(1, constraintViolations.size());
		assertEquals("{alm.roll.digits_check}", constraintViolations.iterator().next().getMessage());
	}
	
	//email Null validation test
	@Test
	public void IsEmailNullTest() {
	l.info("NEGATIVE TEST CASE...");
	Department dept = null;
	AlumniDTO alm = new AlumniDTO(6666666666l, "admin6", "admin singh", "somewhere", 660273473L, null, 2022, dept);

	Set<ConstraintViolation<AlumniDTO>> constraintViolations = validator.validate(alm);

	assertEquals(1, constraintViolations.size());
	assertEquals("{alm.email.null_Check}", constraintViolations.iterator().next().getMessage());
	}
	
	//passing year validation test
	@Test
	public void passingYearNullTest() {
	l.info("POSITIVE TEST CASE...");
	Department dept = null;
	AlumniDTO alm = new AlumniDTO(7777777777l, "admin7", "admin singh", "somewhere", 670273473L, "admin7@admin.com", null, dept);

	Set<ConstraintViolation<AlumniDTO>> constraintViolations = validator.validate(alm);

	assertEquals(1, constraintViolations.size());
	assertEquals("{alm.yop.null_Check}", constraintViolations.iterator().next().getMessage());
	}
}
