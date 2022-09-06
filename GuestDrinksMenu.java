
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

public class GuestDrinksMenu extends AccountdrinksMenu {





	//This is the quantity of drinks bought
	static TextField amountCoke;
	static TextField amountFanta;
	static TextField amountSprite;
	static TextField amountPepsi;
	static TextField moneyEnter;
	int quantity;
	static Button btnSelect;
	Button btnClear;
	Label lblcoke, lblfanta, lblsprite, lblpepsi;
	static double price =1.20;
	static int CokesBought;
	static int FantasBought;
	static int SpritesBought;
	static int PepsisBought;
	static double priceCoke;
	static double priceFanta;
	static double priceSprite;
	static double pricePepsi;
	static double totalDrinks;
	static double totalCost;
	static double  MoneyEnter;
	static boolean answer;
	static double ChangeLeft;






	public static void display() {


		Stage window4 = new Stage();
		window4.setTitle("Drinks Menu");
		window4.initModality(Modality.APPLICATION_MODAL);


		///main label
		Label guestlbl = new Label();
		guestlbl.setText("Guest Menu");
		guestlbl.setFont(new Font("Arial", 19));
		guestlbl.setPadding(new Insets(23,10,5,5));

		//For entering money
		Label lblEnter = new Label("Please Enter Money:  ");
		lblEnter.setFont(new Font("Arial", 13));
		moneyEnter = new TextField();  
		moneyEnter.setPromptText("Enter Amount");

		HBox m =new HBox();
		m.setSpacing(6);

		Button verifyMoney = new Button("Verify");
		verifyMoney.setOnAction(e-> {
			if(ValidateMoney(moneyEnter)) {
				getConfirm();
			}
			else {	 
				moreNeed();
			}
		}
				);
		HBox h = new HBox();
		h.getChildren().addAll(lblEnter, moneyEnter, verifyMoney);
		h.setSpacing(6);
		h.setAlignment(Pos.CENTER);



		//For Buying a Coke
		Label lblcoke = new Label(String.format("   Coke:  " +  "Price: €" +  price + "  "));
		lblcoke.setFont(new Font("Arial", 13));
		amountCoke = new TextField();
		amountCoke.setPromptText("Quantity of Coke");	
		Button verifyCoke = new Button("Add");		
		verifyCoke.setOnAction(e ->{	
			CokesBought =  Integer.parseInt(amountCoke.getText());//parsing cokes bought into an int
			if(CokesBought<=AccountdrinksMenu.coke) { //If statement to see that cokes ordered isnt more than whats in stock
				AccountdrinksMenu.coke-=CokesBought; //deducting cokes bought from cokes in stock
				priceCoke = CokesBought*price;	//finding the price of all cokes bought
				CreditCard.getConfirmationBox();
				System.out.println("\nCoke bought:   " + CokesBought);

			}
			else {	
				AccountdrinksMenu.outOfStockAlert(); //alert to show when the drink wanting to be ordered is out of stock
			}


		});
		HBox h1 = new HBox();
		h1.getChildren().addAll(lblcoke, amountCoke, verifyCoke);
		h1.setSpacing(6);
		h1.setAlignment(Pos.CENTER);


		//For buying a Fanta
		Label lblfanta = new Label(String.format("   Fanta:  "  +  "Price: €" +  price + "  "));
		lblfanta.setFont(new Font("Arial", 13));
		amountFanta = new TextField();
		amountFanta.setPromptText("Quantity of Fanta");

		Button verifyFanta = new Button("Add");
		verifyFanta.setOnAction(e ->{	
			FantasBought =  Integer.parseInt(amountFanta.getText());
			if(FantasBought<=AccountdrinksMenu.fanta) { //Same as coke
				AccountdrinksMenu.fanta -=FantasBought;
				priceFanta = FantasBought*price;
				CreditCard.getConfirmationBox();
				System.out.println("\nFanta bought:  " + FantasBought);
			}else {
				outOfStockAlert();
			}

		});
		HBox h2 = new HBox();
		h2.getChildren().addAll(lblfanta, amountFanta, verifyFanta);
		h2.setSpacing(6);
		h2.setAlignment(Pos.CENTER);


		//For buying a Sprite
		Label lblsprite = new Label(String.format("  Sprite:  " + "Price: €" +  price + "  "));
		lblsprite.setFont(new Font("Arial", 13));
		amountSprite= new TextField();
		amountSprite.setPromptText("Quantity of Sprite");

		Button verifySprite = new Button("Add");
		verifySprite.setOnAction(e ->{
			SpritesBought =  Integer.parseInt(amountSprite.getText());
			if(SpritesBought<=AccountdrinksMenu.sprite) { //same as coke
				AccountdrinksMenu.sprite-=SpritesBought;
				priceSprite = SpritesBought*price;
				CreditCard.getConfirmationBox();
				System.out.println("\nSprite bought: " + SpritesBought);
			}
			else {	
				outOfStockAlert();
			}



		});
		HBox h3 = new HBox();
		h3.getChildren().addAll(lblsprite, amountSprite, verifySprite);
		h3.setSpacing(6);
		h3.setAlignment(Pos.CENTER);

		//For buying Pepsi
		Label lblpepsi = new Label(String.format("  Pepsi:  "  +  "Price: €" +  price + "  "));
		lblpepsi.setFont(new Font("Arial", 13));
		amountPepsi= new TextField();
		amountPepsi.setPromptText("Quantity of Pepsi");
		Button verifyPepsi = new Button("Add");
		verifyPepsi.setOnAction(e ->{

			PepsisBought =  Integer.parseInt(amountPepsi.getText());
			if(PepsisBought<=AccountdrinksMenu.pepsi) { //same as coke
				AccountdrinksMenu.pepsi -=PepsisBought;
				pricePepsi = PepsisBought*price;	
				CreditCard.getConfirmationBox();
				System.out.println("\nPepsi bought:  " + PepsisBought);
			}
			else {
				outOfStockAlert();
			}


		});

		HBox h4 = new HBox();
		h4.getChildren().addAll(lblpepsi, amountPepsi, verifyPepsi);
		h4.setSpacing(6);
		h4.setAlignment(Pos.CENTER);

		Button report = new Button("Report");
		report.setOnAction(e -> {
			Complaints.display();
		});
		report.setPrefWidth(100);



		Button addToCart = new Button("Complete order"); //Button to press when finished ordering
		addToCart.setOnAction(e -> {
			if(MoneyEnter>=totalCost) { //checking if the money eneter is equal or more than the order
				NoChange.display(); //Showing a method to confirm if order wants to be finished
				totals();
				Transaction(totalCost); 
			}

			else {
				System.out.println("Not enough money Entered");
			}
		});
		addToCart.setPrefWidth(100);


		Button cancel = new Button("Cancel"); //button to exit the stage
		cancel.setOnAction(e -> {
			window4.close();
		});

		Button help = new Button("Help");
		help.setOnAction(e -> {
			getHelp();
		});

		HBox bottom = new HBox();
		bottom.getChildren().addAll(cancel,help);
		bottom.setSpacing(5);


		VBox v2 = new VBox(10);
		v2.setAlignment(Pos.CENTER);
		v2.setPadding(new Insets(10,10,10,10));
		v2.getChildren().addAll(h, h1, h2, h3, h4, addToCart,report);
		v2.setSpacing(17);


		Insets insets = new Insets(10);


		BorderPane borderpane = new BorderPane();
		borderpane.setTop(guestlbl);
		BorderPane.setMargin(guestlbl, insets);
		BorderPane.setAlignment(guestlbl, Pos.CENTER);
		borderpane.setCenter(v2);
		BorderPane.setMargin(v2, insets);
		BorderPane.setAlignment(v2, Pos.CENTER);
		borderpane.setBottom(bottom);
		BorderPane.setAlignment(bottom, Pos.BOTTOM_LEFT);
		borderpane.setPadding(new Insets(8));



		Scene sceneD = new Scene(borderpane, 500, 500);

		window4.setTitle("Drinks Order");
		sceneD.getStylesheets().add("style.css");
		window4.setScene(sceneD);
		window4.show();

	}





