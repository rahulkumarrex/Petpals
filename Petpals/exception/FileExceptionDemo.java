package exception;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileExceptionDemo {
		@SuppressWarnings("resource")
		public void runIndex()throws AdoptionException,InvalidInputException {
	        try {
	        	String content = readFromFile("example.txt");
	            System.out.println("Content read from file: " + content);
	        } 
	        catch (FileNotFoundException e) {
	            // Handle the FileNotFoundException
	            System.out.println("File not found: " + e.getMessage());
	            e.printStackTrace();
	        }
	        catch (Exception e) {
	            System.err.println("An unexpected error occurred: " + e.getMessage());
	        }
	    }
		private static String readFromFile(String fileName) throws IOException {
	        StringBuilder content = new StringBuilder();
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                content.append(line).append("\n");
	            }
	        }
	        return content.toString();
	    }
	}
