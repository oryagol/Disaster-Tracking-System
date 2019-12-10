

import View.MainView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	
	
	public static void main(String args[]) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		MainView.stage = stage;
		Parent root = FXMLLoader.load(getClass().getResource("View/MainView.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setWidth(900);
		stage.setHeight(640);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
		
	}
}