	public static void moreNeed() { //Alert saying not enough money was entered to purchase one drink

		System.out.println("Entry Error");
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Validation Box");
		alert1.setHeaderText("Money Entry result!");
		alert1.setContentText("You have not entered enough of the correct currency! ");
		alert1.showAndWait();
	}



	public static void getConfirm() { //confirm box
		System.out.println("Entry Successful");
		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setTitle("Validation Box");
		alert1.setHeaderText("You have Entered enough money to buy a drink");
		alert1.setContentText("Warning this machine does not dispanse any change press help for more info");
		alert1.showAndWait();

	}



	public static double totals() { //Method to find the total cost
		totalCost = priceCoke+priceFanta+priceSprite+pricePepsi;
		System.out.println("\nTotal Cost: " + totalCost);
		return totalCost;

	}



	public static void Transaction(double totalCost) {	//Method to conduct Transaction

		System.out.println("Total cost is: "  + totalCost);

		if(MoneyEnter>=totalCost) {
			AccountdrinksMenu.Revenue+=MoneyEnter; //Adding total cost to revenue
			ChangeLeft = MoneyEnter-totalCost; //This is how much change was left by the machine
			System.out.println("Change Left: " + ChangeLeft);
			System.out.println("Enjoy your drinks");
		}
		else {
			CreditCard.getErrorMessage();
		}
	}






	public static boolean isDouble(TextField text){ //method to see if a Double was entered
		try {
			MoneyEnter =  Double.parseDouble(text.getText());	
			return true;
		}
		catch(NumberFormatException e) {
			getErrorMessage();
			throw new NumberFormatException("Invalid Input!");

		}	

	}

	public static boolean ValidateMoney(TextField text) { //Method for validation, settin regex to accept only alphabetic and single apostrophe
		MoneyEnter = Double.parseDouble(moneyEnter.getText());

		if(MoneyEnter>=1.20)
		{
			System.out.println("You have entered Enough Money");
			return true;
		}else {
			System.out.println("You have not entered enough money please Enter at least 1.20");
			return false;
		}

	}


	public static void getErrorMessage () { //error alert

		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("ErrorBox");
		alert1.setHeaderText("incorrect input");
		alert1.setContentText("Please input a number value ");
		alert1.showAndWait();
	}








}


