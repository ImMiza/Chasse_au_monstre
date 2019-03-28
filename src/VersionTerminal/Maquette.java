package VersionTerminal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Maquette extends Application{

	@Override
	public void start(Stage primaryStage) {
		Button btnJouer = new Button("Jouer");
		btnJouer.setPrefSize(200, 40);
		VBox.setMargin(btnJouer, new Insets(10));
		Button btnRegles = new Button("Règles");
		btnRegles.setPrefSize(200, 40);
		VBox.setMargin(btnRegles, new Insets(10));
		Rectangle logo = new Rectangle(200, 70);
		logo.setFill(Color.RED);
		VBox.setMargin(logo, new Insets(10, 10, 100, 10));
		Label spacer1 = new Label();
		spacer1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		VBox.setVgrow(spacer1, Priority.ALWAYS);
		Label spacer2 = new Label();
		spacer2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		VBox.setVgrow(spacer2, Priority.ALWAYS);
		Label spacer3 = new Label();
		spacer3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		HBox.setHgrow(spacer3, Priority.ALWAYS);
		Label spacer4 = new Label();
		spacer4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		HBox.setHgrow(spacer4, Priority.ALWAYS);
		
		Button btnQuitter = new Button("Quitter");
		HBox.setMargin(btnQuitter, new Insets(5));
		Label spacer5 = new Label();
		spacer5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		HBox.setHgrow(spacer5, Priority.ALWAYS);
		
		VBox vbButton = new VBox();
		vbButton.getChildren().add(spacer1);
		vbButton.getChildren().add(logo);
		vbButton.getChildren().add(btnJouer);
		vbButton.getChildren().add(btnRegles);
		vbButton.getChildren().add(spacer2);
		
		HBox hbButton = new HBox();
		hbButton.getChildren().add(spacer3);
		hbButton.getChildren().add(vbButton);
		hbButton.getChildren().add(spacer4);
		
		HBox hbBas = new HBox();
		hbBas.getChildren().add(spacer5);
		hbBas.getChildren().add(btnQuitter);
		
		BorderPane root = new BorderPane();
		root.setCenter(hbButton);
		root.setBottom(hbBas);
		
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setTitle("Chasse au monstre");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
