package com.ams;

import java.util.List;

import javax.swing.JOptionPane;

import com.ams.dto.AdminDTO;
import com.ams.dto.AlumniDTO;
import com.ams.dto.DepartmentDTO;
import com.ams.entity.Admin;
import com.ams.entity.Alumni;
import com.ams.entity.Department;
import com.ams.service.AdminService;
import com.ams.service.AlumniService;
import com.ams.service.DepartmentService;
import com.ams.serviceimpl.AdminServiceImpl;
import com.ams.serviceimpl.AlumniServiceImpl;
import com.ams.serviceimpl.DepartmentServiceImpl;



public class CrudOperation {
	
	//main menu for all crud operations
	public static void mainMenu() {
		while(true) {
			
			//User Menu list
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("+               MAIN-MENU            +");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("|      Enter 1. -> Admin Menu        |");
			System.out.println("|      Enter 2. -> Alumni Menu       |");
			System.out.println("|      Enter 3. -> Department Menu   |");
			System.out.println("|      Enter 4. -> Exit              |");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			
			switch(Integer.parseInt(JOptionPane.showInputDialog("Enter your choice..."))) {
				
				case 1: crudAdmin();
				break;
				
				case 2: crudAlumni();
				break;
				
				case 3: crudDepartment();
				break;
				
				case 4: System.exit(0);
				break;
				
				default: 
					System.out.println("Invalid choice!");
					JOptionPane.showMessageDialog(null, "Invalid choice!");
					break;
					
			}//end switch case
		}//end while loop
	}//end mainMenu()
		
	
	// instantiating polymorphic service objects
	static AdminService serviceAdmin = new AdminServiceImpl();
	static AlumniService serviceAlumni = new AlumniServiceImpl();
	static DepartmentService serviceDepartment = new DepartmentServiceImpl();
	
	//crud operations for admin
	public static void crudAdmin() {
		
		while(true) {
			
			//Admin Menu list
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("+             ~ADMIN-MENU~           +");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("| Enter 1. -> Create Admin           |"+
							 "\n| Enter 2. -> All Alumni Detail      |"+
							 "\n| Enter 3. -> All Department Details |"+
							 "\n| Enter 4. -> Change Admin Password  |"+
							 "\n| Enter 5. -> Delete Admin           |"+
							 "\n| Enter 6. -> Delete Alumni          |"+
							 "\n| Enter 7. -> Go to Main-Menu        |"+
							 "\n| Enter 8. -> Exit                   |");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			
			switch(Integer.parseInt(JOptionPane.showInputDialog("Enter your choice..."))) {
			
			case 1: 
				//creating admin object reference
				Admin admin = new Admin();
				//setting all details into admin using user-input
				admin.setAdusername(JOptionPane.showInputDialog("Enter admin's username..."));
				admin.setAdpassword(JOptionPane.showInputDialog("Enter a password (max length 15)"));
				admin.setAdname(JOptionPane.showInputDialog("Enter admin's name..."));
				admin.setAdemail(JOptionPane.showInputDialog("Enter admin's email"));
				
				//invoking create method to create account of admin
				serviceAdmin.createAdmin(admin);
				break;
			
			case 2:	//fetchAllAlumni
				try {
				List<AlumniDTO> alumnis = serviceAdmin.fetchAlumni(JOptionPane.showInputDialog("Enter admin username"),
						 									    JOptionPane.showInputDialog("Enter admin password"));
				//displaying the alumni list
					System.out.println("=======================================");
				for (AlumniDTO al : alumnis) {
					System.out.println(
								"Alumni name		:	"+al.getAlname()+
								"\nAlumni email		:	"+al.getAlemail()+																			   								
								"\nAlumni address		:	"+al.getAladdress()+										
								"\nPassing Year		:	"+al.getAlpassyear()+										
								"\nContact			:	"+al.getAlphone()+										
								"\nRoll no.		:	"+al.getAlroll()+										
								"\nDepartment Id		:	"+al.getDepartment().getDid()+										
								"\nDepartment name		:	"+al.getDepartment().getDname()+										
								"\nDepartment head		:	"+al.getDepartment().getDhead()										
									   );
					System.out.println("+++++++++++++++++++++++++++++++++++++++");
				}
				    System.out.println("=======================================");
				}catch(Exception e) {
					System.out.println("Exception: "+ e);
				}
				break;	
			
			case 3:	//fetchAllDepartment
				try {
				List<DepartmentDTO> dept = serviceAdmin.fetchDepartment(JOptionPane.showInputDialog("Enter admin username"),
																	 JOptionPane.showInputDialog("Enter admin password"));
				//displaying the department list
					System.out.println("=======================================");
				for (DepartmentDTO d : dept) {
					System.out.println(
							  "Dept_Id		:	"+d.getDid()+
						    "\nDept_name	:	"+d.getDname()+
						    "\nDept_head	:	"+d.getDhead()																			   																
						   );
					System.out.println("+++++++++++++++++++++++++++++++++++++++");
				}
				    System.out.println("=======================================");
				}catch(Exception e) {
					System.out.println("Exception: "+ e);
				}
				break;	
			
			case 4:	//update admin
				try {
				Admin cAdmin = new Admin();
				cAdmin.setAdpassword(JOptionPane.showInputDialog("Enter your new password"));
				
				//passing user-input 
				AdminDTO chngPass= serviceAdmin.changePassword(JOptionPane.showInputDialog("Enter admin username"),
														 JOptionPane.showInputDialog("Enter admin old password"),
														 cAdmin);
				
				System.out.println("=====================================================");
				System.out.println("Admin "+chngPass.getAdname()+"'s new password is '"+chngPass.getAdpassword()+"'");
				System.out.println("=====================================================");
				}catch(Exception e) {
					System.out.println(e);
				}
				break;	
				
			case 5:	//delete admin
				//passing user-input for deleting admin 
				serviceAdmin.deleteAdmin(JOptionPane.showInputDialog("Enter admin username"),
						 				 JOptionPane.showInputDialog("Enter admin password"));
				break;	
				
			case 6:	//deletealumni
				//passing user-input for deleting alumni
				serviceAdmin.deleteAlumni(JOptionPane.showInputDialog("Enter admin username"),
										  JOptionPane.showInputDialog("Enter admin password"),
										  Integer.parseInt(JOptionPane.showInputDialog("Enter your Roll")				
										 ));
				break;	
				
//			case 7:	//deletedepartment
//				//passing user-input for deleting dapt
//				serviceAdmin.deleteDepartment(JOptionPane.showInputDialog("Enter admin username"),
//											  JOptionPane.showInputDialog("Enter admin password"),
//											  Integer.parseInt(JOptionPane.showInputDialog("Enter department id")				
//											 ));
//				break;	
				
			case 7:	//mainMenu()
				mainMenu();
				break;
			
			case 8: //exit()	
				System.exit(0);
				
			default:
				System.out.println("Invalid choice!");
				JOptionPane.showMessageDialog(null, "Invalid choice!");
			}// switch end
		}//while end
	}//crudAdmin end
	
