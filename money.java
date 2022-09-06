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

public class money {

	static double RevenueRemoved; //The amount of money removed
	static TextField AmountR;
	double InMachineRev; // The amount of revenue in the machine



	public static void display() {


		Stage window7 = new Stage();
		window7.setTitle("Report Menu");
		window7.initModality(Modality.APPLICATION_MODAL);


		Label Revenuelbl = new Label(); //Main Label
		Revenuelbl.setText("Revenue Removal");
		Revenuelbl.setFont(new Font("Arial", 19));
		Revenuelbl.setPadding(new Insets(23,13,5,5));
		Revenuelbl.setAlignment(Pos.CENTER);


		Label amountRemove = new Label();
		amountRemove.setText("Enter the Amount you Wish to Remove: ");
		amountRemove.setFont(new Font("Arial", 16));
		AmountR = new TextField();		//TextField to enter the amount desired to be removed
		AmountR.setPromptText("Enter Quantity");
		Button Remove = new Button("Remove");
		Remove.setOnAction(e -> {

			if(isInt(AmountR)) { //If statement to see if an int has been entered
				RevenueRemoved = Double.parseDouble(AmountR.getText());

			}else {
				CreditCard.getErrorMessage(); //Error message if an Int has not been entered
			}

			if( RevenueRemoved<=AccountdrinksMenu.Revenue) { //if statement to see if the amount wanting to be taken out is less than or equal to what's in the machine
				AccountdrinksMenu.Revenue-=RevenueRemoved; //Deducting the revenue removed from the machine Revenue

			}
			else {
				ErrorMessage();
			}
		});
		HBox middle = new HBox();//Creating HBox
		middle.getChildren().addAll(amountRemove,AmountR,Remove);
		middle.setAlignment(Pos.CENTER);
		middle.setSpacing(6);

		Button showBalance = new Button("Show Balance");
		showBalance.setOnAction(e -> {
			RevInMachine(); //Button showing how much money is in the machine

		});

		VBox center = new VBox();
		center.getChildren().addAll(middle,showBalance);
		center.setSpacing(16);
		center.setAlignment(Pos.CENTER);


		Button help = new Button("Help");
		help.setOnAction(e -> {
			getHelp();
		});

		Button back = new Button("Back");
		back.setOnAction(e -> {
			window7.close();
		});

		HBox bottom = new HBox();
		bottom.getChildren().addAll(back,help);
		bottom.setSpacing(6);



		Insets insets = new Insets(10);

		BorderPane borderpane = new BorderPane();
		borderpane.setTop(Revenuelbl);
		BorderPane.setAlignment(Revenuelbl, Pos.CENTER);
		borderpane.setCenter(center);
		BorderPane.setMargin(center, insets);
		borderpane.setBottom(bottom);
		borderpane.setPadding(new Insets(6));



		Scene sceneF = new Scene( borderpane, 640, 400);
		sceneF.getStylesheets().add("style.css");
		window7.setScene(sceneF);
		window7.show();









	}

	public static boolean isInt(TextField text){ //method checking if its an int

		try {
			RevenueRemoved =  Double.parseDouble(text.getText());
			TopUp.getConfirmationBox();
			return true;
		}
		catch(NumberFormatException e) {
			throw new NumberFormatException("Invalid Input!");
		}


	}


	public static void RevInMachine() { //method showing how much money is in the machine
		double InMachineRev = AccountdrinksMenu.Revenue;
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setContentText("The Money in the Machine is : " + InMachineRev);
		alert.show();

	}


	public static void getHelp() { //Help Alert


		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("Enter the amount you wish to retrieve and press the remove button\n"
				+ "1. Make sure you are not taking out more money than is present by pressing the show balance button\n"
				+ "2. To go back press the back Button"
				);	
		alert.showAndWait();


	}




	public static void ErrorMessage() { //error message alert
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Validation Box");
		alert1.setHeaderText("incorrect input!");
		alert1.setContentText("You are trying to remove more money than is in the machine ");

		alert1.showAndWait();

	}


}
