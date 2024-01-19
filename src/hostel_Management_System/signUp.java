package hostel_Management_System;
import java.util.*;
import java.sql.*;
public class signUp {
     String email;
     String password; 
     public void signUpAll() throws SQLException {
    	 Scanner cs=new Scanner(System.in);
    	 System.out.println("ENTER EMAIL TO SIGNUP");
    	 String email=cs.nextLine();
    	 System.out.println("ENTER PASSWORD");
    	 String password=cs.nextLine();
    	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123");
    	 String query1="SELECT C_EMAIL,C_PASSWORD FROM CUSTOMER;";
    	 Statement sts=con.createStatement();
    	 ResultSet rs=sts.executeQuery(query1);
    	 String str="",str1="";
    	 int customer=0;
    	 while(rs.next()){
    		 str=rs.getString(1);
    		 str1=rs.getString(2);
    		if(str.equals(email)) {
    			if(str1.isEmpty()) {
    			String query3="UPDATE CUSTOMER SET C_PASSWORD=? WHERE C_EMAIL=?";
    			PreparedStatement p=con.prepareStatement(query3);
    			p.setString(1,password);
    			p.setString(2,email);
    			 customer=p.executeUpdate();
    			if(customer==1)
    				break;
    			}
    			else {
    				System.out.println("ALREADY YOU HAVE AN ACCOUNT");
    				customer=1;
    			}
    		}
    		else {
    			customer=1;
    			System.out.println("ENQUIRY WITH ADMIN TO ADD YOU");
    		}
    	 }
    	 int warden=0;
    	if(customer!=1  ) {
    		 String query11="SELECT W_EMAIL,W_PASSWORD FROM WARDEN;";
        	 Statement st=con.createStatement();
        	 ResultSet r=st.executeQuery(query11);
        	 String s="",s1="";
        	 while(r.next()){
        		 s=r.getString(1);
        		 s1=r.getString(2);
        		if(s.equals(email)) {
        			if(s1.isEmpty()){
        			String query33="UPDATE WARDEN SET W_PASSWORD=? WHERE W_EMAIL=?";
        			PreparedStatement psd=con.prepareStatement(query33);
        			psd.setString(1,password);
        			psd.setString(2,email);
        			 warden=psd.executeUpdate();
        			if(warden==1)
        				break;
        		}
        			else
        				System.out.println("ALREADY YOU HAVE AN ACCOUNT");
        		}
        		else
        			System.out.println("ENQUIRY WITH ADMIN TO ADD YOU");
        	 }
    	}
    	else if(warden!=1 && customer!=1){
    		System.out.println("ENQUIRY WITH ADMIN TO ADD YOU");
    	}
     }


}