	//crud operations for alumni
	public static void crudAlumni() {
		while(true) {
			
			//alumni Menu list
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("+              Alumni Menu           +");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("|   Enter 1. -> Create Alumni        |"+
							 "\n|   Enter 2. -> Fetch Alumni Details |"+
							 "\n|   Enter 3. -> Change password      |"+							
							 "\n|   Enter 4. -> Go to Main-Menu      |"+
							 "\n|   Enter 5. -> Exit                 |");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			
			switch(Integer.parseInt(JOptionPane.showInputDialog("Enter your choice..."))) {
			case 1: 
				//creating alumni object reference
				Alumni al = new Alumni();
				Department d = new Department();
				//setting all details into alumni using user-input
				al.setAlroll(Long.parseLong(JOptionPane.showInputDialog("Enter Alumni roll no (length must be 10)")));
				al.setAlpassword(JOptionPane.showInputDialog("Enter Alumni a password (size = min. 5 & max 10)"));
				al.setAlname(JOptionPane.showInputDialog("Enter Alumni name"));
				al.setAlemail(JOptionPane.showInputDialog("Enter Alumni email"));
				al.setAladdress(JOptionPane.showInputDialog("Enter Alumni address"));
				al.setAlpassyear(Integer.parseInt(JOptionPane.showInputDialog("Enter passout year")));
				al.setAlphone(Long.parseLong(JOptionPane.showInputDialog("Enter alumni phone")));
				d.setDname(JOptionPane.showInputDialog("Enter Department name"));
				d.setDhead(JOptionPane.showInputDialog("Enter Department head"));
				al.setDepartment(d);
				
				//invoking create method to create account of alumni
				serviceAlumni.addAlumni(al);
				break;
			
			case 2:	//fetchAllalumni
				try {
					List<AlumniDTO> alumni = serviceAlumni.fetchAlumni(Long.parseLong(JOptionPane.showInputDialog("Enter your Roll")),
						 										JOptionPane.showInputDialog("Enter your password"));
				//displaying the alumni list
					System.out.println("=======================================");
				for (AlumniDTO ai : alumni) {
					System.out.println(
							  "\nAlumni Roll	:	"+ai.getAlroll()+
							  "\nAlumni Name	:	"+ai.getAlname()+
							  "\nAlumni Email	:	"+ai.getAlemail()+																			   								
							  "\nAlumni Phone	:	"+ai.getAlphone()+										
							  "\nPassout Year	:	"+ai.getAlpassyear()+										
							  "\nAddress		:	"+ai.getAladdress()+
							  "\nDept. Name	:	"+ai.getDepartment().getDname()+
							  "\nDept. Head	:	"+ai.getDepartment().getDhead()								
									   );
					System.out.println("+++++++++++++++++++++++++++++++++++++++");
				}
				    System.out.println("=======================================");
				}catch(Exception e) {
					System.out.println("Exception: "+ e);
				}
				
				break;
				
			case 3:	//change alumni Password
				try {
					Alumni cAlpass = new Alumni();
					cAlpass.setAlpassword(JOptionPane.showInputDialog("Enter Alumni's new password"));
					//passing user-input into changePassword
					AlumniDTO chngAlpass= serviceAlumni.changePassword(Integer.parseInt(JOptionPane.showInputDialog("Enter Alumni roll")),
																JOptionPane.showInputDialog("Enter Alumni old password"),
																cAlpass
																);
					
					System.out.println("=====================================================");
					System.out.println("Alumni "+chngAlpass.getAlname()+"'s new Password is '"+chngAlpass.getAlpassword()+"'");
					System.out.println("=====================================================");
				}catch(Exception e) {
					System.out.println("Exception: "+ e);
				}
				break;
			
				
			case 4:	//mainMenu()
				mainMenu();
				break;
			
			case 5: //exit()	
				System.exit(0);
				
			default:
				System.out.println("Invalid choice!");
				JOptionPane.showMessageDialog(null, "Invalid choice!");
			}// switch end
		}//while end
	}//crudAlumni end
	
