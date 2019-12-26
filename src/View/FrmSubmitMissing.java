package View;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Model.HairColor;
import Model.JSONHandler;
import Model.LostPerson;
import Model.Searcher;
import Model.SysData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;

public class FrmSubmitMissing implements Initializable {

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
    private ComboBox<String> hairColor;

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
		String sName = searchFirstName.getText()+" "+searchLastName.getText();
		int sId = Integer.parseInt(searchID.getText());
		String sEmail = searchEmail.getText();
		String sPhone = searchPhone.getText();
		Double h = Double.parseDouble(height.getText());
		Double w = Double.parseDouble(weight.getText());
		String color = hairColor.getValue();
		Calendar d = Calendar.getInstance();
		String imgURL = "src/View/Photos/"+id+".jpg";
		Searcher s = new Searcher(sName, sPhone, sEmail, sId, null);
		LostPerson lp = new LostPerson(name, imgURL, id, d, h, w,color, null,s);
		s.setSearchPerson(lp);
		lp.setSearchBy(s);
		Alert al = new Alert(Alert.AlertType.CONFIRMATION);
		al.setHeaderText("Are You Sure You Finished The Form?");
		al.setTitle("System Messege");
		al.setResizable(false);
		Optional<ButtonType> result = al.showAndWait();
		if(result.get() == ButtonType.OK) {
			System.out.println(lp);
			SysData.getInstance().addMissingForm(lp);
			JSONHandler j = new JSONHandler();
			SysData.getInstance().saveDataBase(j.getPath()+"MPADdatabase.ser");
			emptyFields();
			if(image != null)
			{
				File toFile = new File(j.getPath()+imgURL);
				try {
					java.nio.file.Files.copy(image.toPath(), toFile.toPath() ,StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	//upload the photo to the system
	@FXML
	void upload(ActionEvent event) {
		image = fileChooser.showOpenDialog(MainView.stage);
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif") );
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<String> colors = Stream.of(HairColor.values())
                .map(HairColor::name)
                .collect(Collectors.toList());
		ObservableList<String> colorsToShow = FXCollections.observableArrayList();
		colorsToShow.addAll(colors);
		hairColor.setItems(colorsToShow);
		
	}
	
	public void emptyFields() {
		missFirstName.clear();
		missLastName.clear();
		missID.clear();
		searchEmail.clear();
		searchFirstName.clear();
		searchLastName.clear();
		searchID.clear();
		searchPhone.clear();
		height.clear();
		weight.clear();
		
	}
}
