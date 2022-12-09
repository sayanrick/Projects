package com.ams;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ams.config.HibernateUtil;
import com.ams.entity.Alumni;
import com.ams.entity.Department;

public class DepartmentTest {
	
	private static SessionFactory sessionFactory;
	private Session session;

//	settings.put(Environment.HBM2DDL_AUTO, "create");
//	change HBM2DDL_AUTO to "create" if it is "update"
	
	// creating session factory object
	@BeforeAll
	public static void setup() {
		sessionFactory = HibernateUtil.getSessionFactory();
		System.out.println("SessionFactory created");

	}

	// closing session factory object
	@AfterAll
	public static void tearDown() {
		if (sessionFactory != null)
			sessionFactory.close();
		System.out.println("SessionFactory destroyed");
	}

	// open session before each test case
	@BeforeEach
	public void openSession() {
		session = sessionFactory.openSession();
		System.out.println("Session created");
	}

	// close session after each test case
	@AfterEach
	public void closeSession() {
		if (session != null)
			session.close();
		System.out.println("Session closed\n");
	}
	
	
		// test method for createDepartment
		@Test
		@DisplayName("Positive department create test case")
		public void testCreate() {
			System.out.println("............Running department testCreate (Positive case)............");
			Transaction tr = session.beginTransaction();
			
			List<Alumni> list = session.createQuery("from Alumni", Alumni.class).getResultList();
			Department dept = Department.builder().dname("dept1").dhead("dhead1").alumni(list).build();
			Integer i = (Integer) session.save(dept);
			tr.commit();
			assertThat(i > 0).isTrue();

		}

		// testing fail create method
		@Test
		@DisplayName("Negative department create test case")
		public void testCreateFail() {
			System.out.println("............Running department testRead (Negative case)............");
			List<Alumni> list = session.createQuery("from Alumni", Alumni.class).getResultList();
			Department dept = Department.builder().dname("d").dhead("dhead2").alumni(list).build();
			Integer i = (Integer) session.save(dept);
			assertThat(i > 0).isTrue();

		}
		
//		// testing for department list
//		@Test
//		@DisplayName("Testing department list case")
//		public void testList() {
//		    System.out.println("............Running testList for department............");
//		     
//		    List<Department> list = session.createQuery("from Department", Department.class).getResultList();;
//		    
//		    assertThat(list).isEmpty();
//		}
}
