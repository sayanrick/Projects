package com.ms.daoimpl;



import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ms.config.HibernateUtil;
import com.ms.dao.LoginDao;
import com.ms.entity.Admin;
import com.ms.entity.Students;

public class LoginDaoimpl implements LoginDao {
	Session session1 = HibernateUtil.getSessionFactory().openSession();
	Transaction t = session1.beginTransaction();

	
	private static final Logger logger = LogManager.getLogger(AdminDaoimpl.class);

	public Admin adminLogin(Integer loginId, String password) {
		try {
			Admin an = session1.get(Admin.class, loginId);

			if (loginId.equals(an.getLoginid()) && password.equals(an.getPassword())) {
				JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL \nWelcome: " + an.getAname());
				System.out.println("LOGIN SUCCESSFUL");
				System.out.println("Welcome: " + an.getAname());
				return an;
			}
			
		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		}
		return null;
	}

	public Students studentLogin(Integer sroll, String password) {

		try {
			Students stu = session1.get(Students.class, sroll);

			if (sroll.equals(stu.getSroll()) && password.equals(stu.getPassword())) {
				JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL \nWelcome: " + stu.getSname());
				System.out.println("LOGIN SUCCESSFUL \nWelcome: " + stu.getSname());

				return stu;
			} else {
				System.out.println("invalid S_id or password");
			}
			
		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		}
		
		return null;

	}

}
