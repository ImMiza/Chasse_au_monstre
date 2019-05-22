package cam.utils.ihm;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Essai extends Application {

	List<CaseIHM> lesCases = new ArrayList<>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loaderJEU = new FXMLLoader();
		loaderJEU.setLocation(getClass().getResource("CAM.fxml"));
		Parent root = loaderJEU.load();
		Canvas canvas = null;
		HBox hboxTop = new HBox(), hboxBot = new HBox();
		TextArea textArea = new TextArea();
		Label labelBot = new Label(), labelTop = new Label();
		for (int i = 0; i<root.getChildrenUnmodifiable().size(); i++) {
			if (root.getChildrenUnmodifiable().get(i) instanceof HBox) {
				HBox hbox = (HBox)(root.getChildrenUnmodifiable().get(i));
				for (int j =0; i<hbox.getChildren().size(); i++){
					Label label = (Label)(hbox.getChildren().get(i));
					if (label.getText().equals("Top")) {
						hboxTop = hbox;
						labelTop = label;
						labelTop.setText("Chasse au monstre !");
					}
					else if (label.getText().equals("Bot")) {
						hboxBot = hbox;
						labelBot = label;
						labelBot.setText("Chasseur, à vous de jouer..");
					}
				}
			}
			else if (root.getChildrenUnmodifiable().get(i) instanceof Canvas) {
				canvas = (Canvas)root.getChildrenUnmodifiable().get(i);
			}else if(root.getChildrenUnmodifiable().get(i) instanceof TextArea) {
				textArea = (TextArea) root.getChildrenUnmodifiable().get(i);
			}
		}
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				CaseIHM c = new CaseIHM((int) canvas.getWidth() / 10 * j, (int) canvas.getHeight() / 10 * i, canvas.getWidth() / 10, canvas.getHeight() / 10);
				lesCases.add(c);
				gc.strokeRect((int) canvas.getWidth() / 10 * j, (int) canvas.getHeight() / 10 * i, canvas.getWidth() / 10, canvas.getHeight() / 10);
			}
		}
		
		canvas.setOnMouseClicked(e -> {
			double x = e.getX();
			double y = e.getY();
			
			for (int i = 0; i < lesCases.size(); i++) {
				if (lesCases.get(i).getRectangle().contains(x, y)) {
					System.out.println(lesCases.get(i).getRectangle().getX() + ", " + lesCases.get(i).getRectangle().getY());
				}
			}
		});

		
		Scene s = new Scene(root);
		primaryStage.setMinHeight(700);
		primaryStage.setMinWidth(700);
		primaryStage.setScene(s);
		primaryStage.setTitle("CAM");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
