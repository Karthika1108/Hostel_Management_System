package hostel_Management_System;
import java.util.*;
import java.sql.*;
public class Main {
	public static void main(String[] args) throws SQLException {
		Scanner cs=new Scanner(System.in);
		int option=1;
		while(option!=3  ) {
		System.out.println("1-->SIGNUP\n2-->LOGIN\n3-->EXIT");
			option=	cs.nextInt();
		if(option==1) {	
			signUp s=new signUp();
			s.signUpAll();
		}
		else if(option==2) {
			login log=new login();
			log.checkLogin(log.getMail(),log.getPass());
			if(log.getFlag()) {
			while(option!=5) {
			System.out.println("1-->DISPLAY\n2-->ADD\n3-->UPDATE\n4-->REMOVE\n5-->EXIT");
			option=cs.nextInt();
			if(option==1) {
				
			}
			else if(option==2) {
				while(option!=4) {
				System.out.println("1-->ADD ROOMS\n2-->ADD CUSTOMER\n3-->ADD WARDEN\n4-->EXIT");
				option=cs.nextInt();
				cs.nextLine();
				if(option==1) {
					System.out.println("ENTER ROOM NO: ");
					int r_no=cs.nextInt();
					System.out.println("ENTER ROOM TYPE(SINGLE/DOUBLE/QUATRIPLE:");
				    String type=cs.next();
					System.out.println("ENTER ROOM RENT: ");
					float rent=cs.nextFloat();
					System.out.println("ENTER FLOOR NO: ");
					int floor=cs.nextInt();
					System.out.println("ENTER STATUS OF ROOM");
					String status=cs.next();
					room r=new room();
					r.addRoom(r_no,type,rent,floor,status);
				}
				else if(option==2) {
					Customers c=new Customers();
					System.out.println("Enter User Name: ");
					String c_Name=cs.nextLine();
					 System.out.println("Enter User Address ");
					 String c_Address=cs.nextLine();
					 System.out.println("Enter User Gender: ");
					 String c_gender=cs.nextLine();
					 System.out.println("Enter User Age: ");
					 int c_age=cs.nextInt();
					 cs.nextLine();
					 System.out.println("Enter DATE Of Joining: ");
					 String joining=cs.nextLine();
					 System.out.println("Enter User Phone Number: ");
					 String c_phNo=cs.nextLine();
					 System.out.println("Enter Allocated Room");
					 int r_no=cs.nextInt();
					 System.out.println("Enter Room Rent :");
					 float r_amt=cs.nextFloat();
					 cs.nextLine();
					 System.out.println("Enter email: ");
					 String email=cs.nextLine();
					c.addCustomer(c_Name,c_Address,c_gender,c_age,joining,c_phNo,r_no,r_amt,email);
				}
				else if(option==3) {
					wardenn w=new wardenn();
					 System.out.println("Enter Warden Name: ");
					 String w_Name=cs.nextLine();
					 System.out.println("Enter warden Address ");
					 String w_Address=cs.nextLine();
					 System.out.println("Enter Warden Gender: ");
					 String w_gender=cs.nextLine();
					 System.out.println("Enter User Age: ");
					 int w_age=cs.nextInt();
					 cs.nextLine();
					 System.out.println("Enter DATE Of Joining: ");
					 String joining=cs.nextLine();
					 System.out.println("Enter User Phone Number: ");
					 String w_phNo=cs.nextLine();
					 System.out.println("Enter Warden Salary :");
					 float w_salary=cs.nextFloat();
					 cs.nextLine();
					 System.out.println("Enter email: ");
					 String email=cs.nextLine();
					w.addWarden(w_Name,w_Address,w_gender,w_age,joining,w_phNo,w_salary,email);
				}
				else {
					System.out.println("INVALID OPTION");
				}
			}
				
			}
			else if(option==3) {
				while(option!=4) {
					System.out.println("1-->UPDATE ROOM\n2-->UPDATE CUSTOMER\n3-->UPDATE WARDEN\n4-->EXIT");
					option=cs.nextInt();
					if(option==1) { 
						while(option!=4) {
							System.out.println("1-->UPDATE ROOM TYPE\n2-->UPDATE ROOM RENT\n3-->UPDATE ROOM STATUS\n4-->EXIT");
							option=cs.nextInt();
							if(option==1){
								room r=new room();
								r.updateType();
							}
							else if(option==2) {
								room r=new room();
								r.updateRent();
							}
							else if(option==3) {
								room r=new room();
								r.updateStatus();
							}
							else if(option>4){
								System.out.print("ENTER VALID OPTION");
							}
							else {
								break;
							}
						}
						
						
					}
					else if(option==2) {
						while(option!=4) {
							System.out.println("1-->UPDATE CUSTOMER PHONE NUMBER\n2-->UPDATE CUSTOMER ROOM \n3-->UPDATE ROOM RENT\n4-->EXIT");
							option=cs.nextInt();
							if(option==1){
								Customers c=new Customers();
								c.updateCustomerPhone();
							}
							else if(option==2) {
								Customers c=new Customers();
								c.updateCustomerRoom();
							}
							else if(option==3) {
								Customers c=new Customers();
								c.updateCustomerRent();
							}
							else if(option>4){
								System.out.print("ENTER VALID OPTION");
							}
							else {
								break;
							}
						}
						
					}
					else if(option==3) {
						option=1;
						while(option!=3) {
							System.out.println("1-->UPDATE WARDEN PHONE NUMBER\n2-->UPDATE WARDEN SALARY \n3-->EXIT");
							option=cs.nextInt();
							if(option==1){
								wardenn w=new wardenn();
								w.updateWardenPhone();
							}
							else if(option==2) {
								wardenn w=new wardenn();
								w.updateWardenSalary();
							}
							
							else if(option>3){
								System.out.print("ENTER VALID OPTION");
							}
							else {
								break;
							}
						}
					}
					else {
						System.out.println("INVALID OPTION");
					}
				}
			}
			else if(option==4) {
				option=1;
				while(option!=4) {
					System.out.println("1-->DELETE ROOM\n2-->DELETE CUSTOMER\n3-->DELETE WARDEN\n4-->EXIT");
					option=cs.nextInt();
					if(option==1) {
						room r=new room();
						System.out.println("CONFIRM DO YOU NEED TO DELETE??(Y/N)");
						String confirm=cs.next();
						if(confirm.equals("Y")||confirm.equals("y"))
						r.deleteRoom();
						else
						System.out.println("THINK MULTIPLE AND DECIDE");
					}
					else if(option==2) {
						Customers c=new Customers();
						System.out.println("CONFIRM DO YOU NEED TO DELETE??(Y/N)");
						String confirm=cs.next();
						if(confirm.equals("Y")||confirm.equals("y"))
						c.deleteCustomer();
						else
							System.out.println("THINK MULTIPLE AND DECIDE");
					}
					else if(option==3) {
						wardenn w=new wardenn();
						System.out.println("CONFIRM DO YOU NEED TO DELETE??(Y/N)");
						String confirm=cs.next();
						if(confirm.equals("Y")||confirm.equals("y"))
						w.deleteWarden();
						else
							System.out.println("THINK MULTIPLE AND DECIDE");
					}
					else {
						System.out.println("INVALID OPTION");
					}
				}
			}
			else {
				System.out.println("ENTER VALID OPTION");
			}
		  }
			
		}
		   else {
			   System.out.println("ENTER VALID OPTION");
		   }
		}
	}
}
}