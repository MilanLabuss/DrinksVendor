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


public class RepairLog {

	public static void display() {
		Stage window8 = new Stage();
		window8.setTitle("Report Menu");
		window8.initModality(Modality.APPLICATION_MODAL);
		
		Label drinksAdded = new Label();
		drinksAdded.setText("Repair Log");
		drinksAdded.setFont(new Font("Arial", 19));
		
		
		HBox top = new HBox();
		top.getChildren().addAll(drinksAdded);
		top.setAlignment(Pos.CENTER);
		
				
		
		Label cokeAdd = new Label(); 
		
		cokeAdd.setText("Coke Added to the Machine: " + Maintenance.CokeAdded); //How many Coke the Manager Added
		cokeAdd.setFont(new Font("Arial", 16));
		HBox h1 =new HBox();
		h1.getChildren().add(cokeAdd);
		h1.setSpacing(6);
		h1.setAlignment(Pos.CENTER);
		
		Label fantaAdd = new Label();
		fantaAdd.setText("Fanta Added to the Machine: " + Maintenance.FantaAdded); //How many Fanta the Manager Added
		fantaAdd.setFont(new Font("Arial", 16));
		HBox h2 =new HBox();
		h2.getChildren().add(fantaAdd);
		h2.setSpacing(6);
		h2.setAlignment(Pos.CENTER);
		
		Label spriteAdd = new Label();
		spriteAdd.setText("Sprite Added to the Machine: " + Maintenance.SpriteAdded); //How many Sprite the Manager Added
		spriteAdd.setFont(new Font("Arial", 16));
		HBox h3 =new HBox();
		h3.getChildren().add(spriteAdd);
		h3.setSpacing(6);
		h3.setAlignment(Pos.CENTER);
		
		Label pepsiAdd = new Label();
		pepsiAdd.setText("Pepsi Added to the Machine: " + Maintenance.PepsiAdded); //How many Pepsi the Manager Added
		pepsiAdd.setFont(new Font("Arial", 16));
		HBox h4 =new HBox();
		h4.getChildren().add(pepsiAdd);
		h4.setSpacing(6);
		h4.setAlignment(Pos.CENTER);
		
		Label revrem = new Label();
		revrem.setText("Amount of Revenue Removed:  " + money.RevenueRemoved);
		revrem.setFont(new Font("Arial", 16));
		HBox h5 =new HBox();
		h5.getChildren().add(revrem);
		h5.setSpacing(6);
		h5.setAlignment(Pos.CENTER);
		
		VBox Middle = new VBox(10);
		Middle.setPadding(new Insets(10,10,10,10));
		Middle.getChildren().addAll(h1, h2 ,h3, h4, h5);
		
		Button help = new Button("Help");
		help.setOnAction(e -> {
			getHelp();
		});

		
		Button back = new Button("Back");
		back.setOnAction(e -> {
			window8.close();
		});
		
		
		HBox bottom = new HBox();
		bottom.setAlignment(Pos.BOTTOM_LEFT); 
		bottom.getChildren().addAll(back, help); 
		bottom.setSpacing(5);
		
		
		Insets insets = new Insets(10);
		BorderPane borderpane = new BorderPane();
		borderpane.setTop(top);
		BorderPane.setAlignment(top, Pos.CENTER);
		BorderPane.setMargin(top, insets);
		borderpane.setCenter(Middle);
		BorderPane.setMargin(Middle, insets);
		BorderPane.setAlignment(Middle, Pos.CENTER);
		borderpane.setBottom(bottom);
		borderpane.setPadding(new Insets(6));
		


		Scene scene = new Scene( borderpane, 500, 400);

		window8.setTitle("Drinks Order");
	    scene.getStylesheets().add("style.css");
		window8.setScene(scene);
		window8.show();

		
		
		
	}
	
	public static void getHelp() { //Get Help Facility
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("The Drink you added folow by the quantity is Displayed\n"
				+ "1. To Go Back press the back Button\n"
		);
		alert.showAndWait();

		
	}



}
