
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateAccount {

	//Making all of the personal details Private
	private static TextField firstNameEnter;
	private static TextField surnameText;
	private static TextField DOBText;
	private static ComboBox<String> genderCombo;
	private static TextField PinText;
	private static TextField emailText;
	private static TextField mobileText;
	private static TextField addressText;
	private static TextField addressText2;
	private static TextField addressText3;
	private static ComboBox<String> countryCombo;
	private static ComboBox<String>countyCombo;
	static ComboBox<String> getEmpty;
	static Scene SceneB;
	static Scene SceneC;





	public static void display() {

		Stage window2 = new Stage();
		window2.setTitle("Create Account");
		window2.initModality(Modality.APPLICATION_MODAL);
		//Stage details
		Label l = new Label();
		l.setText("Enter your Details and press Validate"); 
		l.setFont(new Font("Arial", 16));
		
		
		
		//The First Name
		Label firstName = new Label();
		firstName.setText("First Name:       ");
		firstNameEnter = new TextField(); 
		firstNameEnter.setMaxHeight(170);
		Button validateFirstName = new Button();
		validateFirstName.setText("Validate");
		validateFirstName.setOnAction(e -> {

			//creating an if statement to make sure first name a string
			if(isAlphabetic(firstNameEnter)) {
				getConfirmationBox(); //Display Alert Box if the if statement is met
			}else 
				getErrorMessage(); //If not Displaying an Error Box via an alert in a Method
		}); 
		HBox h = new HBox();
		h.getChildren().addAll(firstName, firstNameEnter, validateFirstName); 
		h.setSpacing(8);



		//Create new label for the user's last name
		Label surname = new Label(); 
		surname.setText("Last Name:       ");
		surnameText = new TextField();
		surnameText.setMaxHeight(170);
		//Creating validate button for the second name
		Button validateSecondName = new Button(); //Creating new Button
		validateSecondName.setText("Validate");
		validateSecondName.setOnAction(e -> {
			//again an if statement to make sure surname is a string
			if(isAlphabetic(surnameText)) { 
				getConfirmationBox();
			}else 
				getErrorMessage();
		});
		HBox h1 = new HBox();
		h1.getChildren().addAll(surname,surnameText, validateSecondName);
		h1.setSpacing(8);


		//The Date of Birth
		Label DOB = new Label();
		DOB.setText("Date of Birth:    ");
		DOBText = new TextField(); 
		DOBText.setMaxHeight(170);
		Button validateDOB = new Button(); 
		validateDOB.setText("Validate");
		validateDOB.setOnAction(e -> {
			 overEighteens();
		
		});
		HBox h2 = new HBox();
		h2.getChildren().addAll(DOB,DOBText, validateDOB); 
		h2.setSpacing(8);




		//Creating Section for the Gender
		Label gender = new Label();
		gender.setText("Gender:\t\t  ");
		//Creating new ComboBox for the gender
		genderCombo = new ComboBox<>();
		genderCombo.setPrefWidth(149);
		genderCombo.setMaxHeight(170);
		genderCombo.getItems().addAll( //populating the drop down combo
				"Male", "Female"
				);
		Button submitG = new Button();
		submitG.setText("Validate");
		submitG.setOnAction(e->{	
			genderCombo.getValue();
		});
		HBox h3 = new HBox(); 
		h3.getChildren().addAll(gender,genderCombo,submitG);
		h3.setSpacing(8);


		//Creating Email Label
		Label email = new Label(); 
		email.setText("Email:\t\t  ");
		//Creating new TextFiel to enter email
		emailText = new TextField();
		emailText.setMaxHeight(170);
		Button emailValidation = new Button();
		emailValidation.setText("Validate");
		emailValidation.setOnAction(e -> {
			//again an if statement to make sure surname is a string
			if(isAlphabetic(emailText)) { 
				getConfirmationBox();
			}else 
				getErrorMessage();
		});
		HBox h4 = new HBox();
		h4.getChildren().addAll(email,emailText, emailValidation);
		h4.setSpacing(8);



		//Creating new Label for the Pin
		Label Pin = new Label();
		Pin.setText("Pin number:       ");
		PinText = new TextField(); 
		PinText.setMaxHeight(170);
		Button PinValidation = new Button();
		PinValidation.setText("Validate");
		PinValidation.setOnAction( e -> {
			//creating an if statement to make sure its a Number
			if(isInt(PinText)) {

				getConfirmationBox(); //Display Alert Box
			}else 
				getErrorMessage(); //Display Error Box

		});

		HBox h5 = new HBox();
		h5.getChildren().addAll(Pin,PinText, PinValidation); 
		h5.setSpacing(8);




		//Creating new Label for phone number
		Label mobile = new Label();
		mobile.setText("Mobile number: ");
		//Textfield for the user to input his phone number
		mobileText = new TextField(); 
		mobileText.setMaxHeight(170);
		Button mobileValidation = new Button();
		mobileValidation.setText("Validate");
		mobileValidation.setOnAction( e -> {
			//creating an if statement to make sure its a Date
			if(isDigitOnly(mobileText)) {

				getConfirmationBox(); //Display Alert Box
			}else 
				getErrorMessage(); //Display Error Box

		});
		HBox h6 = new HBox();
		h6.getChildren().addAll(mobile,mobileText, mobileValidation); 
		h6.setSpacing(8);



		//Creating address Label
		Label address1 = new Label(); 
		address1.setText("Address Line 1:  ");
		addressText = new TextField();
		addressText.setMaxHeight(170);
		Button address1Validation = new Button();
		address1Validation.setText("Validate");
		address1Validation.setOnAction(e -> {
			//again an if statement to make sure address is a string
			if(isAlphabetic(addressText)) { 
				getConfirmationBox();
			}else 
				getErrorMessage();
		});
		HBox h7 = new HBox();
		h7.getChildren().addAll(address1,addressText,address1Validation); 
		h7.setSpacing(8);



		//Creating new Label for the second line of the address
		Label address2 = new Label();
		address2.setText("Address Line 2 : ");
		//Creating new TextField for the addresLine
		addressText2 = new TextField();
		addressText2.setPromptText("Optional");
		addressText2.setMaxHeight(170);
		Button address2Validation = new Button();
		address2Validation.setText("Validate");
		address2Validation.setOnAction(e -> {
			//again an if statement to make sure address is a string
			if(isAlphabetic(addressText2)) { 
				getConfirmationBox();
			}else 
				getErrorMessage();
		});
		HBox h8 = new HBox();
		h8.getChildren().addAll(address2,addressText2,address2Validation); 
		h8.setSpacing(8);

		//Creating new Label for the third line of the address
		Label address3 = new Label();
		address3.setText("Address Line 3:  ");
		//Creating new TextField for the addresLine
		addressText3 = new TextField();
		addressText3.setPromptText("Optional");
		addressText3.setMaxHeight(170);
		Button address3Validation = new Button();
		address3Validation.setText("Validate");
		address3Validation.setOnAction(e -> {
			//again an if statement to make sure address is a string
			if(isAlphabetic(addressText3)) { 
				getConfirmationBox();
			}else 
				getErrorMessage();
		});
		HBox h9 = new HBox();
		h9.getChildren().addAll(address3,addressText3, address3Validation); 
		h9.setSpacing(8);

		//Label for Country Drop down Box
		Label country = new Label(); 
		country.setText("Country:\t\t  ");
		countryCombo = new ComboBox<>();
		countryCombo.getItems().addAll(
				"Ireland", "Uk", "France" , "Germany", "Italy", "Spain"
				);
		countryCombo.setPrefWidth(149);
		countryCombo.setMaxHeight(170);
		Button submitC = new Button();
		submitC.setText("Validate");
		submitC.setOnAction(e-> countryCombo.getValue());
		HBox h10 = new HBox();
		h10.getChildren().addAll(country, countryCombo,submitC);
		h10.setSpacing(8);

		//Label for County Drop down Box
		Label county = new Label(); 
		county.setText("County:\t\t  ");
		countyCombo = new ComboBox<>();
		countyCombo.setPrefWidth(149);
		countyCombo.getItems().addAll(
				"Cork", "Limerick", "Clare" , "Dublin", "Kerry", "Other"
				);
		countyCombo.setMaxHeight(170);
		Button submitCounty = new Button();
		submitCounty.setText("Validate");
		submitCounty.setOnAction(e-> countryCombo.getValue());
		country.setText("County:\t\t  ");
		HBox h11 = new HBox();
		h11.getChildren().addAll(county, countyCombo,submitCounty);
		h11.setSpacing(8);



		//back button
		Button cancel = new Button("Cancel");
		cancel.setOnAction(e -> {
			window2.close();
		});

		
		Button help = new Button("Help");
		help.setOnAction(e -> { //If the button is clicked, you will get help window with small description
			getHelp(); 
		});
		//Create new HBox for the help button
		HBox bottom = new HBox();
		bottom.setAlignment(Pos.BOTTOM_RIGHT); //Positioning of the button
		bottom.getChildren().addAll(cancel,help);
		bottom.setPadding(new Insets(10,10,10,10));
		bottom.setSpacing(5);

		

		
		
	

		//button to submit all of the details you have entered
		Button finalSubmit = new Button("Submit");
		finalSubmit.setAlignment(Pos.BOTTOM_CENTER);

		finalSubmit.setOnAction(e -> {

			//An IF statement to make sure all of the Info was entered correctly
			if(isAlphabetic(firstNameEnter) && isAlphabetic(surnameText) && isAlphabetic(emailText) && isInt(PinText) && isDigitOnly(mobileText)
					&& isAlphabetic(addressText) ) { //If validation of first name and PPSN is correct, then create new account
				getConfirmationBox();
				CreditCard.display(); //Opening the Credit Card Menu
				pw.write(); //Writting the information in writer class
				window2.close();    //Close the current window

			}else if(!isAlphabetic(firstNameEnter) || ! isAlphabetic(surnameText) && !isAlphabetic(emailText) && !isInt(PinText) && !isDigitOnly(mobileText)
					&& !isAlphabetic(addressText)) { //If Validaton is not correct, get Error message and try again
				Alert confirm = new Alert(AlertType.ERROR);
				confirm.setTitle("ERROR");
				confirm.setHeaderText("Validation result!");
				confirm.setContentText("Validation is not correct! Please check if your first name or pps number is correct! Validate everything before you click submit!");
				confirm.showAndWait(); 
				System.out.println("Wrong input");	 	 		
			} 
		});  
		
		VBox heading = new VBox(); //Creating a VBox
		heading.setAlignment(Pos.TOP_CENTER); //Making it in the middle
		heading.setPadding(new Insets(16,16,16,16));
		heading.getChildren().addAll(l);
	



		VBox v = new VBox(); //Creating a Vbox
		v.setAlignment(Pos.BASELINE_LEFT); //Making it Left
		v.setPadding(new Insets(10,10,10,10));
		v.getChildren().addAll(h, h1, h2, h3, h4, h5, h6, h7, h8, h9,  h10,h11,finalSubmit);  //Adding all elements to the VBox
		v.setSpacing(11);
		
		BorderPane borderpane = new BorderPane();
		borderpane.setTop(heading);//Setting the top
		borderpane.setCenter(v);//Setting the Center
		borderpane.setBottom(bottom);//Setting the Bottom
		
		//Scene sceneB = new Scene(v,900,800); //Set scene
		Scene sceneB = new Scene(borderpane, 600 , 700);
		sceneB.getStylesheets().add("style.css");
		window2.setScene(sceneB);
		window2.showAndWait();






	}









	public static void getWidth(TextField text) { //Method what will set width
		text.setPrefWidth(200);
		text.setMaxWidth(200);
	}

	public static TextField FirstNameTextField() { //getter for the First Name because it is private, it will be accessible in the other classes
		return firstNameEnter;
	}


	public static TextField getLastName() { //getter for the last name because it is private, it will be accessible in the other classes
		return surnameText;
	}


	public static TextField getDob() { //getter for the DOB because it is private, it will be accessible in the other classes
		return DOBText;
	}


	public static ComboBox<String> getGender(){ //getter for the gender because it is private, it will be accessible in the other classes
		return genderCombo;
	}

	public static TextField getEmail() { //getter for the email because it is private, it will be accessible in the other classes
		return emailText;
	}


	public static TextField getAddress() { //getter for the address because it is private, it will be accessible in the other classes
		return addressText;
	}


	public static TextField getAddressLine2() { //getter for the address because it is private, it will be accessible in the other classes
		return addressText2;
	}



	public static TextField getAddressLine3() { //getter for the address because it is private, it will be accessible in the other classes
		return addressText3;
	}


	public static ComboBox<String> getCountry(){ //getter for the country because it is private, it will be accessible in the other classes
		return countryCombo;
	}

	public static ComboBox<String> getCounty(){ //getter for the county because it is private, it will be accessible in the other classes
		return countyCombo;
	}

	public static TextField getMobile() { //getter for the mobile number because it is private, it will be accessible in the other classes
		return mobileText;
	}
	public static TextField getPin() { //getter for the mobile number because it is private, it will be accessible in the other classes
		return PinText;
	}








	public static boolean isDigitOnly(TextField text) { //Method what will set input to be only digits
		String phone = text.getText(); 

		if(!phone.matches("[0-9]+")) {
			throw new NumberFormatException("Invalid Input!");
		}else
		System.out.println("Correct Input!");
		return true;

	} 


	public static boolean isAlphabetic(TextField text) { //Method for validation, settin regex to accept only alphabetic and single apostrophe
		String field = text.getText();

		if(!field.matches("[a-zA-Z\\s']+")) { 
			return false; 

		}else 
			System.out.println("Correct Input"); 
		return true;
	}


	public static boolean isInt(TextField text){
		try {
			int Pin =  Integer.parseInt(text.getText());
			System.out.println("your pin is:" + Pin);
			return true;
		}
		catch(NumberFormatException e) {
			throw new NumberFormatException("Invalid Input!");
		}


	}
	
	public static void getErrorMessage() { //Method what will give you alert box(confirmation)

		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Validation Box");
		alert1.setHeaderText("Validation result!");
		alert1.setContentText("Validation is not correct! ");

		alert1.showAndWait();
	}

	public static void getConfirmationBox() { //Method what will give you alert box(error)

		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setTitle("Validation Box");
		alert1.setHeaderText("Validation result!");
		alert1.setContentText("Validation is correct!");
		alert1.showAndWait();

	}

	public static Alert getHelp() {//Method what will give you alert box with explanation what the user needs to do in the window

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");	
		alert.setContentText("All Fields are mandatory to fill before you proceed:\n"
				+ "1. Enter your first name: Letters Only\n"
				+ "2. Enter your second name: Letters Only\n"
				+ "3. Date of Birth: dd/mm/yy\n"
				+ "4. Mobile Number: Digits Only\n"
				+ "5. Pin: Digits Only\n"
				+ "6. Address at least one line needed\n"
				+ "7. Please Select one of the countries and click validate"
				);
		alert.showAndWait();

		return alert;

	}

	public static void getLoginError() {  //Login failed alart
		System.out.println("Login Error");
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Validation Box");
		alert1.setHeaderText("Login result!");
		alert1.setContentText("Login Failed! ");
		alert1.showAndWait();
	}
	
	
	public static void getLoginConfirmation() { //Login successful alert
		System.out.println("Login Successful");
		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setTitle("Validation Box");
		alert1.setHeaderText("Validation Login!");
		alert1.setContentText("Login was successful");
		alert1.showAndWait();

	}
	

	public static void overEighteens() { //An alert reminding a user that they have to be Over 18 to Register
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert");
		alert.setHeaderText("You must be over 18 to Register");	
		alert.setContentText("You must be over 18 because you will need a Credit card to complete Registration\n"
				+ "If you are Over 18 press OK if you are under 18 press cancel and login as guest"
				
				);
		alert.showAndWait();

	

	}
	








}
