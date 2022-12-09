package com.ms;


import javax.swing.JOptionPane;
import com.ms.dao.AdminDao;
import com.ms.dao.LoginDao;
import com.ms.dao.StudentsDao;
import com.ms.daoimpl.AdminDaoimpl;
import com.ms.daoimpl.LoginDaoimpl;
import com.ms.daoimpl.StudentsDaoimpl;
import com.ms.entity.Admin;
import com.ms.entity.Marks;
import com.ms.entity.Students;


public class CrudOperation {

	public static void crudMain() {
		int press;
		while (true) {
			System.out.println("====================================================");
			System.out.println("----------Main Menu----------");
			System.out.println(
					"Press 1. for registration menu \nPress 2. for student login \nPress 3. for admin login\nPress 4. for Exit ");
			System.out.println("====================================================");
			press = Integer.parseInt(JOptionPane.showInputDialog("Enter your Choice:"));

			switch (press) {
			case 1:
				crudRegistration();
				break;
			case 2:
				crudStudent();
				break;
			case 3:
				crudAdmin();
				break;
			case 4:
				System.exit(0);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Invalid choice!");
				throw new IllegalArgumentException("invalid choice: " + press);
			}
		}
	}

	static AdminDao admindao = new AdminDaoimpl();
	static LoginDao logindao = new LoginDaoimpl();
	static StudentsDao studentsdao = new StudentsDaoimpl();

	private static void crudRegistration() {
		while (true) {
			System.out.println("====================================================");

			System.out.println(
					"Press 1. for student registration \nPress 2. for admin registration \nPress 3. to go back");
			System.out.println("====================================================");
			int rChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter your Choice:"));
			switch (rChoice) {
			case 1:
				Students student = new Students();
				student.setSroll(Integer.parseInt(JOptionPane.showInputDialog("Enter your roll:")));
				student.setPassword(JOptionPane.showInputDialog("create password:"));
				student.setSname(JOptionPane.showInputDialog("enter your name:"));
				student.setSemail(JOptionPane.showInputDialog("enter your email:"));
				student.setScontact(Long.parseLong(JOptionPane.showInputDialog("enter your phoneNo:")));
				student.setSaddress(JOptionPane.showInputDialog("enter your address:"));
				student.setSDept(JOptionPane.showInputDialog("enter your Department:"));
				studentsdao.studentRegistration(student);
				break;
			case 2:
				String sceCode = JOptionPane
						.showInputDialog("ENTER COLLEGE SECRET CODE TO GO TO ADMIN REGISTRATION ACCESS");
				if (sceCode.equals("clg123")) {
					Admin admin = new Admin();
					admin.setLoginid(Integer.parseInt(JOptionPane.showInputDialog("choose logIn id(only numeric):")));
					admin.setPassword(JOptionPane.showInputDialog("create password:"));
					admin.setAname(JOptionPane.showInputDialog("enter your name:"));
					admin.setEmail(JOptionPane.showInputDialog("enter your email:"));
					admindao.addAdmin(admin);
				} else {
					JOptionPane.showMessageDialog(null, "WRONG SECRET CODE!");
					System.out.println("WRONG SECRET CODE!");
				}
				break;

			case 3:
				crudMain();
				break;
			default:
				break;
			}
		}
	}

