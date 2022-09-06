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

public class Complaints {
	
	//This is the String where the report will be stored
	private static String Complaint;

	public static void display() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Report");
		
		
		Label reportlbl = new Label();//Creating Label
		reportlbl.setText("Report Menu");
		reportlbl.setFont(new Font("Arial", 18));
		reportlbl.setPadding(new Insets(16,10,5,5));
		
		
		Label enterlbl = new Label(); //Creating label
		enterlbl.setText("Type your Complaint Here: ");
		enterlbl.setFont(new Font("Arial", 13));
		TextField complaint = new TextField(); //Creating textfield to enter complaint
		complaint.setPromptText("Type here");
		
		Button submit = new Button("Submit");
		submit.setOnAction(e -> {
			if(CreateAccount.isAlphabetic(complaint)) {// if statement checking if a string was entered
				Complaint = complaint.getText(); //Making whats entered in the textbox a string				
				CreateAccount.getConfirmationBox();
				
			}
			else {
				CreateAccount.getErrorMessage();
			}
		});
		
		HBox h = new HBox();
		h.getChildren().addAll(enterlbl,complaint);
		h.setSpacing(5);
		

		Button help = new Button("Help"); //help button
		help.setOnAction(e -> {
			getHelp();
		});
		
		Button exit = new Button("Exit");//button to exit back
		exit.setOnAction( e -> {
			window.close();
		});		
		exit.setPrefWidth(70);
		
		HBox bottom = new HBox();
		bottom.getChildren().addAll(exit,help);
		bottom.setAlignment(Pos.BOTTOM_LEFT);
		bottom.setSpacing(6);
		
		
		
		VBox textfields = new VBox(10);
		textfields.setAlignment(Pos.BASELINE_CENTER);
		textfields.setPadding(new Insets(10,10,10,10));
		textfields.getChildren().addAll(h,submit);
		textfields.setSpacing(18);
		
		
		
		
		Insets insets = new Insets(10);
		
		BorderPane borderpane = new BorderPane();
		borderpane.setTop(reportlbl);
		BorderPane.setAlignment(reportlbl, Pos.CENTER);
		borderpane.setCenter(textfields);
		BorderPane.setMargin(textfields, insets);
		borderpane.setBottom(bottom);
		borderpane.setPadding(new Insets(6));
		
		
		
		
		
		Scene scene = new Scene(borderpane ,400 , 300);
		scene.getStylesheets().add("style.css");
		window.setScene(scene);
		window.showAndWait();
		
		
		
	
		
	}

	public static void getHelp() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("Please Enter the compaint in the box and press Submit");	
		alert.showAndWait();

	
		
	}

	//getter for the string report
	public static String getComplaint() {
		return Complaint;
	}

	//setter for the string report
	public static void setComplaint(String report) {
		Complaint = getComplaint();
	}

}
