package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import dao.CashDonation;
import dao.ItemDonation;
import exception.InsufficientFundsException;
import exception.InvalidInputException;

public class DonationRecordingApp {

    @SuppressWarnings("resource")
	public void runIndex()throws InvalidInputException,InsufficientFundsException {
        try {
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Pet","root","12345");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select donation type:");
            System.out.println("1. Cash Donation");
            System.out.println("2. Item Donation");
            System.out.print("Enter choice (1 or 2): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                recordCashDonation(connection);
            } else if (choice == 2) {
                recordItemDonation(connection);
            } else {
            	throw new InvalidInputException("You have entered invalid input ");
            }
            scanner.close();
            connection.close();
        } 
        catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } 
        catch (InvalidInputException e) {
        	System.out.println(e.getMessage());
        }
        catch (InsufficientFundsException e) {
        	System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
    private static void recordCashDonation(Connection connection) throws SQLException, InsufficientFundsException {
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Enter donor name: ");
        String donorName = scanner.nextLine();
        System.out.print("Enter donation Amount: ");
        Double donationAmount = scanner.nextDouble();    
        int donation_id=(int) (Math.random()*1000);
        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
        scanner.close();
        if(donationAmount<10) {
        	throw new InsufficientFundsException("minimum donation amount must be greater then 10 Please try again ");
        }
        CashDonation itemDonation = new CashDonation(donorName,donationAmount,donation_id,"Cash",currentDate);
        PreparedStatement ps = connection.prepareStatement("insert into Donation(d_id,d_donarName,d_type,d_date) values(?,?,?,?)"); 
        ps.setInt(1, donation_id);
        ps.setString(2, donorName);
        ps.setString(3, "Cash");
        ps.setDate(4, sqlDate);
        int c = ps.executeUpdate();
        
        ps = connection.prepareStatement("insert into Donation_Cash(d_id,d_amount) values(?,?)"); 
        ps.setInt(1, donation_id);
        ps.setDouble(2, donationAmount);
        int cd = ps.executeUpdate(); System.out.println(cd +" record inserted...");
        
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Donation_Cash");
        while (rs.next()) {
        	System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
        }
        System.out.println("Item donation recorded successfully.");
    }

    private static void recordItemDonation(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter donor name: ");
        String donorName = scanner.nextLine();
        System.out.print("Enter donation Item: ");
        String donationItem = scanner.nextLine();    
        System.out.print("Enter donation Quantity: ");
        int donationQuantity = scanner.nextInt();
        System.out.print("Enter item type: ");
        String itemType = scanner.nextLine();
        int donation_id=(int) (Math.random()*1000);
        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
        scanner.close();
        ItemDonation itemDonation = new ItemDonation(donorName,donationItem,donationQuantity,donation_id,"Item",currentDate);
        PreparedStatement ps = connection.prepareStatement("insert into Donation(d_id,d_donarName,d_type,d_date) values(?,?,?,?)"); 
        ps.setInt(1, donation_id);
        ps.setString(2, donorName);
        ps.setString(3, "Item");
        ps.setDate(4, sqlDate);
        int c = ps.executeUpdate();
        
        ps = connection.prepareStatement("insert into Donation_Item(d_id,d_item,d_quantity) values(?,?,?)"); 
        ps.setInt(1, donation_id);
        ps.setString(2, donationItem);
        ps.setInt(3, donationQuantity);
        int cd = ps.executeUpdate(); System.out.println(cd +" record inserted...");
        
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Donation_Item");
        while (rs.next()) {
        	System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
        }
        System.out.println("Item donation recorded successfully.");
    }
}