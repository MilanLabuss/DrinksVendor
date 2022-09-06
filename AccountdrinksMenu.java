
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

public class AccountdrinksMenu extends TopUp {

	//Variables
	static TextField amountCoke;
	static TextField amountFanta;
	static TextField amountSprite;
	static TextField amountPepsi;
	int quantity;
	static Button btnSelect;
	Button btnClear;
	Label lblcoke, lblfanta, lblsprite, lblpepsi;
	boolean checkingOut = true;
	static double price =1.20;
	static double discount= 0.05;
	static int CokeBought;
	static int FantaBought;
	static int SpriteBought;
	static int PepsiBought;
	static int coke=20;
	static int fanta=20;
	static int sprite=20;
	static int pepsi=20;
	static double priceCoke;
	static double priceFanta;
	static double priceSprite;
	static double pricePepsi;
	static double cokeDiscount;
	static double fantaDiscount;
	static double spriteDiscount;
	static double pepsiDiscount;
	static double Revenue;
	static double totalCost;
	





	public static void display() {


		Stage window4 = new Stage();
		window4.setTitle("Drinks Menu");
		window4.initModality(Modality.APPLICATION_MODAL);

		Label menu = new Label();//Label for the Top
		menu.setText("Please Select Which Drinks you would like to purchase");
		menu.setFont(new Font("Arial", 16));
		menu.setAlignment(Pos.TOP_CENTER); 



		//For Buying a Coke
		Label lblcoke = new Label(String.format("   Coke:  " +  "Price: €" +  price+ "  ")); //Label showing price of Coke
		lblcoke.setFont(new Font("Arial", 13));
		amountCoke = new TextField(); //Textfield to enter the quantity they wish to purchase
		amountCoke.setPromptText("Quantity of Coke");
		amountCoke.setPrefWidth(120);
		amountCoke.setMaxWidth(120); 

		Button verifyCoke = new Button("Add"); //Buttont to add cokes to total(basket)
		verifyCoke.setOnAction(e ->{
			
			CokeBought =  Integer.parseInt(amountCoke.getText()); //Parsing the textfield into an Int
			if(CokeBought<coke) { //IF statement checking if there is more coke in stock than ordered
				coke-=CokeBought;
				cokeDiscount = CokeBought*discount; //Seeing how mcuh the discount will be by multiplying it by cokes ordered
				priceCoke = (CokeBought*price)-cokeDiscount; //Find prices of cokes ordered and applying discount
				CreditCard.getConfirmationBox();
				System.out.println("\nCoke bought:  " + CokeBought);

			}else {	
				outOfStockAlert();
			}
		});
		HBox h1 = new HBox(); //h for everything in ordering a coke
		h1.setAlignment(Pos.BOTTOM_CENTER); 
		h1.getChildren().addAll(lblcoke, amountCoke, verifyCoke);
		h1.setSpacing(5);



		//For buying a Fanta
		Label lblfanta = new Label(String.format("   Fanta:  "  +  "Price: €" +  price + "  "));
		lblfanta.setFont(new Font("Arial", 13));
		amountFanta = new TextField();
		amountFanta.setPrefWidth(120);
		amountFanta.setMaxWidth(120); 
		amountFanta.setPromptText("Quantity of Fanta");

		Button verifyFanta = new Button("Add");
		verifyFanta.setOnAction(e ->{
         FantaBought =  Integer.parseInt(amountFanta.getText());
			if(FantaBought<fanta) { //Same method used for Coke
				fanta -=FantaBought;
				fantaDiscount = FantaBought*discount;
				priceFanta = (FantaBought*price)-fantaDiscount;
				CreditCard.getConfirmationBox();
				System.out.println("\nFanta bought: " + FantaBought);

			}else {	
				outOfStockAlert();
			}

		});
		HBox h2 = new HBox();
		h2.setAlignment(Pos.BOTTOM_CENTER); 
		h2.getChildren().addAll(lblfanta, amountFanta, verifyFanta);
		h2.setSpacing(5);


		//For buying a Sprite
		Label lblsprite = new Label(String.format("  Sprite:  " + "Price: €" +  price + "  "));
		lblsprite.setFont(new Font("Arial", 13));
		amountSprite= new TextField();
		amountSprite.setPromptText("Quantity of Sprite");
		amountSprite.setPrefWidth(120);
		amountSprite.setMaxWidth(120); 
		Button verifySprite = new Button("Add");
		verifySprite.setOnAction(e ->{		
		SpriteBought =  Integer.parseInt(amountSprite.getText());
			if(SpriteBought<sprite) { //Same Method as Coke
				CreditCard.getConfirmationBox();
				sprite -= SpriteBought;
				spriteDiscount = SpriteBought*discount;
				priceSprite = (SpriteBought*price)-spriteDiscount;
				System.out.println("\nSprite bought: " + SpriteBought);

			}else {	
				outOfStockAlert();
			}


		});
		HBox h3 = new HBox();
		h3.setAlignment(Pos.BOTTOM_CENTER); 
		h3.getChildren().addAll(lblsprite, amountSprite, verifySprite);
		h3.setSpacing(5);


		//For buying Pepsi
		Label lblpepsi = new Label(String.format("  Pepsi:  "  +  "Price: €" +  price + "  "));
		lblpepsi.setFont(new Font("Arial", 13));
		amountPepsi= new TextField();
		amountPepsi.setPromptText("Quantity of Pepsi");
		amountPepsi.setPrefWidth(120);
		amountPepsi.setMaxWidth(120);
		
		Button verifyPepsi = new Button("Add");
		verifyPepsi.setOnAction(e ->{

			PepsiBought =  Integer.parseInt(amountPepsi.getText());
			if(PepsiBought<pepsi) { //Same method as Coke
				CreditCard.getConfirmationBox();
				pepsi -=PepsiBought;
				pepsiDiscount = PepsiBought*discount;
				pricePepsi = (PepsiBought*price)-pepsiDiscount;
				System.out.println("\nPepsi bought:  " + PepsiBought);
			
			}
			else {
				outOfStockAlert();
			}

		});

		HBox h4 = new HBox();
		h4.setAlignment(Pos.BOTTOM_CENTER); 
		h4.getChildren().addAll(lblpepsi, amountPepsi, verifyPepsi);
		h4.setSpacing(5);



		Button addToCart = new Button("Complete order");//Making a complete order button 
		addToCart.setOnAction(e -> {
			boolean result = ConfirmPurchase.display(totalCost); //Linking a confirm purchase class that will return the answer			
			if(result == true ) { //If the yes is clicked then we go ahead with the order
				Transaction();
				totalCost = priceCoke+priceFanta+priceSprite+pricePepsi; //Find total cost of the Order
				System.out.println("\nTotal Cost: " + totalCost);  
				//Revenue+=totalCost; //Adding the total cost to the machine revenue
				TopUp.accountBalance-=totalCost;//Deducting the total cost from the Account Balance
			}
			else {
				window4.close(); //If the no Button is pressed it exits the stage
			}
	
		});
		addToCart.setPrefWidth(130);


		Button showBalance = new Button("Show Balance"); //Button to show the account Balance
		showBalance.setOnAction(e -> {
			TopUp.ShowBalance();
		});
		showBalance.setPrefWidth(130);

		Button topUp = new Button("Top Up"); //Button to go to top up menu
		topUp.setOnAction(e -> {
			TopUp.display();
		});
		topUp.setPrefWidth(130);

		Button exit = new Button("Exit"); //Button to exit the Menu
		exit.setOnAction( e -> {
			window4.close();
		});		
		exit.setPrefWidth(130);

		Button report = new Button("Report"); //Button if the user wants to report something
		report.setOnAction(e -> {
			Complaints.display();
		});


		Button help = new Button("Help");
		help.setOnAction(e -> {
			getHelp();
		});

		HBox h = new HBox();
		h.setAlignment(Pos.BOTTOM_RIGHT); 
		h.getChildren().addAll(help,report); 
		h.setSpacing(5);


		VBox textfields = new VBox(10); //Creating Textfield
		textfields.setAlignment(Pos.BASELINE_CENTER);
		textfields.setPadding(new Insets(10,10,10,10));
		textfields.getChildren().addAll(menu, h1, h2, h3, h4);
		textfields.setSpacing(21);



		VBox menuButtons = new VBox(); //Creating VBox
		menuButtons.setAlignment(Pos.BASELINE_CENTER);
		menuButtons.setPadding(new Insets(15, 15, 15, 15));
		menuButtons.getChildren().addAll(addToCart,showBalance,topUp,exit,h);
		menuButtons.setSpacing(10);

		Insets insets = new Insets(10);


		BorderPane borderpane = new BorderPane();//Creating BorderPane
		borderpane.setTop(textfields);
		BorderPane.setMargin(textfields, insets);
		borderpane.setCenter(menuButtons);
		BorderPane.setMargin(menuButtons, insets);
		borderpane.setBottom(h);
		borderpane.setPadding(new Insets(6));


		Scene sceneD = new Scene(borderpane, 600, 540);
		sceneD.getStylesheets().add("style.css");
		window4.setTitle("Drinks Order");
		window4.setScene(sceneD);
		window4.show();


	}
	
