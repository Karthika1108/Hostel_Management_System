package hostel_Management_System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.*;
class room{
	int r_no;
	String type;
	float rent;
	int floor;
	String status;
	public void addRoom(int r_no,String type,float rent,int floor,String status) throws SQLException {
		try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
		String query="INSERT INTO ROOM VALUES(?,?,?,?,?);";
		PreparedStatement psd=con.prepareStatement(query);
		psd.setInt(1,r_no);
		psd.setString(2,type);
		psd.setFloat(3,rent);
		psd.setInt(4,floor);
		psd.setString(5,status);
		int rl=psd.executeUpdate();
		if(rl>0) {
			System.out.println("Sucessfully added Room");
		}
		}
		catch(SQLException ex) {
			System.out.println("room already finded");
		}
	}
	public void updateType() throws SQLException {
		Scanner cs=new Scanner(System.in);
		System.out.println("ENTER THE ROOM NO TO CHANGE ROOM TYPE");
		int r_no=cs.nextInt();
		cs.nextLine();
		System.out.println("ENTER THE ROOM TYPE TO CHANGE");
		String type=cs.next();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
			String query="UPDATE ROOM SET R_TYPE=? WHERE R_NO=?";
			PreparedStatement psd=con.prepareStatement(query);
			psd.setString(1,type);
			psd.setInt(2, r_no);
			int rl =psd.executeUpdate();
			if(rl==1)
				System.out.println("UPDATED ROOM TYPE SUCESSFULLY");
	}
    public void updateRent() throws SQLException {
    	Scanner cs=new Scanner(System.in);
		System.out.println("ENTER THE ROOM NO TO CHANGE ROOM RENT");
		int r_no=cs.nextInt();
		cs.nextLine();
		System.out.println("ENTER THE ROOM RENT TO CHANGE");
		float rent=cs.nextFloat();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
			String query="UPDATE ROOM SET R_RENT=? WHERE R_NO=?";
			PreparedStatement psd=con.prepareStatement(query);
			psd.setFloat(1,rent);
			psd.setInt(2, r_no);
			int rl =psd.executeUpdate();
			if(rl==1)
				System.out.println("UPDATED ROOM RENT SUCESSFULLY");
	}
    public void updateStatus() throws SQLException {
    	Scanner cs=new Scanner(System.in);
		System.out.println("ENTER THE ROOM NO TO CHANGE ROOM STATUS");
		int r_no=cs.nextInt();
		cs.nextLine();
		System.out.println("ENTER THE ROOM STATUS TO CHANGE");
		String status=cs.next();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
			String query="UPDATE ROOM SET R_STATUS=? WHERE R_NO=?";
			PreparedStatement psd=con.prepareStatement(query);
			psd.setString(1,status);
			psd.setInt(2, r_no);
			int rl =psd.executeUpdate();
			if(rl==1)
				System.out.println("UPDATED ROOM STATUS SUCESSFULLY");
    }
    public void deleteRoom() throws SQLException {
    	Scanner cs=new Scanner(System.in);
   	 System.out.println("ENTER ROOM NUMBER TO DELETE");
   	 int r_no=cs.nextInt();
   	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
   		String query="DELETE FROM ROOM WHERE R_NO=?";
   		PreparedStatement psd=con.prepareStatement(query);
   		psd.setInt(1, r_no);
   		int rl =psd.executeUpdate();
   		if(rl==1)
   			System.out.println("DELETED ROOM SUCESSFULLY");
	}
	
}
