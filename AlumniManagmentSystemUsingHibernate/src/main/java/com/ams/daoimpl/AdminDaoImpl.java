package com.ams.daoimpl;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ams.config.HibernateUtil;
import com.ams.dao.AdminDAO;
import com.ams.entity.Admin;
import com.ams.entity.Alumni;
import com.ams.entity.Department;
import com.ams.exception.GlobalException;

public class AdminDaoImpl implements AdminDAO {

	//creating session 
	Session session = HibernateUtil.getSession();

	private static final Logger logger = LogManager.getLogger(AdminDaoImpl.class);

	//fetching all data from DB and storing into list reference
//	private List<Admin> admins = session.createQuery("FROM Admin", Admin.class).getResultList();
//	private List<Alumni> alumnis = session.createQuery("FROM Alumni", Alumni.class).getResultList();
//	private List<Department> depts = session.createQuery("FROM Department", Department.class).getResultList();

	@Override
	public void createAdmin(Admin admin) {

		try {
			//fetching all admin datas
			List<Admin> admins = session.createQuery("FROM Admin", Admin.class).getResultList();
			
			//validation of admin details
			//for admin name
			if( (admin.getAdname().length() > 30) || (admin.getAdname()==null) ) {
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"Name size should be max 30 letters.");
				throw new GlobalException("Invalid first name entry");
			}
			
			//for admin username
			else if( (admin.getAdusername().length() > 15) || (admin.getAdusername()==null) || (admins.stream().anyMatch(x->x.getAdusername().equals(admin.getAdusername()))) ){	
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"username already taken or size is more than 15 characters.");
				throw new GlobalException("Invalid username entry");
			}
			
			//for employee password
			else if( (admin.getAdpassword().length() > 10) || (admin.getAdpassword()==null) ){	
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"Password should be max 10 characters");
				throw new GlobalException("Invalid password entry");
			}
			
			//if all condition satisfies
			else {
			//adding admin to DB
			session.beginTransaction();
			session.save(admin);
			
			//saving to DB
			session.getTransaction().commit();
			logger.info("new admin A/c created " + admin.toString() + " and creation time is " + new java.util.Date());
			JOptionPane.showMessageDialog(null,"Admin account '"+admin.getAdusername()+"' has been created successfully.");
			}
			session.clear();


		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		} 

	}
	
// =========================================================================================================================	

	@Override
	public List<Alumni> fetchAlumni(String adusername, String adpassword) {
		
		try{	//activating session
			
			//fetching Admin data for validation
			Admin fetchAd = (Admin)session.get(Admin.class,adusername);
			//fetching all admin datas
			List<Admin> admins = session.createQuery("FROM Admin", Admin.class).getResultList();
			//fetching all alumnis datas
			List<Alumni> alumnis = session.createQuery("FROM Alumni", Alumni.class).getResultList();
			
			//validation
			if( (admins.stream().anyMatch(x->x.getAdusername().equals(adusername))) && (fetchAd.getAdpassword().equals(adpassword)) ) {	//if condition meets
				//it will return list of all alumnis
				logger.info("alumni data fetched " + alumnis.toString() + " and time is " + new java.util.Date());
				return alumnis;
			}
			//if all condition satisfies
			else {
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"Invalid admin credentials");
				throw new GlobalException("Invalid admin credentials");
			}
			
		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		} 
		
		return null;
	}
	
// =========================================================================================================================	

	@Override
	public List<Department> fetchDepartment(String adusername, String adpassword) {
		
		try {
			
			//fetching Department data
			Admin fetchAd = (Admin)session.get(Admin.class, adusername);
			//fetching all admin datas
			List<Admin> admins = session.createQuery("FROM Admin", Admin.class).getResultList();
			//fetching all depts datas
			List<Department> depts = session.createQuery("FROM Department", Department.class).getResultList();
			
			//validation
			if( (admins.stream().anyMatch(x->x.getAdusername().equals(adusername))) && (fetchAd.getAdpassword().equals(adpassword)) ) {	//if condition meets
				//it will return list of all departments
				logger.info("department data fetched " + depts.toString() + " and time is " + new java.util.Date());
				return depts;
			}
			//if all condition satisfies
			else {
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"Invalid admin credentials");
				throw new GlobalException("Invalid admin credentials");
			}
			
		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		} 
		
		return null;
	}
	
