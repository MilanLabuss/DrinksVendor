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


public class Report {

	public static void display() {
		
		Stage window6 = new Stage();
		window6.setTitle("Report Menu");
		window6.initModality(Modality.APPLICATION_MODAL);
		
		///Top label
		Label drinksSoldlbl = new Label(); //Creating Label
		drinksSoldlbl.setText("Each Drink Sold");
		drinksSoldlbl.setFont(new Font("Arial", 19));
		
		
		HBox mainlbl = new HBox(); //creating HBox
		mainlbl.getChildren().addAll(drinksSoldlbl);
		mainlbl.setAlignment(Pos.CENTER);
		
				
		
		Label cokeSold = new Label(); //Creating Label
		cokeSold.setText("Coke Sold: " + (AccountdrinksMenu.CokeBought+GuestDrinksMenu.CokesBought));
		cokeSold.setFont(new Font("Arial", 16));
		HBox h1 =new HBox();
		h1.getChildren().add(cokeSold);
		h1.setSpacing(6);
		h1.setAlignment(Pos.CENTER);
		
		Label fantaSold = new Label();//Creating Label
		fantaSold.setText("Fanta Sold: " + (AccountdrinksMenu.FantaBought+GuestDrinksMenu.FantasBought));
		fantaSold.setFont(new Font("Arial", 16));
		HBox h2 =new HBox();
		h2.getChildren().add(fantaSold);
		h2.setSpacing(6);
		h2.setAlignment(Pos.CENTER);
		
		Label spriteSold = new Label();//Creating Label
		spriteSold.setText("Sprite Sold: " + (AccountdrinksMenu.SpriteBought+GuestDrinksMenu.SpritesBought));
		spriteSold.setFont(new Font("Arial", 16));
		HBox h3 =new HBox();
		h3.getChildren().add(spriteSold);
		h3.setSpacing(6);
		h3.setAlignment(Pos.CENTER);
		
		Label pepsiSold = new Label();//Creating Label
		pepsiSold.setText("Pepsi Sold: " + (AccountdrinksMenu.PepsiBought+GuestDrinksMenu.PepsisBought));
		pepsiSold.setFont(new Font("Arial", 16));
		HBox h4 =new HBox();
		h4.getChildren().add(pepsiSold);
		h4.setSpacing(6);
		h4.setAlignment(Pos.CENTER);
		
		
		//Creating Label
		Label Rev = new Label();
		Rev.setText("Revenue: " + AccountdrinksMenu.Revenue);
		Rev.setFont(new Font("Arial", 16));
		HBox h5 =new HBox();
		h5.setSpacing(6);
		h5.getChildren().add(Rev);
		h5.setAlignment(Pos.CENTER);
		
		Label Change = new Label();//Creating Label
		Change.setText("Change Left: " + GuestDrinksMenu.ChangeLeft);
		Change.setFont(new Font("Arial", 16));
		HBox h6 =new HBox();
		h6.setSpacing(6);
		h6.getChildren().add(Change);
		h6.setAlignment(Pos.CENTER);
		
		Label moneyRev = new Label();//Creating Label
		moneyRev.setText("Revenue Removed: " + money.RevenueRemoved );
		moneyRev.setFont(new Font("Arial", 16));
		HBox h7 =new HBox();
		h7.setSpacing(6);
		h7.getChildren().add(moneyRev);
		h7.setAlignment(Pos.CENTER);
		
		
		Label NoUsers = new Label();//Creating Label
		NoUsers.setText("Number of Users: 1");
		NoUsers.setFont(new Font("Arial", 16));
		HBox h8 =new HBox();
		h8.setSpacing(6);
		h8.getChildren().add(NoUsers);
		h8.setAlignment(Pos.CENTER);
		
		VBox middle = new VBox();//Creating Label
		middle.getChildren().addAll( h1, h2, h3, h4,h5,h6,h7,h8);
		middle.setSpacing(10);
		
		Button help = new Button("Help");
		help.setOnAction(e -> {
			getHelp();
		});
		
		Button back = new Button("Back");
		back.setOnAction(e -> {
			window6.close();
		});
		
		HBox bottom = new HBox();
		bottom.getChildren().addAll(back,help);
		bottom.setSpacing(6);
		

		Insets insets = new Insets(10);
		
		BorderPane borderpane = new BorderPane();
		borderpane.setTop(mainlbl);
		BorderPane.setMargin(mainlbl,insets);
		borderpane.setCenter(middle);
		BorderPane.setMargin(middle, insets);
		borderpane.setBottom(bottom);
		borderpane.setPadding(new Insets(6));
		
		Scene sceneE = new Scene( borderpane, 400, 400);
		sceneE.getStylesheets().add("style.css");
		window6.setScene(sceneE);
		window6.show();
		
	
		
	}
	
	

	
	public static Alert getHelp() { //get Help Alert
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("If you wish to exit this report press the back button"
				);	
		alert.showAndWait();
		return alert;
	}


}
