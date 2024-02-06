package hostel_Management_System;
import java.util.*;
import java.sql.*;
public class signUp {
    String email;
    String password; 
    String role;
    public void signUpAll() throws SQLException {
        Scanner cs=new Scanner(System.in);
        System.out.println("ENTER EMAIL TO SIGNUP");
        String email=cs.nextLine().trim();
        System.out.println("ENTER PASSWORD");
        String password=cs.nextLine();
        System.out.println("Enter the role");
        String role=cs.nextLine().toLowerCase();

        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","Thara@123^123")) {
            String query1 = "SELECT PASSWORD FROM login WHERE ROLE=? AND EMAIL_ID=?";
            PreparedStatement psd = con.prepareStatement(query1);
            psd.setString(1, role);
            psd.setString(2, email);

            ResultSet rs = psd.executeQuery();
            if (rs.next()) {
                String existingPassword = rs.getString(1);
                if (existingPassword.isEmpty()) {
                    String query3 = "UPDATE login SET SHA2(PASSWORD=?,256) WHERE EMAIL_ID=? AND ROLE=?";
                    PreparedStatement p = con.prepareStatement(query3);
                    p.setString(1, password);
                    p.setString(2, email);
                    p.setString(3, role);
                    int updatedRows = p.executeUpdate();
                    if (updatedRows == 1) {
                        System.out.println("Password updated successfully.");
                    } else {
                        System.out.println("Password update failed.");
                    }
                } else {
                    System.out.println("ALREADY YOU HAVE AN ACCOUNT");
                }
            } else {
                System.out.println("ENQUIRY WITH ADMIN TO ADD YOU");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }    	 
     }

}
