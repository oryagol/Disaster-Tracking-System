package View;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;

public class FrmSubmitMissing {

	@FXML
	private TextField missFirstName;

	@FXML
	private TextField missLastName;

	@FXML
	private TextField missID;

	@FXML
	private TextField searchFirstName;

	@FXML
	private TextField searchLastName;

	@FXML
	private TextField searchID;

	@FXML
	private TextField searchEmail;

	@FXML
	private TextField searchPhone;

	@FXML
	private TextArea moreInfo;

	@FXML
	private DatePicker date;

	@FXML
	private Button submit;

	@FXML
	private Button upload;

	final FileChooser fileChooser = new FileChooser();

	private File image;

	@FXML
	void submit(ActionEvent event) {
		String id = missID.getText();
		if(image != null)
		{
			File toFile = new File("src/View/Photos/"+id);
			try {
				java.nio.file.Files.move(image.toPath(), toFile.toPath() ,StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}


	}

	@FXML
	void upload(ActionEvent event) {
		image = fileChooser.showOpenDialog(MainView.stage);
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif") );
	}
}
