package entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import exception.AdoptionException;
import exception.InvalidInputException;
import util.DBConnUtil;

public class AdoptionEventManagement {
	@SuppressWarnings("resource")
	public void runIndex()throws AdoptionException,InvalidInputException {
        try {
        	Scanner sc = new Scanner(System.in);
        	Connection con=DBConnUtil.getConnection();
			Statement st=con.createStatement();
		    ResultSet rs = st.executeQuery("select * from adoption_events");
		    System.out.println("Press 1 to show Upcoming events \n Press 2 for adoption Registration");
		    int t= sc.nextInt();
		    if(t==1) {
			    while(rs.next()) {
			    		System.out.println(rs.getInt(1)+" "+rs.getDate(2)+" "+rs.getString(3));
			    }
		    }
		    else if(t==2) {
		        PreparedStatement ps = con.prepareStatement("insert into participants(participant_id,event_id,participant_name) values(?,?,?)");
		        System.out.println("Enter Participant ID: ");
		        int id =  sc.nextInt();
		        System.out.println("Enter Event ID: ");
		        int e_id=  sc.nextInt();
		        System.out.println("Enter Name: ");
		        String name = sc.next();
		        ps.setInt(1, id);
		        ps.setInt(2, e_id);
		        ps.setString(3,name);
		        int c = ps.executeUpdate(); System.out.println(c+" record inserted...");
		        Statement stmt = con.createStatement();
		        rs = stmt.executeQuery("SELECT * FROM participants");
		        while (rs.next()) {
		        	System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getString(3));
		        } 
		    }
		    else throw new InvalidInputException("Invalid Input Please try again. ");
        } 
        
        catch (SQLException e) {
            if(e.getErrorCode()==1452) {
            	System.out.println("please enter correct event id this event id is not present. ");
            }
            System.err.println("SQL Error: " + e.getMessage());
        } 
        catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
