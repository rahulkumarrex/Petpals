package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import util.*;
import entity.AdoptionEventManagement;
import entity.PetAge;
import exception.*;
import petpalsjdbc.DonationRecordingApp;

public class MainModule {
	public static void main(String args[])throws InvalidInputException {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    System.out.println("Choose From Below Options ");
		    System.out.println("=========================== ");
		    System.out.println("1 : To get Pet List");
		    System.out.println("2 : To get Donation ");
		    System.out.println("3 : To get Adoption Event Management");
		    System.out.println("4 : Enter Pet Record");
		    System.out.println("5 : To ReadFile ");
		    System.out.println("6 : To Exit : ");
		    Scanner sc = new Scanner(System.in); 
		    int task = sc.nextInt();
				if(task==1) {
					Connection con= DBConnUtil.getConnection();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("SELECT Pets.p_id,Pets.p_name,Pets.p_age,"
							+ "Pets.p_breed,Shelters.s_name,Pet_Dog.dog_breed,Pet_Cat.cat_color "
							+ "FROM Pets "
							+ "JOIN Shelters ON Pets.s_id = Shelters.s_id "
							+ "LEFT JOIN Pet_Dog ON Pets.p_id = Pet_Dog.p_id "
							+ "LEFT JOIN Pet_Cat ON Pets.p_id = Pet_Cat.p_id;");
					while (rs.next()) {
					    int petId = rs.getInt(1);
					    String petName = rs.getString(2);
					    int petAge = rs.getInt(3);
					    String petBreed = rs.getString(4);
					    String shelterName = rs.getString(5);
					    String dogBreed = rs.getString(6);
					    String catColor = rs.getString(7);

					    if (petName == null) {
					        petName = "Name not available";
					    }

					    if (petAge == 0) {
					        petAge = -1; 
					    }

					    if (petBreed == null) {
					        petBreed = "Breed not available";
					    }

					    if (shelterName == null) {
					        shelterName = "Shelter name not available";
					    }

					    if (dogBreed == null) {
					        dogBreed = "Dog breed not available";
					    }

					    if (catColor == null) {
					        catColor = "Cat color not available";
					    }

					    System.out.println("Pet ID: " + petId +
					                       "\nPet Name: " + petName +
					                       "\nPet Age: " + petAge +
					                       "\nPet Breed: " + petBreed +
					                       "\nShelter Name: " + shelterName +
					                       "\nDog Breed: " + dogBreed +
					                       "\nCat Color: " + catColor +
					                       "\n------------------------");
					}
				}
				else if(task==2) {
					DonationRecordingApp run=new DonationRecordingApp();
					run.runIndex();
				}
				else if(task == 3) {
					AdoptionEventManagement run=new AdoptionEventManagement();
					run.runIndex();
				}
				else if(task ==4) {
					PetAge.CheckPetAge();
				}
				else if(task==5) {
					FileExceptionDemo fed=new FileExceptionDemo();
					fed.runIndex();
				}
				else if(task == 6) {
					System.out.println("Thanks you for visiting ");
				}
				else {
					throw new InvalidInputException("You have entered invalid input ");
				}
		}
			catch(Exception e) {
				System.out.println("Error ");
				e.printStackTrace();
		}
		
	}
}
