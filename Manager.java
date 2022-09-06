
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


public class Manager {
	
	public static void display() {
	
	Stage window = new Stage();
	window.setTitle("Manger Menu");
	window.initModality(Modality.APPLICATION_MODAL);
	
	Label Managerlbl = new Label();
	Managerlbl.setText("Managers Menu");
	Managerlbl.setFont(new Font("Arial", 16));
	Managerlbl.setPadding(new Insets(50,10,10,10));

	
	
	Button help = new Button("Help");
	help.setOnAction(e -> {
		getHelp();
	});
	
	Button cancel = new Button("Cancel");
	cancel.setOnAction(e -> {
		window.close();
	});


	
	
	Button report = new Button("Report");
	report.setOnAction(e ->{
		Report.display();
	});
	report.setPrefWidth(150);
	
	Button maintain = new Button("Maintenance");
	maintain.setOnAction(e -> {
		Maintenance.display();
		});
	maintain.setPrefWidth(150);
	
	Button Money = new Button("Retrieve Revenue");
	Money.setOnAction(e -> {
		money.display();
	});
	Money.setPrefWidth(150);
	
	Button repairLog = new Button("Repair Log");
	repairLog.setOnAction(e -> {
		RepairLog.display();
	});
	repairLog.setPrefWidth(150);
	
	
	
	VBox v = new VBox();
	v.getChildren().addAll(report,maintain,Money,repairLog);
	v.setAlignment(Pos.CENTER);
	v.setPadding(new Insets(10,10,10,10));
	v.setSpacing(15);
	
	HBox bottom = new HBox();
	bottom.getChildren().addAll(cancel,help);
	bottom.setAlignment(Pos.BOTTOM_LEFT);
	bottom.setSpacing(6);
	
	


	Insets insets = new Insets(10);
	
	BorderPane borderpane = new BorderPane();
	borderpane.setTop(Managerlbl);
	BorderPane.setAlignment(Managerlbl, Pos.CENTER);
	borderpane.setCenter(v);
	BorderPane.setMargin(v, insets);
	borderpane.setBottom(bottom);
	borderpane.setPadding(new Insets(6));


	Scene sceneD = new Scene( borderpane, 400, 400);
	sceneD.getStylesheets().add("style.css");
	window.setTitle("Drinks Order");
	window.setScene(sceneD);
	window.show();
	
	
	
	}

	public static Alert getHelp() {


		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");
		alert.setContentText("Please Press one the buttons Available add\n"
				+ "1. Press report to read any compaints made by Customers\n"
				+ "2. Press the Add Drinks button to add drinks into the vending machine\n"
				+ "3. Press Retrieve Money to take Revenue out of the machine\n"
				+ "4. Press Cancel to return to the login screen\n"	
				);	
		alert.showAndWait();

		return alert;
	}
	
		
	}
	
	
	
	
	
	
	
	
	
	
	

