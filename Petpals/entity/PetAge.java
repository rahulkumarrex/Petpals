package entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import exception.InvalidInputException;
import util.DBConnUtil;
public class PetAge {
	public static void CheckPetAge()
	{
		try (Scanner sc = new Scanner(System.in);
			Connection con=DBConnUtil.getConnection();) {
			System.out.println("Enter pet Id ");
			int petID=sc.nextInt();
			sc.nextLine(); 
            System.out.println("Enter pet name: ");
            String petName = sc.nextLine();
            // Exception handling for validating pet age as a positive integer
            int petAge = getValidPetAge(sc);
            sc.nextLine(); 
            System.out.println("Enter pet breed: ");
            String petBreed = sc.nextLine();
            
            System.out.println("Enter shelter ID: ");
            int shelterId = sc.nextInt();

            Pet pet = new Pet(petID,petName, petAge, petBreed, shelterId);

            // Insert the pet into the database
            PreparedStatement ps = con.prepareStatement("INSERT INTO Pets(p_id,p_name, p_age, p_breed, s_id) VALUES (?, ?, ?, ?,?)");
            ps.setInt(1, petID);
            ps.setString(2, petName);
            ps.setInt(3, petAge);
            ps.setString(4, pet.getBreed());
            ps.setInt(5, pet.getShelter_id());

            int recordsAffected = ps.executeUpdate();

            if (recordsAffected > 0) {
                System.out.println("Pet recorded successfully.");
            } else {
                System.out.println("Failed to record pet. Please try again.");
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int getValidPetAge(Scanner scanner) throws InvalidInputException {
        try {
            System.out.print("Enter pet age: ");
            int age = scanner.nextInt();
            if (age <= 0) {
                throw new InvalidInputException("Pet age must be a positive integer.");
            }
            return age;
        } catch (java.util.InputMismatchException e) {
            throw new InvalidInputException("Invalid input. Please enter a valid integer for pet age.");
        }
    
	}
}