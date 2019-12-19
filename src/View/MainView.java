package View;

import java.io.IOException;
import java.util.Optional;

import Controller.MainController;
import Model.JSONHandler;
import Model.SysData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainView {

	public static Stage stage = new Stage();
	@FXML
	private BorderPane borderMain;

	@FXML
	private AnchorPane menuScreen;

	@FXML
	private AnchorPane subScreen;

	@FXML
	private ToggleButton missingListBtn;

	@FXML
	private ToggleButton foundListBtn;

	@FXML
	private ToggleButton submitBtn;

	@FXML
	private ToggleButton importBtn;

	@FXML
	private ToggleButton exitBtn;

	private MainController control = new MainController();
	
	public static String fileName = "database.ser";


	//exit from system
	public void exit(ActionEvent event) {
		Alert al = new Alert(Alert.AlertType.CONFIRMATION);
		al.setHeaderText("Are You Sure You Want To Exit From The System?");
		al.setTitle("Exit System");
		al.setResizable(false);
		Optional<ButtonType> result = al.showAndWait();
		if(result.get() == ButtonType.OK)
			System.exit(0);
	}
	//import the found person from other systems and checks for a match
	public void importData(ActionEvent event) {
		Alert al = new Alert(Alert.AlertType.INFORMATION);
		if(JSONHandler.readLostPersonList()) {
			al.setHeaderText("Imported Successfully");
			al.setTitle("System Messege");
			al.setResizable(false);
			SysData.getInstance().saveDataBase(fileName);
			int count = control.syncLists();
			Alert al1 = new Alert(Alert.AlertType.INFORMATION);
			if(count == 0) {
				al1.setHeaderText("Matches Not Found");
				al1.setTitle("System Messege");
				al1.setResizable(false);
			}
			else {
				al1.setHeaderText("Found "+count+"Matches!");
				al1.setTitle("System Messege");
				al1.setResizable(false);
			}
		}
		else {
			al.setHeaderText("Import failed");
			al.setTitle("System Messege");
			al.setResizable(false);
		}

	}
	//a page that the user can submit a form of missing person
	public void submitForm(ActionEvent event) {
		try {
			AnchorPane pane=FXMLLoader.load(getClass().getResource("FrmSubmitMissing.fxml"));
			pane.setPrefSize(subScreen.getWidth(), subScreen.getHeight());
			subScreen.getChildren().removeAll(subScreen.getChildren());
			subScreen.getChildren().add(pane);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//show the found person list
	public void foundList(ActionEvent event) {
		try {
			AnchorPane pane=FXMLLoader.load(getClass().getResource("FoundTable.fxml"));
			pane.setPrefSize(subScreen.getWidth(), subScreen.getHeight());
			subScreen.getChildren().removeAll(subScreen.getChildren());
			subScreen.getChildren().add(pane);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//show the missing person list
	public void missingList(ActionEvent event) {
		try {
			AnchorPane pane=FXMLLoader.load(getClass().getResource("MissingTable.fxml"));
			pane.setPrefSize(subScreen.getWidth(), subScreen.getHeight());
			subScreen.getChildren().removeAll(subScreen.getChildren());
			subScreen.getChildren().add(pane);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
