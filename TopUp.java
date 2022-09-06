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

public class TopUp {
	
 
    public static double accountBalance;
	private static TextField topUpEnter;
    public static double TopUpEnter;



	public static void display() {
		
		Stage window4 = new Stage();
		window4.setTitle("Credit Card Info");
		window4.initModality(Modality.APPLICATION_MODAL);
		
		Label topUplbl = new Label();//Creating the label at the top of the window
		topUplbl.setText("Top Up Menu");
		topUplbl.setFont(new Font("Arial", 17));
		topUplbl.setPadding(new Insets(15,10,5,5));
	
		
	
		Label amountlbl = new Label();
		amountlbl.setText("Enter the Amount: ");
		amountlbl.setFont(new Font("Arial", 13));
		topUpEnter = new TextField();   //Textfield to enter the amount to top up by
		Button Validatebtn = new Button ();
		Validatebtn.setText("Validate");
		Validatebtn.setOnAction(e -> {
			if(isDouble(topUpEnter)) {  //Valdating that a 
				addToBalance();
		
			}else 
				getErrorMessage();
		});
		HBox h1 = new HBox();
		h1.getChildren().addAll(amountlbl,topUpEnter, Validatebtn);
		h1.setAlignment(Pos.CENTER);
		h1.setSpacing(5);
		
		
		
		Button goToMenu = new Button("Drinks menu");//button to go back to the drinks menu
		goToMenu.setOnAction(e -> {
		window4.close();
		Platform.setImplicitExit(false);
	});
		
		Button showBalance = new Button("Show Balance");
		showBalance.setOnAction(e -> {
		ShowBalance();
		});

		Button help2 = new Button("Help");//Help Button
		help2.setOnAction(e -> {
			getHelp();
		});
		
		
	

		
		VBox v2 = new VBox(10);//Creating VBox
		v2.setPadding(new Insets(10,10,10,10));
		v2.getChildren().addAll( h1,showBalance,goToMenu);
		v2.setSpacing(18);
		v2.setAlignment(Pos.CENTER);
		
		
		Insets insets = new Insets(10);
		
		BorderPane borderpane = new BorderPane();//Creating borderpane for the Stage
		borderpane.setTop(topUplbl);
		BorderPane.setAlignment(topUplbl, Pos.CENTER);
		BorderPane.setMargin(topUplbl, insets);
		borderpane.setCenter(v2);
		BorderPane.setMargin(v2, insets);
		borderpane.setBottom(help2);
		BorderPane.setMargin(help2, insets);
		borderpane.setPadding(new Insets(6));
		
		
		
		Scene SceneC = new Scene(borderpane,470, 350);
		SceneC.getStylesheets().add("style.css");//link to my external css
		window4.setTitle("Top Up");
		window4.setScene(SceneC);
		window4.show();
		

	}


	public static void ShowBalance() { //Button to show how much is in the Account Balance
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setContentText("your balance is: " + accountBalance);
		alert.show();
		
	}



	public static double addToBalance() { //Method to add the Top Up Entered to the account Balance
		double TopUpEnter;
		
	//	String text1 = topUpEnter.getText();
		TopUpEnter = Double.parseDouble(topUpEnter.getText());
		accountBalance += TopUpEnter;
		System.out.println("Your new Balance is: €" + accountBalance);
		return accountBalance;
	}



	public static boolean isDouble(TextField text){//Method to verify if its a double 
			try {
				TopUpEnter =  Double.parseDouble(text.getText());
				getConfirmationBox();
				return true;
			}
			catch(NumberFormatException e) {
				getErrorMessage();
				throw new NumberFormatException("Invalid Input!");
			}
		
			
	}
	


	
	public static TextField getTopUpEnter() { //Getter for topUPEnter
		return topUpEnter;
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

	
	public static Alert getHelp() { //Alert for the help
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("Enter an amount in numbers and press validate to add\n"
				+ "1. If you wish to go to the menu for drinks press Drink Menu\n"
				+ "2. If you wish to see the amount of money in your account press Show Balance\n"
				);	
		alert.showAndWait();
		
		return alert;
	}
		






   

}
