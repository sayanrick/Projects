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

public class AlumniTest {
	
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
		// testing create method
	
		//-----------------------------------------------------------------------------
		@Test
		@DisplayName("Positive alumni create test case")
		public void testCreate() {
			System.out.println("............Running Positive alumni testCreate case............");
			Transaction tr = session.beginTransaction();
			Department dept = Department.builder().dname("dept1").dhead("dhead1").build();
			Alumni alm = Alumni.builder().alroll(1111111111L).alname("alm1").alpassword("alm1").aladdress("somewhere").alphone(9111111111L).alemail("test@alm1.com").alpassyear(2022).department(dept).build();
			Long i = (Long)session.save(alm);
			tr.commit();
			assertThat(i > 0).isTrue();

		}

		// testing create fail method
		@Test
		@DisplayName("Negative alumni create test case")
		public void testCreateFail() {
			System.out.println("............Running Negative alumni testRead case............");
			session.beginTransaction();
			Department dept = Department.builder().dname("dept2").dhead("dhead2").build();
			Alumni alm = Alumni.builder().alroll(222222222L).alname("alm2").alpassword("alm2").aladdress("somewhere").alphone(9222222222L).alemail("test@alm2.com").alpassyear(2022).department(dept).build();
			Long i = (Long)session.save(alm);
			assertThat(i > 0).isTrue();

		}
		
		//-----------------------------------------------------------------------------------------------------
		// testing for Alumni list
		@Test
		@DisplayName("Testing alumni list case")
		public void testList() {
		    System.out.println("............Running testList for Alumni............");
		     
		    List<Alumni> list = session.createQuery("from Alumni", Alumni.class).getResultList();
		    
		    assertThat(list).isEmpty();
		}
		
		//-----------------------------------------------------------------------------------------------------
		// testing alumni update method
		@Test
		@DisplayName("Positive alumni update case")
		public void testUpdate() {
			System.out.println("............Running Positive testUpdate for Alumni............");
			Alumni alm = Alumni.builder().alroll(3333333333L).alname("alm3").alpassword("alm3").aladdress("somewhere").alphone(9333333333L).alemail("test@alm3.com").alpassyear(2022).build();
			session.save(alm);
			alm.setAlpassword("akash");
			assertThat(alm.getAlpassword()).isEqualTo("akash");
		}
		
		//-----------------------------------------------------------------------------------------------------
}