	private static void crudAdmin() {
		Admin an = logindao.adminLogin(Integer.parseInt(JOptionPane.showInputDialog("Enter your loginId:")),
				JOptionPane.showInputDialog("Enter your password:"));
		if (an != null) {
			while (true) {
				int choice;

				System.out.println("press 1. to add Marks \npress 2. to fetch student with marksheet "
						+ "\nPress 3. to update students marks   \nPress 4. to fetch students issues \nPress 5. to delete student \nPress 6. to go to the Main Menu");
				System.out.println("====================================================");
				choice = Integer.parseInt(JOptionPane.showInputDialog("Enter your Choice:"));
				switch (choice) {
				case 1:
					int sroll = (Integer.parseInt(JOptionPane.showInputDialog("Enter student's roll to add marks:")));
					Marks marks = new Marks();
					marks.setM_english(Integer.parseInt(JOptionPane.showInputDialog("Enter marks of English:")));
					marks.setM_chemistry(Integer.parseInt(JOptionPane.showInputDialog("Enter marks of chemistry:")));
					marks.setM_hindi(Integer.parseInt(JOptionPane.showInputDialog("Enter marks of Hindi:")));
					marks.setM_math(Integer.parseInt(JOptionPane.showInputDialog("Enter marks of Math:")));
					marks.setM_physics(Integer.parseInt(JOptionPane.showInputDialog("Enter marks of Physics:")));
					marks.setM_practical(Integer.parseInt(JOptionPane.showInputDialog("Enter marks of Practical:")));
					admindao.addMarks(sroll, marks);
					break;
				case 2:

					Students v1 = studentsdao
							.fetchStudent(Integer.parseInt(JOptionPane.showInputDialog("Enter student roll:")));
					System.out.println("student_roll: " + v1.getSroll() + "\nstudent_name: " + v1.getSname()
							+ "\nstudent_email: " + v1.getSemail() + "\nstudent_phone: " + v1.getScontact());
					System.out.println("MARKS DETAILS");
					Marks ms = v1.getMarks();
					System.out.println("English: " + ms.getM_english() + "\nHindi: " + ms.getM_hindi() + "\nMath: "
							+ ms.getM_math() + "\nChemistry: " + ms.getM_chemistry() + "\nPhysics:  "
							+ ms.getM_physics() + "\nPractical: " + ms.getM_practical());
					int marks_acquired = ms.getM_english() + ms.getM_hindi() + ms.getM_math() + ms.getM_chemistry()
							+ ms.getM_physics() + ms.getM_practical();
					int percentage = (marks_acquired * 100 / 600);
					System.out.println("Marks Acquired:" + marks_acquired + "/600");
					System.out.println("Percentage: " + percentage + "%");

					if (percentage <= 40) {
						System.out.println("Grade:D" + " " + "\nStatus:Fail");
					}

					else if (percentage > 40 && percentage <= 60) {
						System.out.println("Grade:C" + " " + "\nStatus:Pass");
					} else if (percentage > 60 && percentage <= 80) {
						System.out.println("Grade:B" + " " + "\nStatus:Pass");
					} else if (percentage > 80 && percentage <= 100) {
						System.out.println("Grade:A" + " " + "\nStatus:Pass");
					}
					System.out.println("________________________________");
					JOptionPane.showMessageDialog(null, "Marks Fetched \nCheck your console Window.");
					break;
				case 3:
					while (true) {
						System.out.println("====================================================");
						System.out.println(
								"Press 1. to update marks of English \nPress 2. to update marks of Hindi \nPress 3. to update marks of Physics "
										+ "\nPress 4. to update marks of chemistry \nPress 5. to update marks of Math \nPress 6. to update marks of Practical \nPress 7. to go to the Main Menu");
						System.out.println("====================================================");
						int press = Integer.parseInt(JOptionPane.showInputDialog("Enter your Choice:"));
						int sroll1 = (Integer.parseInt(JOptionPane.showInputDialog("Enter student roll:")));
						Students sss = new Students();

						if (press == 1) {

							sss = admindao.updateStudent(sroll1,
									(Integer.parseInt(JOptionPane.showInputDialog("Enter correct Marks of English:"))),
									press);
							JOptionPane.showMessageDialog(null, "data updated for :" + sss.getSname()
									+ "\nUpdated marks:" + sss.getMarks().getM_english());
							System.out.println("data updated for :" + sss.getSname());
							break;
						} else if (press == 2) {

							sss = admindao.updateStudent(sroll1,
									(Integer.parseInt(JOptionPane.showInputDialog("Enter correct Marks of Hindi:"))),
									press);
							JOptionPane.showMessageDialog(null, "data updated for :" + sss.getSname()
									+ "\nUpdated marks:" + sss.getMarks().getM_hindi());
							System.out.println("data updated for :" + sss.getSname());
							break;
						} else if (press == 3) {

							sss = admindao.updateStudent(sroll1,
									(Integer.parseInt(JOptionPane.showInputDialog("Enter correct Marks of Physics:"))),
									press);
							JOptionPane.showMessageDialog(null, "data updated for :" + sss.getSname()
									+ "\nUpdated marks:" + sss.getMarks().getM_physics());
							System.out.println("data updated for :" + sss.getSname());
							break;
						} else if (press == 4) {

							sss = admindao
									.updateStudent(sroll1,
											(Integer.parseInt(
													JOptionPane.showInputDialog("Enter correct Marks of Chemistry:"))),
											press);
							JOptionPane.showMessageDialog(null, "data updated for :" + sss.getSname()
									+ "\nUpdated marks:" + sss.getMarks().getM_chemistry());
							System.out.println("data updated for :" + sss.getSname());
							break;
						} else if (press == 5) {

							sss = admindao.updateStudent(sroll1,
									(Integer.parseInt(JOptionPane.showInputDialog("Enter correct Marks of Math:"))),
									press);
							JOptionPane.showMessageDialog(null, "data updated for :" + sss.getSname()
									+ "\nUpdated marks:" + sss.getMarks().getM_math());
							System.out.println("data updated for :" + sss.getSname());
							break;
						} else if (press == 6) {

							sss = admindao
									.updateStudent(sroll1,
											(Integer.parseInt(
													JOptionPane.showInputDialog("Enter correct Marks of Practical:"))),
											press);
							JOptionPane.showMessageDialog(null, "data updated for :" + sss.getSname()
									+ "\nUpdated marks:" + sss.getMarks().getM_practical());
							System.out.println("data updated for :" + sss.getSname());
							break;
						} else if (press == 7) {
							crudMain();

						}

					}

					break;
				case 4:
					Students issue = admindao.fetchStudentsissues(Integer.parseInt(JOptionPane.showInputDialog("Enter student's roll ")));
					System.out.println("Name: "+issue.getSname()+" Issue: "+issue.getStudentsissues().getIssue());
						
					break;
				case 5:
					admindao.deleteStudent(
							Integer.parseInt(JOptionPane.showInputDialog("Enter student's roll to delete")));
					break;
				case 6:
					crudMain();
					break;
				default:
					System.out.println("invalid choice");
					JOptionPane.showMessageDialog(null, "invalid choice!");

				}
			}
		} else {
			System.out.println("invalid id or password");
		}
	}

