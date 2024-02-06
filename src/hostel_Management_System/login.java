package hostel_Management_System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
class login{
	 private String email;
     private String psd;
     private String role;
     private boolean flag;
     public login() {
    	 Scanner cs=new Scanner(System.in);
    	 System.out.println("ENTER EMAIL ID: ");
		 this.email=cs.nextLine();
		 System.out.println("ENTER PASSWORD: ");
		 this.psd=cs.nextLine();
		 System.out.println("ENTER ROLE: ");
		 this.role=cs.nextLine();
     }
     public  void setMail(String email) {
    	 this.email=email;
     }
     public String getMail() {
    	 return email;
     }
	 public void setPass(String psd) {
		 this.psd=psd;
	 }
	 public String getPass() {
		 return psd;
	 }
	 public void setRole(String role) {
		 this.psd=psd;
	 }
	 public String getRole() {
		 return role;
	 }
	 public  boolean getFlag() {
		 return flag;
	 }
	public void checkLogin(String email,String pass) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
		//Statement sts=con.createStatement();
		String query="SELECT EMAIL_ID,PASSWORD FROM login WHERE ROLE=?";
		 PreparedStatement p = con.prepareStatement(query);
         p.setString(1, role);
		ResultSet rl=p.executeQuery();
		while(rl.next()) {
			String eml=rl.getString(1);
			String psd=rl.getString(2);
			if(eml.equals(email)) {
				if(psd.equals(pass)) {
					System.out.println("WELCOME "+role.toUpperCase());
					flag=true;
					break;
				}
				else {
					System.out.println("INCORRECT PASSWORDdd");
					flag=false;
				}
			}
			else {
				System.out.println("INVALID EMAIL");
				flag=false;
			}
		}
	}
}