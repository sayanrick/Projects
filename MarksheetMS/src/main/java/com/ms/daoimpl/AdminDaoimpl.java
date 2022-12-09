package com.ms.daoimpl;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ms.config.HibernateUtil;
import com.ms.dao.AdminDao;
import com.ms.entity.Admin;
import com.ms.entity.Marks;
import com.ms.entity.Students;


public class AdminDaoimpl implements AdminDao {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction t = session.beginTransaction();

	private static final Logger logger = LogManager.getLogger(AdminDaoimpl.class);

	@Override
	public void addAdmin(Admin admin) {
		try {
			session.save(admin);
			t.commit();
			JOptionPane.showMessageDialog(null, admin.getAname() + " registration successful");

		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		}

	}

	@Override
	public Students fetchStudent(int sRoll) {

		try {
			Students v = session.get(Students.class, sRoll);
			return v;

		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		}

		return null;

	}

	@Override
	public Students updateStudent(int sroll, int marks, int press) {

		try {
			Students sss = session.get(Students.class, sroll);
			if (press == 1) {
				sss.getMarks().setM_english(marks);
			} else if (press == 2) {
				sss.getMarks().setM_hindi(marks);
			} else if (press == 3) {
				sss.getMarks().setM_physics(marks);
			} else if (press == 4) {
				sss.getMarks().setM_chemistry(marks);
			} else if (press == 5) {
				sss.getMarks().setM_math(marks);
			} else if (press == 6) {
				sss.getMarks().setM_practical(marks);
			}
			session.update(sss);
			t.commit();
			return sss;
		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		}

		return null;

	}

	@Override
	public void deleteStudent(int sroll) {

		try {
			Students vv1 = session.get(Students.class, sroll);
			session.delete(vv1.getStudentsissues());
			session.delete(vv1.getMarks());
			session.delete(vv1);
			t.commit();
			
			JOptionPane.showMessageDialog(null, vv1.getSname() + " Deleted successfully");
			System.out.println("Deleted successfully");

		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		}
	}

	
	public Students fetchStudentsissues(int sroll) {

		try {
			Students issue =session.get(Students.class, sroll);
			
			return issue;
		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		}

		return null;
	}

	@Override
	public void addMarks(int sroll, Marks marks) {

		try {
			Students st = session.get(Students.class, sroll);
			session.save(marks);
			st.setMarks(marks);
			session.update(st);
			t.commit();
			
			System.out.println("marks saved successfully");
			JOptionPane.showMessageDialog(null, "marks saved successfully");

		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		}

	}

}
