import javafx.application.Platform;
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

public class CreditCard {
	
	private static TextField creditEnter;
	private static TextField expiryDateEnter;
	private static TextField securityEnter;


	public static void display() {
		
		Stage window3 = new Stage(); //Creating the Stage
		window3.setTitle("Credit Card Info");
		window3.initModality(Modality.APPLICATION_MODAL);
		
		Label label2  = new Label("Credit Card Details");
		label2.setFont(new Font("Arial", 16));
		
		
		//getting the user to enter their 16 digit card number and validating it
		Label creditNumber = new Label ();
		creditNumber.setText("Enter your 16 digit credit card number:         ");
		creditEnter = new TextField();
		Button validteCardNumber = new Button ();
		validteCardNumber.setText("Validate");
		validteCardNumber.setOnAction(e -> {
			if(isLong(creditEnter)) { 
				getConfirmationBox();
			}else 
				getErrorMessage();
		});
		HBox h1 = new HBox();
		h1.getChildren().addAll(creditNumber,creditEnter, validteCardNumber);
		h1.setSpacing(5);
		
		//getting the user to enter the credit card Expiry date
		Label expiryDate = new Label();
		expiryDate.setText("Enter the Date of Expiry: \t\t\t\t        ");
		expiryDateEnter = new TextField(); 
		Button validateDate = new Button(); 
		validateDate.setText("Validate");
		validateDate.setOnAction(e -> {	
				getConfirmationBox(); //Display Alert Box
		
		});
		
		HBox h2 = new HBox();
		h2.getChildren().addAll(expiryDate,expiryDateEnter, validateDate); 
		h2.setSpacing(5);
		

		//geting the user to enter their 16 digit card number and validating it
		Label securityCode = new Label ();
		securityCode.setText("Enter your 3 digit credit card security code:   ");
		securityEnter = new TextField();
		Button securityCodeNumber = new Button ();
		securityCodeNumber.setText("Validate");
		securityCodeNumber.setOnAction(e -> {
			if(isInt(securityEnter)) { 
				getConfirmationBox();
			}else 
				getErrorMessage();
		});
		HBox h3 = new HBox();
		h3.getChildren().addAll(securityCode,securityEnter, securityCodeNumber); 
		h3.setSpacing(5);
		

		Button topUpbtn = new Button ();
		topUpbtn.setText("Top Up");
		topUpbtn.setOnAction(e -> {
			if(isLong(creditEnter) && isInt(securityEnter)){//if statement making sure everything is entered
				getConfirmationBox();
			TopUp.display();
			window3.close();
			Platform.setImplicitExit(false);
			}else {
				getErrorMessage();
			}
		});
	
	
		Button goBack = new Button("Drinks menu");
		goBack.setOnAction(e -> {
		AccountdrinksMenu.display();
		window3.close();
		//Platform.setImplicitExit(false);
	});
		
		Button help = new Button("Help");
		help.setOnAction(e -> {
			getHelp();
		});
		
		VBox heading = new VBox(); //Creating a VBox
		heading.setAlignment(Pos.TOP_CENTER); //Making it in the middle
		heading.setPadding(new Insets(16,16,16,16));
		heading.getChildren().addAll(label2);
		heading.setAlignment(Pos.CENTER);

		HBox Bottom = new HBox();
		Bottom.getChildren().addAll(goBack,help);
		Bottom.setAlignment(Pos.BOTTOM_LEFT);
		Bottom.setSpacing(5);

		VBox v2 = new VBox(10);
		v2.setAlignment(Pos.BASELINE_LEFT);
		v2.setPadding(new Insets(10,10,10,10));
		v2.getChildren().addAll(h1, h2, h3, topUpbtn);
		v2.setAlignment(Pos.CENTER);
		v2.setSpacing(12);
		
		Insets insets = new Insets(10);
		
		BorderPane borderpane = new BorderPane();
		borderpane.setTop(heading);//Setting the top
		BorderPane.setMargin(heading, insets);
		borderpane.setCenter(v2);//Setting the Center
		BorderPane.setMargin(v2, insets);
		borderpane.setBottom(Bottom);//Setting the Bottom
		BorderPane.setMargin(Bottom, insets);
		
		Scene SceneC = new Scene(borderpane,500, 450);
		SceneC.getStylesheets().add("style.css");
		window3.setTitle("Credit Card Details");
		window3.setScene(SceneC);
		window3.show();
		
		
	}

	
	public static TextField CreditNumberTextField() { //getter for the First Name because it is private, it will be accessible in the other classes
		return creditEnter;
	}
	
	public static TextField expiryDateTextField() { //getter for the First Name because it is private, it will be accessible in the other classes
		return expiryDateEnter;
	}
	
	public static TextField securityCodeTextField() { //getter for the First Name because it is private, it will be accessible in the other classes
		return securityEnter;
	}


	
	public static boolean isLong(TextField text){ //Method to check if a Long has been Entered
	
		try {
			long card =  Long.parseLong(text.getText());
			System.out.println("your pin is:" + card);
			
			return true;
		}
		catch(NumberFormatException e) {
			getErrorMessage();
			throw new NumberFormatException("Invalid Input!");
		}
	}
	 

	
	
	
	
	public static boolean isInt(TextField text){ //Method to check if an Interger was entered into the textfield
		try {
			int code =  Integer.parseInt(text.getText());
			System.out.println("your pin is:" + code);
			getConfirmationBox();
			return true;
		}
		catch(NumberFormatException e) {
			getErrorMessage();
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
	
	
	public static Alert getHelp() { //Alert for the help box 
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("Please Fill all fields to Continue\n"
				+ "1. Enter your 16 digit credit card: numbers only\n"
				+ "2. Enter the expiry date: dd/mm/yyyy\n"
				+ "3. Enter the 3 digit security code found at the back\n"
				+ "4. If you wish to top up your account click Top Up\n"
				+ "5. If you wish to go to the drinks menu click Drink Menu"
				);	
		alert.showAndWait();
		
		return alert;
	}
		


}
