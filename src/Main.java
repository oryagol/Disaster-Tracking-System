import java.util.Calendar;

import Model.JSONHandler;
import Controller.MainController;
import Model.Finder;
import Model.HairColor;
import Model.LostPerson;
import Model.Searcher;
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
		LostPerson lp = new LostPerson("or", 1);
		Searcher s = new Searcher("saghi", "050", "oryagol@gmail.com", 5, lp);
		Finder f = new Finder("toto", "053", "oryagol@gmail.com", 2, "haifa", lp);
		lp.setColor("Blonde");
		lp.setDateFound(Calendar.getInstance());
		lp.setHeight(1.75);
		lp.setWeight(70);
		lp.setMatchPercent(75.0);
		lp.setMissingReportDate(Calendar.getInstance());
		lp.setFoundedBy(f);
		lp.setSearchBy(s);
		MainController control = new MainController();
		System.out.println(control.sendEmail(s));
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
