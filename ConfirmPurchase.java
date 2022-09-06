import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class ConfirmPurchase extends AccountdrinksMenu{
	
	static boolean answer;

	
	public static boolean display(Double totalCost) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Payment");
		window.setMinWidth(250);
		
		
		Label Total = new Label(); //Label to display order total
		Total.setText("Your total is: " + totals());
		Total.setAlignment(Pos.CENTER);
		Total.setFont(new Font("Arial", 13));
		Total.setPadding(new Insets(13,10,5,5));
		
		Label doYouWish = new Label(); //Creating Label
		doYouWish.setText("Do you wish to Complete Purchase?");
		doYouWish.setFont(new Font("Arial", 13));
		
		//Making my Yes and No Buttons
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");
		
		yesButton.setOnAction(e -> { //Yes button which will return true if clicked
			answer=true;
			window.close();
		});
		
		noButton.setOnAction(e -> { //No button which will return false is clicked
			answer=false;
			window.close();
		});
		
		
		Button help = new Button("Help");
		help.setOnAction(e -> {
			getHelp();
		});

		
		VBox buttons = new VBox();
		buttons.getChildren().addAll(yesButton, noButton,help);
		buttons.setSpacing(5);
		buttons.setAlignment(Pos.CENTER);
		
		Insets insets = new Insets(10);
		
		BorderPane borderpane = new BorderPane();
		borderpane.setTop(Total);
		BorderPane.setAlignment(Total, Pos.CENTER);
		borderpane.setCenter(doYouWish);
		BorderPane.setMargin(doYouWish, insets);
		BorderPane.setAlignment(doYouWish, Pos.CENTER);
		borderpane.setBottom(buttons);	
		BorderPane.setMargin(buttons, insets);
		
		borderpane.setPadding(new Insets(6));
		
		
		Scene scene = new Scene(borderpane, 300, 250);
		scene.getStylesheets().add("style.css");
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
				
	}
	public static Alert getHelp() { //Get help\s
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("Please click one of the Button to continue\n"
				+ "1. Yes if you want to complete the purhcase\n"
				+ "2. No if you want to cancel and exit the program"
				);	
		alert.showAndWait();
		
		return alert;
	}
		
	
	

}
