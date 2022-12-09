package com.ms.daoimpl;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ms.config.HibernateUtil;
import com.ms.dao.StudentsDao;
import com.ms.entity.Students;
import com.ms.entity.StudentsIssues;

public class StudentsDaoimpl implements StudentsDao {

	Session session2 = HibernateUtil.getSessionFactory().openSession();
	Transaction t2 = session2.beginTransaction();

	private static final Logger logger = LogManager.getLogger(AdminDaoimpl.class);

	@Override
	public Students fetchStudent(int sroll) {

		try {
			Students v = session2.get(Students.class, sroll);
			return v;

		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		}

		return null;

	}

	@Override
	public void addStudentIssues(int sroll, String issue) {

		try {
			Students si = session2.get(Students.class, sroll);
			StudentsIssues sti = new StudentsIssues();
			sti.setIssue(issue);
			session2.save(sti);
			si.setStudentsissues(sti);
			session2.update(si);
			t2.commit();
			

			JOptionPane.showMessageDialog(null, "issue updated");
			System.out.println("issue updated");

		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		}

	}

	@Override
	public void studentRegistration(Students student) {

		try {
			session2.save(student);
			t2.commit();
			JOptionPane.showMessageDialog(null, "Congratulation " + student.getSname() + " registration successful");
			
			System.out.println("registration successful");

		} catch (HibernateException he) {
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			logger.error("exception happened " + e.toString() + " and error creation time is " + new java.util.Date());
		}

	}

}
