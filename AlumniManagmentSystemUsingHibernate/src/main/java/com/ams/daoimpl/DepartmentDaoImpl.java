package com.ams.daoimpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ams.config.HibernateUtil;
import com.ams.dao.DepartmentDAO;
import com.ams.entity.Alumni;
import com.ams.entity.Department;
import com.ams.exception.GlobalException;

public class DepartmentDaoImpl implements DepartmentDAO {


	//creating session globally so each method can access this
	Session session = HibernateUtil.getSession();

	private static Logger logger = LogManager.getLogger(DepartmentDaoImpl.class);
	
	//fetching all list of datas
//	private List<Alumni> alumnis = session.createQuery("FROM Alumni", Alumni.class).getResultList();
//	private List<Department> depts = session.createQuery("FROM Department", Department.class).getResultList();

//================================================================================================================
	@Override
	public void addDepartment(Department department) {

		try {

			//validation of department details
			//for department name
			if( Integer.toString(department.getDid()).length() > 5)  {
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"Id size should be max 5 number.");
				throw new GlobalException("Invalid id entry");
			}

			//for department name
			if( department.getDname().length()>20 ) {
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"Department name size should be max 20 letters.");
				throw new GlobalException("Invalid department name entry");
			}

			//for department head
			else if(  department.getDhead().length()>30 ){	
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"Department head name size should be max 30 letters.");
				throw new GlobalException("Invalid department head name entry");
			}


			//if all condition satisfies
			else {
				//adding department to DB
				session.beginTransaction();
				session.save(department);

				//saving to DB
				session.getTransaction().commit();
				JOptionPane.showMessageDialog(null,"Department id '"+department.getDid()+"' has been created successfully.");
				logger.info("new department created " + department.toString() + " and creation time is " + new java.util.Date());
			}
			session.clear();
		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		} 
	}
//================================================================================================================
	@Override
	public List<Alumni> fetchAlumnis() {	
		
		//fetching all alumins
		List<Alumni> alumnis = session.createQuery("FROM Alumni", Alumni.class).getResultList();
		
		//it will return list of all alumnis
		logger.info("alumni data fetched " + alumnis.toString() + " and time is " + new java.util.Date());
		return alumnis;
	}
//================================================================================================================
	@Override
	public List<Alumni> fetchAlumniByDeptId(int did) {
		try{	//activating session
			//fetching all alumins
			List<Alumni> alumnis = session.createQuery("FROM Alumni", Alumni.class).getResultList();
			//fetching all departments
			List<Department> depts = session.createQuery("FROM Department", Department.class).getResultList();
			
			Department fetchDept = (Department)session.get(Department.class, did);
			//validation
			if( (depts.stream().anyMatch(x->x.getDid()==did)) && (fetchDept.getDid()==did) ) {	//if condition meets
				//it will return list of all alumnis
				
				 List<Alumni> returnAlumnis = alumnis.stream()										//converting into stream
													 .filter(x->x.getDepartment().getDid()==did)	//filtering by dept. id
													 .collect(Collectors.toList());					//converting again into list
				 
				logger.info("alumni data fetched " + alumnis.toString() + " and time is " + new java.util.Date());
				return returnAlumnis;
			}
			//if all condition satisfies
			else {
				//it will show error as output and throw exception too
				JOptionPane.showMessageDialog(null,"Incorrect Department id");
				throw new GlobalException("Incorrect Department id");
			}
			
		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		} 
		
		return null;
	}
//================================================================================================================
//	@Override
//	public Department fetchDepartment(int did) {
//
//		try {
//			
//			//validations
//			//for id
//			if( depts.stream().anyMatch(x->x.getDid() == did )  ) {
//				
//				//fetching department by dept. id
//				Department fetchedDept = session.get(Department.class, did);
//				//it will return list of department details
//				logger.info("department data fetched " + fetchedDept.toString() + " and time is " + new java.util.Date());
//				return fetchedDept;
//			}
//			//if all condition satisfies
//			else {
//				//it will show error as output and throw exception too
//				JOptionPane.showMessageDialog(null,"Invalid department id");
//				throw new GlobalException("Invalid department id");
//			}
//
//		} catch (HibernateException he) {
//			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
//		} catch (Exception e) {
//			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
//		} 
//
//		return null;
//
//	}


}
