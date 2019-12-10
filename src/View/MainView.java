package View;

import java.io.IOException;
import java.util.Optional;

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
	
	

	public void exit(ActionEvent event) {
		Alert al = new Alert(Alert.AlertType.CONFIRMATION);
		al.setHeaderText("Are You Sure You Want To Exit From The System?");
		al.setTitle("Exit System");
		al.setResizable(false);
		Optional<ButtonType> result = al.showAndWait();
		if(result.get() == ButtonType.OK)
			System.exit(0);
	}

	public void importData(ActionEvent event) {

	}
	
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

	public void foundList(ActionEvent event) {

	}

	public void missingList(ActionEvent event) {

	}
}