	public static double totals() { //Method to calculate and return total Cost
		totalCost = priceCoke+priceFanta+priceSprite+pricePepsi;
		
		return totalCost;
		
	}


	
	public static double Transaction() {	//method to add total cost to revenue and deduct from Account balance
			
	
			
		if(TopUp.accountBalance>=totalCost) { //Checking if the total cost is less than whats in Account Balance
			Revenue+=totalCost;
		
			return Revenue;
		
			
		}
		else {
			CreditCard.getErrorMessage();
			outOfMoney();
	}
		return Revenue;
	}
	




	public static void outOfMoney() { //An alert to show when the order total is greater than account balance
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Validation Box");
		alert1.setHeaderText("Error not enough money in your account! ");
		alert1.setContentText("Please Top Up! ");	
		alert1.showAndWait();

	}



	public static void outOfStockAlert() {  //Alert to show when a drink is out of stock
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Validation Box");
		alert1.setHeaderText("Error! ");
		alert1.setContentText("Out of Stock! ");

		alert1.showAndWait();
	}




	public static Alert getHelp() { //help alert


		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("Please Enter the quantity of drinks you want in the textfield beside it and press add\n"
				+ "1. Once you are ready to check out press Complete Order\n"
				+ "2. If you wish to see how much money is in your account press Show Balance\n"
				+ "3. Enter the 3 digit security code found at the back\n"
				+ "4. If you wish to top up your account click Top Up\n"
				+ "5. If you wish to exit the program press the Exit button"
				);	
		alert.showAndWait();

		return alert;
	}


}














