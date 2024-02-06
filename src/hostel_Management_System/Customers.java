package hostel_Management_System;
import java.util.*;
import java.sql.*;
public class Customers {
 int c_no;
 String c_Name;
 String c_Address;
 String c_gender;
 int c_age;
 String joining;
 String c_phNo;
 int r_no;
 float r_amt;
 String email;
 String status;
 public void addCustomer(String c_Name,String c_Address,String c_gender,int c_age,String joining,String c_phNo,int r_no,float r_amt,String email) throws SQLException{
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
	 Statement sts=con.createStatement();
	 String check="SELECT R_STATUS FROM ROOM";
	 ResultSet r=sts.executeQuery(check);
	 String status="";
	 while(r.next())
			status=r.getString(1);
	 if(status.equalsIgnoreCase("unfilled")) {
		String query="INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?,?,?);";
		String role="customer";
		String q1="INSERT INTO LOGIN VALUES(?,?,?,?);";
		String q="Select count(C_NO)+1 from Customer";
		
		int count=0;
		ResultSet rl=sts.executeQuery(q);
		while(rl.next()) 
		 count=rl.getInt(1);
		String qry="UPDATE ROOM SET R_STATUS='FILLED' WHERE R_NO="+r_no+";";
		
		sts.executeUpdate(qry);
		PreparedStatement psd=con.prepareStatement(query);
		PreparedStatement p=con.prepareStatement(q1);
		p.setInt(1,count);
		p.setString(2, email);
		p.setString(3, "");
		p.setString(4, role);
		int r2=p.executeUpdate();
		psd.setInt(1,count);
		psd.setString(2,c_Name);
		psd.setString(3,c_Address);
		psd.setString(4,c_gender);
		psd.setInt(5,c_age);
		psd.setString(6,joining);
		psd.setString(7,c_phNo);
		psd.setInt(8,r_no);
		psd.setFloat(9,r_amt);
		psd.setString(10,email);
		psd.setString(11, status);
		int r1=psd.executeUpdate();
		if(r1==1) {
			System.out.println("Sucessfully added Customer");
		}
	 }
	 else {
		 System.out.println("Sorry,choose another room,already the room is filled");
	 }
 }
 public void updateCustomerPhone() throws SQLException {
	 Scanner cs=new Scanner(System.in);
		System.out.println("ENTER THE CUSTOMER NO TO CHANGE PHONE NUMBER");
		int c_no=cs.nextInt();
		cs.nextLine();
		System.out.println("ENTER THE PHONE NUMBER TO CHANGE");
		String phNo=cs.next();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
			String query="UPDATE CUSTOMER SET C_phNo=? WHERE C_NO=?";
			PreparedStatement psd=con.prepareStatement(query);
			psd.setString(1,phNo);
			psd.setInt(2, c_no);
			int rl =psd.executeUpdate();
			if(rl==1)
				System.out.println("UPDATED CUSTOMER PHONE NO SUCESSFULLY");
 }
 public void updateCustomerRoom() throws SQLException {
	 Scanner cs=new Scanner(System.in);
		System.out.println("ENTER THE CUSTOMER NO TO CHANGE ROOM");
		int c_no=cs.nextInt();
		cs.nextLine();
		System.out.println("ENTER THE ROOM NUMBER TO CHANGE");
		int room=cs.nextInt();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
			String query="UPDATE CUSTOMER SET R_NO=? WHERE C_NO=?";
			PreparedStatement psd=con.prepareStatement(query);
			psd.setInt(1,room);
			psd.setInt(2, c_no);
			int rl =psd.executeUpdate();
			if(rl==1)
				System.out.println("UPDATED CUSTOMER ROOM SUCESSFULLY");
 }
 public void updateCustomerStatus() throws SQLException {
	 Scanner cs=new Scanner(System.in);
		System.out.println("ENTER THE CUSTOMER NO TO CHANGE STATUS");
		int c_no=cs.nextInt();
		cs.nextLine();
		System.out.println("ENTER THE STATUS TO CHANGE");
		String status=cs.nextLine();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
			String query="UPDATE CUSTOMER SET C_STATUS=? WHERE C_NO=?";
			PreparedStatement psd=con.prepareStatement(query);
			psd.setString(1,status);
			psd.setInt(2, c_no);
			int rl =psd.executeUpdate();
			if(rl==1)
				System.out.println("UPDATED CUSTOMER ROOM SUCESSFULLY");
 }
 
 public void updateCustomerRent() throws SQLException {
	 Scanner cs=new Scanner(System.in);
		System.out.println("ENTER THE CUSTOMER NO TO CHANGE CUSTOMER RENT");
		int c_no=cs.nextInt();
		cs.nextLine();
		System.out.println("ENTER THE RENT AMOUNT TO CHANGE");
		int rent=cs.nextInt();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
			String query="UPDATE CUSTOMER SET R_RENT=? WHERE C_NO=?";
			PreparedStatement psd=con.prepareStatement(query);
			psd.setInt(1,rent);
			psd.setInt(2, c_no);
			int rl =psd.executeUpdate();
			if(rl==1)
				System.out.println("UPDATED RENT AMOUNT SUCESSFULLY");
 }
public void deleteCustomer() throws SQLException {
	Scanner cs=new Scanner(System.in);
	 System.out.println("ENTER CUSTOMER NUMBER TO DELETE");
	 int c_no=cs.nextInt();
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
		String query="DELETE FROM CUSTOMER WHERE C_NO=?";
		String q="SELECT R_NO FROM CUSTOMER";
		Statement sts=con.createStatement();
		ResultSet rs=sts.executeQuery(q);
		int room=0;
		while(rs.next())
		room = rs.getInt(1);
		String qry="UPDATE ROOM SET R_STATUS='UNFILLED' WHERE R_NO="+room+";";
		sts.executeUpdate(qry);
		PreparedStatement psd=con.prepareStatement(query);
		psd.setInt(1, c_no);
		int rl =psd.executeUpdate();
		if(rl==1)
			System.out.println("DELETED CUSTOMER SUCESSFULLY");
 }
}