	//crud operations for department
	public static void crudDepartment() {
		
		while(true) {	//for looping
			
			//dept Menu list
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("+           Department Menu          +");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("| Enter 1.-> Create Dept             |"+
							 "\n| Enter 2.-> All Alumnis Detail      |"+
							 "\n| Enter 3.-> Find Alumni by Dept. Id |"+
							 "\n| Enter 4.-> Go to Main-Menu         |"+
							 "\n| Enter 5.-> Exit                    |");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			
			switch(Integer.parseInt(JOptionPane.showInputDialog("Enter your choice..."))) {
			
			case 1: //create Account
				//creating department object reference
				Department dt = new Department();
				//setting all details into department using user-input
				dt.setDname((JOptionPane.showInputDialog("Enter Department name")));
				dt.setDhead(JOptionPane.showInputDialog("Enter Department head"));
				
				//invoking create method to create dept.
				serviceDepartment.addDepartment(dt);
				break;
				
			case 2:	//fetching dept details 
				try {
					List<AlumniDTO> alumnis = serviceDepartment.fetchAlumnis();
				//displaying the department list
				System.out.println("=======================================");
				for (AlumniDTO al : alumnis) {
					System.out.println( 
									  "\nAlumni Roll	:	"+al.getAlroll()+
									  "\nAlumni Name	:	"+al.getAlname()+
									  "\nAlumni Email	:	"+al.getAlemail()+																			   								
									  "\nAlumni Phone	:	"+al.getAlphone()+										
									  "\nPassout Year	:	"+al.getAlpassyear()+										
									  "\nAddress		:	"+al.getAladdress()+
									  "\nDept. Name		:	"+al.getDepartment().getDname()+
									  "\nDept. Head		:	"+al.getDepartment().getDhead()																				   																
									   );
				System.out.println("+++++++++++++++++++++++++++++++++++++++");
				}
				System.out.println("=======================================");
				
				}catch(Exception e) {
					System.out.println("Exception: "+ e);
				}
				
				break;
				
			case 3:	//fetching dept details by department id
				try {
					List<AlumniDTO> alumnis = serviceDepartment.fetchAlumniByDeptId(Integer.parseInt(JOptionPane.showInputDialog("Enter Department Id to find Alumni")));
				//displaying the department list
				System.out.println("=======================================");
				for (AlumniDTO al : alumnis) {
					System.out.println( 
									  "\nAlumni Roll	:	"+al.getAlroll()+
									  "\nAlumni Name	:	"+al.getAlname()+
									  "\nAlumni Email	:	"+al.getAlemail()+																			   								
									  "\nAlumni Phone	:	"+al.getAlphone()+										
									  "\nPassout Year	:	"+al.getAlpassyear()+										
									  "\nAddress		:	"+al.getAladdress()+
									  "\nDept. Name		:	"+al.getDepartment().getDname()+
									  "\nDept. Head		:	"+al.getDepartment().getDhead()																				   																
									   );
				System.out.println("+++++++++++++++++++++++++++++++++++++++");
				}
				System.out.println("=======================================");
				
				}catch(Exception e) {
					System.out.println("Exception: "+ e);
				}
				break;
				
			case 4:	//mainMenu()
				mainMenu();
				break;
			
			case 5: //exit()	
				System.exit(0);
				
			default:
				System.out.println("Invalid choice!");
				JOptionPane.showMessageDialog(null, "Invalid choice!");
				
			}// switch end
		}//while end
	}//crudDepartment end
	
//============================================================================================================
	
}