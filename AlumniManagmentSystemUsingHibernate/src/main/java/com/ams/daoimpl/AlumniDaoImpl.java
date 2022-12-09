package com.ams.daoimpl;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ams.config.HibernateUtil;
import com.ams.dao.AlumniDAO;
import com.ams.entity.Alumni;
import com.ams.entity.Department;
import com.ams.exception.GlobalException;

public class AlumniDaoImpl implements AlumniDAO {


	//creating session globally so each method can access this
	Session session = HibernateUtil.getSession();

	private static Logger logger = LogManager.getLogger(AlumniDaoImpl.class);

//	private List<Alumni> alumnis = session.createQuery("FROM Alumni", Alumni.class).getResultList();
//	private List<Department> depts = session.createQuery("FROM Department", Department.class).getResultList();
	
	@Override
	public void addAlumni(Alumni alumni) {

		try {
			if( (Long.toString(alumni.getAlroll()).length() > 10) ) {
				JOptionPane.showMessageDialog(null,"Roll number should be max 10 number.");
				throw new GlobalException("Invalid rollno");
			}
			else if( alumni.getAlpassword().length() > 10 ) {
				JOptionPane.showMessageDialog(null,"Password size should be max 10 letters.");
				throw new GlobalException("Invalid entry");
			}
			else if ( alumni.getAlname().length()>20 ) {
				JOptionPane.showMessageDialog(null,"Name size should be max 20 letters.");
				throw new GlobalException("Invalid name entry");
			}
			else if (alumni.getAladdress().length() >30 ) {
				JOptionPane.showMessageDialog(null,"Address size should be max 30 letters.");
				throw new GlobalException("Invalid address entry");
			}
			else if ( Long.toString(alumni.getAlphone()).length() > 10 ) {
				JOptionPane.showMessageDialog(null,"Phone number should be max 10 number.");
				throw new GlobalException("Invalid phone number entry");
			}
			else if ( alumni.getAlemail().length() > 25 ) {
				JOptionPane.showMessageDialog(null,"Email size should be max 25 letters.");
				throw new GlobalException("Invalid email");
			}
			else if ( Long.toString(alumni.getAlpassyear()).length() > 4 ) {
				JOptionPane.showMessageDialog(null,"Pass year should be max 4 number.");
				throw new GlobalException("Invalid pass year entry");
			}
			
			//if all condition satisfies
			else {
				//fetching all department data
				List<Department> depts = session.createQuery("FROM Department", Department.class).getResultList();
				//checking whether department already exists or not
				if( (depts.stream().anyMatch(x->x.getDname().equalsIgnoreCase(alumni.getDepartment().getDname()))) && (depts.stream().anyMatch(x->x.getDhead().equalsIgnoreCase(alumni.getDepartment().getDhead())))) {
					//fetching existing department
					Department fetchDept = depts.stream().filter(x->x.getDname().equalsIgnoreCase(alumni.getDepartment().getDname())).findAny().get();
					//setting existing department 
					alumni.setDepartment(fetchDept);	//it will avoid the creation of new department
				}
				
				//adding user to DB
				session.beginTransaction();
				session.save(alumni);

				//saving to DB
				session.getTransaction().commit();
				JOptionPane.showMessageDialog(null,"Alumni '"+alumni.getAlroll()+"'has been created successfully.");
				logger.info("new alumni A/c created " + alumni.toString() + " and creation time is " + new java.util.Date());
			}
			session.clear();

		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		} 	

	}

	@Override
	public List<Alumni> fetchAlumni(long alroll, String alpassword) {

		try{	//activating session
			//fetching alumni data
			Alumni fecthAl = (Alumni)session.get(Alumni.class, alroll);
			//fetching all alumni datas
			List<Alumni> alumnis = session.createQuery("FROM Alumni", Alumni.class).getResultList();
			
			//validations
			//for roll number
			if( (alumnis.stream().anyMatch(x->x.getAlroll() == alroll)) && (fecthAl.getAlpassword().equals(alpassword))  ) {
				
				//it will return list of all alumni
				logger.info("alumni data fetched " + alumnis.toString() + " and time is " + new java.util.Date());
				return alumnis;
			}
			//if all condition satisfies
			else {
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"Invalid roll number or password");
				throw new GlobalException("Invalid roll number or password");
			}

		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		} 
		return null;
	}

	@Override
	public Alumni changePassword(long alroll, String alpassword, Alumni alumni) {

		try{	// activating session
			//activating transaction
			session.beginTransaction();
			//fetching alumni data
			Alumni fetchAl = (Alumni)session.get(Alumni.class, alroll);
			//fetching all alumni datas
			List<Alumni> alumnis = session.createQuery("FROM Alumni", Alumni.class).getResultList();
			
			//validation
			if( (alumnis.stream().anyMatch(x->x.getAlroll()==alroll)) && (fetchAl.getAlpassword().equals(alpassword)) ) {	//if condition meets

				//setting updated value
				fetchAl.setAlpassword(alumni.getAlpassword()); 	

				//saving data
				session.update(fetchAl);
				session.getTransaction().commit();
				JOptionPane.showMessageDialog(null,"Alumni Password Updated successfully!");
				logger.info("alumni password updated " + fetchAl.toString() + " and time is " + new java.util.Date());
				
				return fetchAl;
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

}


