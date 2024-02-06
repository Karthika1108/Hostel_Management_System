package hostel_Management_System;
import java.util.*;
import java.sql.*;
public class wardenn {
 int w_no;
 String w_Name;
 String w_Address;
 String w_gender;
 int c_age;
 String joining;
 String c_phNo;
 float w_salary;
 String email;
 public void addWarden(String w_Name,String w_Address,String w_gender,int w_age,String joining,String w_phNo,float w_salary,String email) throws SQLException{
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
		String query="INSERT INTO WARDEN VALUES(?,?,?,?,?,?,?,?,?);";
		String q="Select count(W_NO)+1 from WARDEN";
		String role="warden";
		String q1="INSERT INTO LOGIN VALUES(?,?,?,?);";
		
		Statement sts=con.createStatement();
		int count=0;
		ResultSet rl=sts.executeQuery(q);
		while(rl.next()) 
		 count=rl.getInt(1);
		PreparedStatement psd=con.prepareStatement(query);
		PreparedStatement p=con.prepareStatement(q1);
		p.setInt(1,count);
		p.setString(2, email);
		p.setString(3, "");
		p.setString(4, role);
		int r2=p.executeUpdate();
		psd.setInt(1,count);
		psd.setString(2,w_Name);
		psd.setString(3,w_Address);
		psd.setString(4,w_gender);
		psd.setInt(5,w_age);
		psd.setString(6,joining);
		psd.setString(7,w_phNo);
		psd.setFloat(8,w_salary);
		psd.setString(9,email);
		int r=psd.executeUpdate();
		if(r==1) {
			System.out.println("Sucessfully added Warden");
		}
 }
 public void  updateWardenPhone() throws SQLException {
	 Scanner cs=new Scanner(System.in);
		System.out.println("ENTER THE WARDEN NO TO CHANGE WARDEN PHONE NUMBER");
		int w_no=cs.nextInt();
		cs.nextLine();
		System.out.println("ENTER THE WARDEN PHONE NUMBER TO CHANGE");
		String phNo=cs.next();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
			String query="UPDATE WARDEN SET W_PHNO=? WHERE W_NO=?";
			PreparedStatement psd=con.prepareStatement(query);
			psd.setString(1,phNo);
			psd.setInt(2, w_no);
			int rl =psd.executeUpdate();
			if(rl==1)
				System.out.println("UPDATED WARDEN PHONE NUMBER SUCESSFULLY");
 }
public void  updateWardenSalary() throws SQLException {
	Scanner cs=new Scanner(System.in);
	System.out.println("ENTER THE WARDEN NO TO CHANGE WARDEN SALARY");
	int w_no=cs.nextInt();
	cs.nextLine();
	System.out.println("ENTER THE WARDEN SALARY TO CHANGE");
	float salary=cs.nextFloat();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
		String query="UPDATE WARDEN SET W_SALARY=? WHERE W_NO=?";
		PreparedStatement psd=con.prepareStatement(query);
		psd.setFloat(1,salary);
		psd.setInt(2, w_no);
		int rl =psd.executeUpdate();
		if(rl==1)
			System.out.println("UPDATED WARDEN SALARY SUCESSFULLY");
 }
public void  deleteWarden() throws SQLException {
	 Scanner cs=new Scanner(System.in);
	 System.out.println("ENTER WARDEN NUMBER TO DELETE");
	 int w_no=cs.nextInt();
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
		String query="DELETE FROM WARDEN WHERE W_NO=?";
		PreparedStatement psd=con.prepareStatement(query);
		psd.setInt(1, w_no);
		int rl =psd.executeUpdate();
		if(rl==1)
			System.out.println("DELETED WARDEN SUCESSFULLY");
 }
}
