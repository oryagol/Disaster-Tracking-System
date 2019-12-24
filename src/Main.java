
import java.util.Calendar;

import Model.JSONHandler;
import Model.LostPerson;
import Model.SysData;
import View.MainView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	public static String fileName = "database.ser";
	
	public static void main(String args[]) {
		SysData.getInstance().loadDataBase(fileName);
		launch(args);
		SysData.getInstance().saveDataBase(fileName);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		MainView.stage = stage;
		Parent root = FXMLLoader.load(getClass().getResource("View/MainView.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.DECORATED);
		stage.show();
		
	}
}