	private static void crudStudent() {
		int sroll = Integer.parseInt(JOptionPane.showInputDialog("Enter your roll:"));
		Students student = logindao.studentLogin(sroll, JOptionPane.showInputDialog("Enter your password"));
		if (student != null) {
			while (true) {

				System.out.println(
						"press 1. to fetchMarksheet \nPress 2. to submit issue \nPress 3. to go to the Main Menu");
				System.out.println("====================================================");
				int ch = Integer.parseInt(JOptionPane.showInputDialog("Enter your Choice:"));
				switch (ch) {
				case 1:
					Students v = studentsdao.fetchStudent(sroll);
					System.out.println("student_roll: " + v.getSroll() + "\nstudent_name: " + v.getSname()
							+ "\nstudent_email: " + v.getSemail() + "\nstudent_phone: " + v.getScontact());
					System.out.println("MARKS DETAILS");
					Marks ms = v.getMarks();
					System.out.println("English: " + ms.getM_english() + "\nHindi: " + ms.getM_hindi() + "\nMath: "
							+ ms.getM_math() + "\nChemistry: " + ms.getM_chemistry() + "\nPhysics:  "
							+ ms.getM_physics() + "\nPractical: " + ms.getM_practical());
					int marks_acquired = ms.getM_english() + ms.getM_hindi() + ms.getM_math() + ms.getM_chemistry()
							+ ms.getM_physics() + ms.getM_practical();
					int percentage = (marks_acquired * 100 / 600);
					System.out.println("Marks Acquired:" + marks_acquired + "/600");
					System.out.println("Percentage: " + percentage + "%");

					if (percentage <= 40) {
						System.out.println("Grade:D" + " " + "\nStatus:Fail");
					}
					else if (percentage > 40 && percentage <= 60) {
						System.out.println("Grade:C" + " " + "\nStatus:Pass");
					} else if (percentage > 60 && percentage <= 80) {
						System.out.println("Grade:B" + " " + "\nStatus:Pass");
					} else if (percentage > 80 && percentage <= 100) {
						System.out.println("Grade:A" + " " + "\nStatus:Pass");
					}
					JOptionPane.showMessageDialog(null, "Marks Fetched \nCheck your console Window.");
					System.out.println("________________________________");

					break;
				case 2:
					studentsdao.addStudentIssues(sroll, JOptionPane.showInputDialog("write your issue: "));
					break;
				case 3:
					crudMain();
				default:
					throw new IllegalArgumentException("Unexpected value: " + ch);
				}
			}
		}
	}
}
