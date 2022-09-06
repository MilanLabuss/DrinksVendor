
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReaderFile {

	//creating username and password instances
	public static String username;
	public static String pin;

	public static void readTheFile(String title) { //Method to read from the file
		BufferedReader br = null; 
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\milan\\OneDrive - Cork College of Commerce\\Fx\\VendingMachineAssignement\\src\\Registration.txt")); //Create BufferedReader in order to read the file

			String line;

			//Read through the file
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if(line.contains("User name")) username = line.split(":")[1].trim() ; 
				if(line.contains("Pin")) pin = line.split(":")[1].trim() ;
			}

		} catch (IOException e) { //Throw exception if the username and password is not found
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}