package hostel_Management_System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
class login{
	 private String email;
     private String psd;
     private boolean flag;
     public login() {
    	 Scanner cs=new Scanner(System.in);
    	 System.out.println("ENTER EMAIL ID: ");
		 this.email=cs.next();
		 System.out.println("ENTER PASSWORD: ");
		 this.psd=cs.next();
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
	 public  boolean getFlag() {
		 return flag;
	 }
	public void checkLogin(String email,String pass) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
		Statement sts=con.createStatement();
		String query="SELECT A_EMAIL,A_PASSWORD FROM ADMIN";
		ResultSet rl=sts.executeQuery(query);
		while(rl.next()) {
			String eml=rl.getString(1);
			String psd=rl.getString(2);
			if(eml.equals(email)) {
				if(psd.equals(pass)) {
					System.out.println("WELCOME ADMIN");
					flag=true;
				}
				else {
					System.out.println("INCORRECT PASSWORD");
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