// =========================================================================================================================

	@Override
	public Admin changePassword(String adusername, String adpassword, Admin admin) {
		
		try{	// activating session
			//activating transaction
			session.beginTransaction();
			//fetching admin data
			Admin fetchAd = (Admin)session.get(Admin.class, adusername);
			//fetching all admin datas
			List<Admin> admins = session.createQuery("FROM Admin", Admin.class).getResultList();
			
			//validation
			if( (admins.stream().anyMatch(x->x.getAdusername().equals(adusername))) && (fetchAd.getAdpassword().equals(adpassword)) ) {	//if condition meets

				//setting updated value
				fetchAd.setAdpassword(admin.getAdpassword()); 	

				//saving data
				session.update(fetchAd);
				session.getTransaction().commit();
				JOptionPane.showMessageDialog(null,"Updated successfully!");
				logger.info("admin password updated " + fetchAd.toString() + " and time is " + new java.util.Date());
				
				return fetchAd;
			}//if end
			else {	//otherwise
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"Invalid credentials");
				throw new GlobalException("Invalid credentials ");
			}//else end

		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		}
		return null; 

	}
	
	
// =========================================================================================================================	


	@Override
	public void deleteAdmin(String adusername, String adpassword) {

		try {
			//fetching admin data
			Admin fetchAd = (Admin)session.get(Admin.class, adusername);
			//fetching all admin datas
			List<Admin> admins = session.createQuery("FROM Admin", Admin.class).getResultList();
			
			//validations
			if(  (admins.stream().anyMatch(x->x.getAdusername().equals(adusername))) && (fetchAd.getAdpassword().equals(adpassword)) ) {
				
				//it will update the value first then will return
				session.beginTransaction();			//activating transaction 
				session.delete(fetchAd);			//deleting
				session.getTransaction().commit(); 	//saving changes to DB
				JOptionPane.showMessageDialog(null,"Admin username '" +adusername+ "' has been deleted successfully...");
				logger.info(adusername +"admin account deleted and time is " + new java.util.Date());
			}
			
			//if all condition satisfies
			else {
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"Invalid credentials");
				throw new GlobalException("Invalid credentials");
			}//else end
			
		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		} 

	}
	
	
// =========================================================================================================================	

	@Override
	public void deleteAlumni(String adusername, String adpassword, int alroll) {

		try {
			//fetching admin data for password valida
			Admin fetchAd = (Admin)session.get(Admin.class, adusername);
			//fetching all admin datas
			List<Admin> admins = session.createQuery("FROM Admin", Admin.class).getResultList();
			
			//validations
			if(  (admins.stream().anyMatch(x->x.getAdusername().equals(adusername))) && (fetchAd.getAdpassword().equals(adpassword)) ) {
				
				//fetching alumni data for deleting
				Alumni fetchAlumni = (Alumni)session.get(Alumni.class, alroll);
				
				//it will update the value first then will return
				session.beginTransaction();			//activating transaction 
				session.delete(fetchAlumni);			//deleting
				session.getTransaction().commit(); 	//saving changes to DB
				
				JOptionPane.showMessageDialog(null,"Alumni roll number '" +alroll+ "' has been deleted successfully...");
				logger.info(alroll +"alumni account deleted and time is " + new java.util.Date());
			}
			
			//if all condition satisfies
			else {
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"Invalid credentials");
				throw new GlobalException("Invalid credentials");
				}//else end
			
		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		} 

	}

	
// =========================================================================================================================	
	
//	@Override
//	public void deleteDepartment(String adusername, String adpassword, int did) {
//
//		try {
//			//fetching admin data for password valida
//			Admin fetchAd = (Admin)session.get(Admin.class, adusername);
//			
//			//validations
//			//for department id
//			if( (admins.stream().anyMatch(x->x.getAdusername().equals(adusername))) && (fetchAd.getAdpassword().equals(adpassword)) ) {
//				//fetching department data to delete
//				Department fetchDept = (Department)session.get(Department.class, did);
//				
//				//it will update the value first then will return
//				session.beginTransaction();			//activating transaction 
//				session.delete(fetchDept);			//deleting
//				session.getTransaction().commit(); 	//saving changes to DB
//				
//				JOptionPane.showMessageDialog(null,"Department id '" +did+ "' has been deleted successfully...");
//				logger.info(did +"Department deleted and time is " + new java.util.Date());
//			}
//			
//			//if all condition satisfies
//			else {
//				//it will show error as output and throw exception too
//				JOptionPane.showMessageDialog(null,"Invalid credentials");
//				throw new GlobalException("Invalid credentials");
//			}//else end
//			
//		} catch (HibernateException he) {
//			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
//		} catch (Exception e) {
//			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
//		} 
//	}//end of deleteDepartment() 
}//end of class
