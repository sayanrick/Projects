package com.ams;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ams.config.HibernateUtil;
import com.ams.entity.Admin;
import com.ams.entity.Alumni;

public class AdminTest {
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
	
	
		//-----------------------------------------------------------------------------------------------------
		// testing create method
		@Test
		@DisplayName("Positive Admin create test case")
		public void testCreate() {
			System.out.println("............Running Positive Admin testCreate case............");
			Transaction tr = session.beginTransaction();
			Admin admin = Admin.builder().adusername("admin1").adname("admin singh").adpassword("admin1").ademail("admin1@admin.com").build();
			String i = (String)session.save(admin);
			tr.commit();
			assertThat(i != null).isTrue();

		}

		// testing create fail method
		@Test
		@DisplayName("Negative admin create test case")
		public void testCreateFail() {
			System.out.println("............Running Negative admin testRead case............");
			session.beginTransaction();
			Admin admin = null;
			admin = Admin.builder().adusername("adm").adname("admin singh").adpassword("admin2").ademail("admin2@admin.com").build();
			String i = (String)session.save(admin);
			assertThat(i != null).isTrue();

		}
		
		//-----------------------------------------------------------------------------------------------------
		// testing admin update method
		@Test
		@DisplayName("Positive admin update case")
		public void testUpdate() {
			System.out.println("............Running Positive testUpdate for admin............");
			Admin admin = Admin.builder().adusername("admin3").adname("admin singh").adpassword("admin").ademail("admin3@admin.com").build();
			session.save(admin);
			admin.setAdpassword("akash");
			assertThat(admin.getAdpassword()).isEqualTo("akash");
		}
		
		//-----------------------------------------------------------------------------------------------------
		//admin account delete case
		@Test
		@DisplayName("Admin delete case")
		public void testAdminDelete() {
		    System.out.println("............Running testDelete for admin............");
		    
		    session.beginTransaction();
			Admin admin = Admin.builder().adusername("admin1").adname("admin singh").adpassword("admin1").ademail("admin1@admin.com").build();
			session.save(admin);
			session.getTransaction().commit();
		    session.clear();
			
			String username = "admin1";
		    
		    //fetching 
		    Admin fetchedAdmin = session.find(Admin.class, username);
		    
		    //deleting
		    session.beginTransaction();
		    session.delete(fetchedAdmin);
		    session.getTransaction().commit();
		    
		    //again fetching and storing to deletedAdmin
		    Admin deletedAdmin = session.find(Admin.class, username);
		     
		    Assertions.assertNull(deletedAdmin);
		}
		
		//Alumni account delete case
		@Test
		@DisplayName("Alumni delete case")
		public void testAlumniDelete() {
		    System.out.println("............Running testDelete for Alumni............");
		    
		    //creating alumni 
		    session.beginTransaction();
			Alumni alm = Alumni.builder().alroll(1111111111L).alname("alm1").alpassword("alm1").aladdress("somewhere").alphone(9111111111L).alemail("test@alm1.com").alpassyear(2022).build();
			session.save(alm);
			session.getTransaction().commit();
		    
			//storing roll no (Primary key)
		    long rollno = 1111111111L;
		    
		    //fetching 
		    Alumni fetchedAlumni = session.find(Alumni.class, rollno);
		    
		    //deleting
		    session.beginTransaction();
		    session.delete(fetchedAlumni);
		    session.getTransaction().commit();
		    
		    //again fetching and storing to deletedAlumni
		    Alumni deletedAlumni = session.find(Alumni.class, rollno);
		     
		    Assertions.assertNull(deletedAlumni);
		}
		
}
