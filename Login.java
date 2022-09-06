import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Login extends Application {



	public static void main(String[] args) {
		launch(args);

	}
	@Override
	public void start(Stage primaryStage) {


		Stage window1 = new Stage();//Creating the Stage
		window1.setTitle("Login");
		window1.initModality(Modality.APPLICATION_MODAL);


		window1 = primaryStage;
		window1.setTitle("Login Menu");//Creating the Title

		//Creating the Label for the Username and pin Textfields
		Label login = new Label();
		login.setText("Enter your Username and Pin");
		login.setFont(new Font("Arial", 16));
		Label username = new Label();
		username.setText("Username: "); 
		Label pin = new Label();
		pin.setText("Pin: ");


		//username Textfield
		TextField userNameText = new TextField();
		userNameText.setPromptText("Username");
		userNameText.setMaxWidth(250);


		// creating Pin Textfield
		TextField enterPin = new TextField();
		enterPin.setPromptText("Pin");
		enterPin.setMaxWidth(250);

		//Login Details Confirm Button when the Textfields have been filled
		Button confirm = new Button();
		confirm.setText("Confirm");
		confirm.setMaxWidth(150);
		confirm.setOnAction(e -> {

			ReaderFile.readTheFile("C:\\Users\\milan\\OneDrive - Cork College of Commerce\\Fx\\VendingMachineAssignement\\src\\Registration.txt"); // Reading from my file

			String checkUsername = ReaderFile.username; // Finding username what was created
			String checkPin = ReaderFile.pin; // Finding password what was created

			if (userNameText.getText().equals(checkUsername) && enterPin.getText().equals(checkPin)) { //If the username and pin match it takes you to the drinks menu
				CreateAccount.getLoginConfirmation(); // get Alert Box if login is correct
				System.out.println("You logged in with username: " + checkUsername + "\n" + "And with password: " + checkPin); 		
				belowTwoWarning();	
				AccountdrinksMenu.display();
			}
			else
				CreateAccount.getLoginError(); // Get Error Alert Box if information are incorrect
		});

		//Login Details Confirm Button for the Manager Login
		Button manager = new Button();
		manager.setText("Manager Login");
		manager.setMaxWidth(150);
		manager.setOnAction(e -> {

			ReaderFile.readTheFile("C:\\Users\\milan\\OneDrive - Cork College of Commerce\\Fx\\VendingMachineAssignement\\src\\Registration.txt"); // Reading from the file

			String checkUsername = ReaderFile.username; // Finding Username what was created
			String checkPin = ReaderFile.pin; // Finding password what was created

			if (userNameText.getText().equals(checkUsername) && enterPin.getText().equals(checkPin)) {
				CreateAccount.getLoginConfirmation(); // get Alert Box if login is correct method from CreateAccount class
				System.out.println(
						"You logged in with username: " + checkUsername + "\n" + "And with password: " + checkPin); 
				Manager.display(); //Displaying the Managers Menu
			}
			else
				CreateAccount.getLoginError(); // Get Error Alert Box if information are incorrect
		});




		//The Create Account button
		Button createAccount = new Button(); 
		createAccount.setText("Create an Account");
		createAccount.setMaxWidth(150);
		createAccount.setOnAction(e ->{
			CreateAccount.display();
		});

		//Creating a Guest Login Button that will take the user to the drinks menu
		Button guestLogin = new Button(); 
		guestLogin.setText("Continue as a Guest");
		guestLogin.setMaxWidth(150);
		guestLogin.setOnAction(e -> {
			GuestDrinksMenu.display();
		});

		Button help = new Button("Help");
		help.setOnAction(e -> {
			getHelp();     //The help button calling my getHelp method which will show an alert
		});
		//Making a 	HBox for the help button
		HBox h = new HBox();
		h.setAlignment(Pos.BOTTOM_RIGHT); //Alligning my Hbox to the bottom right
		h.getChildren().addAll(help); 

		//Creating a VBox for all of the textfields and Labels
		VBox v = new VBox();
		v.setSpacing(19);
		v.setPadding(new Insets(50, 14, 14, 14));
		v.setAlignment(Pos.CENTER); 
		v.getChildren().addAll(login, username, userNameText, pin, enterPin); 

		//Making a Vbox that will contain all of the buttons
		VBox menuButtons = new VBox();
		menuButtons.setSpacing(18);
		menuButtons.setPadding(new Insets(1,10, 10,10));
		menuButtons.setAlignment(Pos.CENTER); 
		menuButtons.getChildren().addAll( confirm,manager,guestLogin, createAccount, h); 


		//Creating a BorderpPane for this menu
		BorderPane borderpane = new BorderPane();
		borderpane.setTop(v);
		borderpane.setBottom(menuButtons);

		//Making my scene and setting the size of it
		Scene sceneA = new Scene(borderpane, 600, 520); 
		sceneA.getStylesheets().add("style.css");
		window1.setScene(sceneA);
		window1.show();

	}


	public static Alert belowTwoWarning() {
		//Alert displaying that your account Balance is under 2 Euro
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert Box");
		alert.setHeaderText("Reminder");
		alert.setContentText("Your Account Balance stands at under 2 euro please Top Up");	
		alert.showAndWait();
		return alert;
	}

	public static Alert getHelp() {
		//An alert that will Display when the help button is Pressed
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("Please input name and password if you have an account and click Confirm\n"
				+ "1. If you don't have a account click Create Account\n"
				+ "2. If you don't wish to create an account click Guest"
				);	
		alert.showAndWait();

		return alert;
	}





}




