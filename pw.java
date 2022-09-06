


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class pw {

	public static void write() { //Method which will write the user input to the file
		File file = new File("C:\\Users\\milan\\OneDrive - Cork College of Commerce\\Fx\\VendingMachineAssignement\\src\\Registration.txt"); //Creating the new file
		System.out.println("File path is: " + new File("C:\\Users\\milan\\OneDrive - Cork College of Commerce\\Fx\\VendingMachineAssignement\\src\\Registration.txt").getAbsolutePath());


		if (file.exists()) {  //if the file exist, write the message
			System.out.println("Found the file");

			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}


			PrintWriter pw = null; //Setting PrintWritter to null
			try {
				pw = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			//Display all information in the file
			pw.print("\nUser name: ");
			pw.println(CreateAccount.FirstNameTextField().getText());

			pw.print("\nSurname: ");
			pw.println(CreateAccount.getLastName().getText());

			pw.print("Date of Birth: ");
			pw.println(CreateAccount.getDob().getText());

			pw.print("Gender: ");
			pw.println(CreateAccount.getGender().getValue());

			pw.print("Pin: ");
			pw.println(CreateAccount.getPin().getText());

			pw.print("Mobile Number: ");
			pw.println(CreateAccount.getMobile().getText());

			pw.print("Email Address Line1: ");
			pw.println(CreateAccount.getAddress().getText());
			pw.print("Email Address Line2: ");
			pw.println(CreateAccount.getAddressLine2().getText());
			pw.print("Email Address Line3: ");
			pw.println(CreateAccount.getAddressLine3().getText());

			pw.print("Country: ");
			pw.println(CreateAccount.getCountry().getValue());

			pw.print("County: ");
			pw.println(CreateAccount.getCounty().getValue());
		
			
			



			pw.close();
		}
	}
	


	public static void getFile() { //Check if the file exists

		File file = new File("C:\\Users\\milan\\OneDrive - Cork College of Commerce\\Fx\\VendingMachineAssignement\\src\\Registration.txt");
		System.out.println("File path is: " + new File("C:\\Users\\milan\\OneDrive - Cork College of Commerce\\Fx\\VendingMachineAssignement\\src\\Registration.txt").getAbsolutePath());


		if (file.exists())
			System.out.println("Found the file");
		else
			System.out.println("Did not find the file.");


	}




}
