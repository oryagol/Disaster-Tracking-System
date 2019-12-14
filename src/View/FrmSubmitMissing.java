package View;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Calendar;

import Model.LostPerson;
import Model.Searcher;
import Model.SysData;
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
	    private TextArea discription;

	    @FXML
	    private Button submit;

	    @FXML
	    private Button upload;

	    @FXML
	    private TextField height;

	    @FXML
	    private TextField weight;

	    final FileChooser fileChooser = new FileChooser();

	    private File image;
	
	// get the details of form and submit to system
	// need to add -> check that input is valid
	@FXML
	void submit(ActionEvent event) {
		String name = missFirstName.getText()+" "+missLastName.getText();
		int id = Integer.parseInt(missID.getText());
		String dis = discription.getText();
		String sName = searchFirstName.getText()+" "+searchLastName.getText();
		int sId = Integer.parseInt(searchID.getText());
		String sEmail = searchEmail.getText();
		String sPhone = searchPhone.getText();
		Double h = Double.parseDouble(height.getText());
		Double w = Double.parseDouble(weight.getText());
		Calendar d = Calendar.getInstance();
		String imgURL = "src/View/Photos/"+id;
		if(image != null)
		{
			File toFile = new File(imgURL);
			try {
				java.nio.file.Files.move(image.toPath(), toFile.toPath() ,StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		Searcher s = new Searcher(sName, sPhone, sEmail, sId);
		LostPerson lp = new LostPerson(name, imgURL, id, d, h, w, null,s, dis);
		lp.setSearchBy(s);
		SysData.addMissingForm(lp);
	}
	
	//upload the photo to the system
	@FXML
	void upload(ActionEvent event) {
		image = fileChooser.showOpenDialog(MainView.stage);
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif") );
	}
}
