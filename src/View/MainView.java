package View;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;

public class MainView {
	  @FXML
	    private BorderPane menuScreen;

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
	    
	    public void exit() {
			Alert al = new Alert(Alert.AlertType.CONFIRMATION);
			al.setHeaderText("Are You Sure You Want To Exit From The System?");
			al.setTitle("Exit System");
			al.setResizable(false);
			Optional<ButtonType> result = al.showAndWait();
			if(result.get() == ButtonType.OK)
				System.exit(0);
	    }
	    
	    public void importData() {
	    	
	    }
	    
	    public void submitForm() {
	    	
	    }
	    
	    public void foundList() {
	    	
	    }
	    
	    public void missingList() {
	    	
	    }
}
