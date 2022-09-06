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




public class Maintenance {
	static int CokeAdded;
	static int FantaAdded;
	static int SpriteAdded;
	static int PepsiAdded;



	public static void display (){



		Stage window = new Stage();
		window.setTitle("Maintenance");
		window.initModality(Modality.APPLICATION_MODAL);
		
		Label drinkStock = new Label();//creating a label
		drinkStock.setText("Please Enter the Quantity of drinks you wish to add");
		drinkStock.setFont(new Font("Arial", 16));
	


		//For adding Coke
		Label addcoke = new Label("Coke In Stock: " + AccountdrinksMenu.coke + "   ");
		TextField amountCoke = new TextField();
		amountCoke.setPrefWidth(150);
		amountCoke.setPromptText("Add Coke");
		Button addCoke = new Button("Add");
		addCoke.setOnAction(e -> {
				CokeAdded  =  Integer.parseInt(amountCoke.getText()); //Changing the textfield entry into an Int
				if( ((CokeAdded+AccountdrinksMenu.coke)<=20) ) { //An if statement to see if the amount added and in stock are not over 20
					AccountdrinksMenu.coke=AccountdrinksMenu.coke+CokeAdded; //Adding the Coke to the vending machine	
				}
				else {
					getErrorMessage();
				}
		
		});
		HBox h1 = new HBox();
		h1.getChildren().addAll(addcoke, amountCoke, addCoke);
		h1.setSpacing(4);

		//For adding Fanta
		Label addfanta = new Label("Fanta In Stock: " + AccountdrinksMenu.fanta + "   ");
		TextField amountFanta = new TextField();
		amountFanta.setPrefWidth(150);
		amountFanta.setPromptText("Add Fanta");
		Button addFanta = new Button("Add");
		addFanta.setOnAction(e -> {
		
				FantaAdded =  Integer.parseInt(amountFanta.getText());
				if( ((FantaAdded+AccountdrinksMenu.fanta)<=20) ) {
					AccountdrinksMenu.fanta=AccountdrinksMenu.fanta+FantaAdded;	//Same as Coke
				}
				else {
					getErrorMessage();
				}
		});
		HBox h2 = new HBox();
		h2.getChildren().addAll(addfanta,amountFanta, addFanta);
		h2.setSpacing(4);

		//For adding Sprite
		Label addsprite = new Label("Sprite In Stock: " + AccountdrinksMenu.sprite + "  ");
		TextField amountSprite = new TextField();
		amountSprite.setPrefWidth(150);
		amountSprite.setPromptText("Add Sprite");
		Button addSprite = new Button("Add");
		addSprite.setOnAction(e -> {
		
			SpriteAdded =  Integer.parseInt(amountSprite.getText());
			if( ((SpriteAdded+AccountdrinksMenu.sprite)<=20) ) {
				AccountdrinksMenu.sprite=AccountdrinksMenu.sprite+SpriteAdded;	//Same as Coke
			}
			else {
				getErrorMessage();
			}
		});
		HBox h3 = new HBox();
		h3.getChildren().addAll(addsprite,amountSprite, addSprite);
		h3.setSpacing(4);

		
		
		
		//For adding Pepsi
		Label addpepsi = new Label("Pepsi In Stock: " + AccountdrinksMenu.coke + "   ");
		TextField amountPepsi = new TextField();
		amountPepsi.setPrefWidth(150);
		amountPepsi.setPromptText("Add Pepsi");
		Button addPepsi = new Button("Add");
		
		addPepsi.setOnAction(e -> {
	
		    PepsiAdded =  Integer.parseInt(amountPepsi.getText());
			if( ((PepsiAdded+AccountdrinksMenu.pepsi)<=20) ) {
				AccountdrinksMenu.pepsi=AccountdrinksMenu.pepsi+PepsiAdded;	 //Same as Coke
			}
			else {
				getErrorMessage();
			}
		});
		HBox h4 = new HBox();
		h4.getChildren().addAll(addpepsi,amountPepsi, addPepsi);
		h4.setSpacing(4);


		Button help = new Button("Help"); //Help Button
		help.setOnAction(e -> {
			getHelp();
		});

		HBox h = new HBox();
		h.setAlignment(Pos.BOTTOM_RIGHT); 
		h.getChildren().addAll(help); 
		h.setSpacing(5);
		
		Button cancel = new Button("Cancel"); //Cancel Button
		cancel.setOnAction(e -> {
			window.close();
		});
		
		
		Button complaint = new Button("Complaints");
		complaint.setOnAction(e ->{
			getComlaint();
		});
		
		
		HBox bottom = new HBox();
		bottom.getChildren().addAll(cancel,help,complaint);
		bottom.setAlignment(Pos.BOTTOM_LEFT);
		bottom.setSpacing(6);
		
		
		Button submit = new Button();
		submit.setText("Submit");
		submit.setOnAction(e -> {
			Manager.display();
		});
		
		VBox v = new VBox(10);
		v.setPadding(new Insets(10,10,10,10));
		v.getChildren().addAll(h1, h2 ,h3, h4,submit);
		
		Insets insets = new Insets(10);
		
		BorderPane borderpane = new BorderPane();
		borderpane.setTop(drinkStock);
		BorderPane.setAlignment(drinkStock, Pos.CENTER);
		BorderPane.setMargin(drinkStock, insets);
		borderpane.setCenter(v);
		BorderPane.setMargin(v, insets);
		BorderPane.setAlignment(v, Pos.CENTER);
		borderpane.setBottom(bottom);
		borderpane.setPadding(new Insets(6));
		


		Scene sceneD = new Scene( borderpane, 500, 400);

		window.setTitle("Drinks Order");
	    sceneD.getStylesheets().add("style.css");
		window.setScene(sceneD);
		window.show();



	}

	public static void getHelp() { //getHelp
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("Please Enter the quantity of drinks you want to add in the textfield beside it and press add\n"
				+ "1. Once you are done press enter to go back to the Manager screen\n"
		);
		alert.showAndWait();

		
	}

	public static void getErrorMessage() { //Error message alert
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Validation Box");
		alert1.setHeaderText("incorrect input!");
		alert1.setContentText("This Machine can hold only 20 of each Drink ");

		alert1.showAndWait();

	}

	public static Alert getReport() { //Report alert
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Report Box");
		alert.setHeaderText("The Report");	
		alert.setContentText(Complaints.getComplaint());
		alert.showAndWait();

		return alert;

	}
	

	public static Alert getComlaint() {


		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Complaint Box");
		//alert.setHeaderText("Complaints");	
		alert.setContentText("Cusomter complaints:  " + Complaints.getComplaint());
		alert.showAndWait();

		return alert;
		
	}

















}


