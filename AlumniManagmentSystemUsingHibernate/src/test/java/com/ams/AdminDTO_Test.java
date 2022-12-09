package com.ams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ams.dto.AdminDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class AdminDTO_Test {
	private static final Logger l = LogManager.getLogger(AdminDTO_Test.class);
	private static Validator validator;
	
//	settings.put(Environment.HBM2DDL_AUTO, "create");
//	change HBM2DDL_AUTO to "create" if it is "update"
	
	@BeforeAll
	public static void setUp() {
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	validator = factory.getValidator();
	l.info("validator ready!!!");
	}
	
	//username Null validation test
	@Test
	public void IsUsernameNullTest() {
	l.info("Negative TEST CASE...");
	AdminDTO admin = new AdminDTO("admin0", null, "admin singh", "admin0@admin.com");

	Set<ConstraintViolation<AdminDTO>> constraintViolations = validator.validate(admin);

	assertEquals(1, constraintViolations.size());
	assertEquals("{admin.pass.null_Check}", constraintViolations.iterator().next().getMessage());
	}
	
	//admin password length validation test
	@Test
	public void passLengthLessThanFiveTest() {
		l.info("NEGATIVE TEST CASE");
		AdminDTO admin = new AdminDTO("admin2", null, "admin singh", "admin2@admin.com");

		Set<ConstraintViolation<AdminDTO>> constraintViolations = validator.validate(admin);

		assertEquals(1, constraintViolations.size());
		assertEquals("{admin.pass.null_Check}", constraintViolations.iterator().next().getMessage());
	}
	
	//admin name validation test
	@Test
	public void nameSizeLessThanThreeTest() {
	l.info("NEGATIVE TEST CASE...");
	AdminDTO admin = new AdminDTO("admin3", "admin3", "ad", "admin3@admin.com");

	Set<ConstraintViolation<AdminDTO>> constraintViolations = validator.validate(admin);

	assertEquals(1, constraintViolations.size());
	assertEquals("{admin.name.size_check}", constraintViolations.iterator().next().getMessage());
	}
	
	//admin email Null validation test
	@Test
	public void IsEmailNullTest() {
	l.info("NEGATIVE TEST CASE...");
	AdminDTO admin = new AdminDTO("admin4", "admin4", "admin singh", null);

	Set<ConstraintViolation<AdminDTO>> constraintViolations = validator.validate(admin);

	assertEquals(1, constraintViolations.size());
	assertEquals("{admin.email.null_Check}", constraintViolations.iterator().next().getMessage());
	}
	
}
