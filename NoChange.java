import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NoChange {
	
	static boolean answer;

	

	public static boolean display (){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Payment");
		window.setMinWidth(250);
		
	 	Label warning = new Label(); //Creating Label
	 	warning.setText("This Machine does NOT dispense Change");
	 	warning.setFont(new Font("Arial", 15));
	 	HBox h = new HBox();
	 	h.getChildren().add(warning);
	 	h.setAlignment(Pos.CENTER);	
		h.setPadding(new Insets(13,18,10,10));
		

		
	 	
	 	
		Label doYouWish = new Label();
		doYouWish.setText("Do you Wish to complete the Purchase");
		
		//Making my Yes and No Buttons
		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");
		
		yesButton.setOnAction(e -> { //yes button that will return true when clicked
			answer=true;
			window.close();
		});
		
		noButton.setOnAction(e -> { //no button that will return false when clicked
			answer=false;
			getHelp();
			window.close();
		});
		
	
		
		VBox middle = new VBox(); //Creating vbox
		middle.getChildren().addAll(doYouWish,yesButton,noButton);
		middle.setSpacing(12);
		middle.setAlignment(Pos.CENTER);
		
		Button help = new Button("Help"); //Creating help Button
		help.setOnAction(e -> {
			getHelp();
		});
		
		
		Insets insets = new Insets(10);
		
		BorderPane borderpane = new BorderPane();//Creating BorderPane
		borderpane.setTop(warning);
		BorderPane.setAlignment(warning, Pos.CENTER);
		borderpane.setCenter(middle);
		BorderPane.setMargin(middle, insets);
		borderpane.setBottom(help);	
		BorderPane.setMargin(help, insets);
		
		borderpane.setPadding(new Insets(6));
		

		
		Scene scene = new Scene(borderpane , 400, 250);
		window.setScene(scene);
		scene.getStylesheets().add("style.css");
		window.showAndWait();
		
		return answer;
				
	}
	public static Alert getHelp() { //Get help alert
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("If you have entered money it cannot be return you can now either\n"
				+ "1. Press No close the program and forfeit your money\n"
				+ "2.Press Yes to complete the order and get your drinks"
				+ "Thank you for Shopping with us"
				
				);	
		alert.showAndWait();
		
		return alert;
	}
		
	
	

}
