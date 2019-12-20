package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.LostPerson;
import Model.SysData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FoundTable implements Initializable {

	@FXML
	private TableView<FoundTableRecords> table;

  @FXML
    private TableColumn<FoundTableRecords, String> fName;

    @FXML
    private TableColumn<FoundTableRecords, Integer> ID;

    @FXML
    private TableColumn<FoundTableRecords, Double> height;

    @FXML
    private TableColumn<FoundTableRecords, Double> weight;

    @FXML
    private TableColumn<FoundTableRecords, String> hairColor;
    @FXML
    private TableColumn<FoundTableRecords, String> loca;

    @FXML
    private TableColumn<FoundTableRecords, String> fFName;

    @FXML
    private TableColumn<FoundTableRecords, String> fEmail;

    @FXML
    private TableColumn<FoundTableRecords, String> fPhone;

    @FXML
    private TableColumn<FoundTableRecords, String> date;

    @FXML
    private TableColumn<FoundTableRecords, String> match;

    @FXML
    private TableColumn<FoundTableRecords, String> state;
    
   
    
   
    
    private ArrayList<FoundTableRecords> records = new ArrayList<>();
    
    private ObservableList<FoundTableRecords> lostList = FXCollections.observableArrayList();
    
    
    public void initialize(URL arg0, ResourceBundle arg1) {
		setList();
		//Connect Cell To Object
		fName.setCellValueFactory(new PropertyValueFactory<FoundTableRecords, String>("Name"));
		ID.setCellValueFactory(new PropertyValueFactory<FoundTableRecords, Integer>("ID"));
		height.setCellValueFactory(new PropertyValueFactory<FoundTableRecords, Double>("height"));
		weight.setCellValueFactory(new PropertyValueFactory<FoundTableRecords, Double>("Weight"));
		fFName.setCellValueFactory(new PropertyValueFactory<FoundTableRecords, String>("finderName"));
		fEmail.setCellValueFactory(new PropertyValueFactory<FoundTableRecords, String>("finderEmail"));
		fPhone.setCellValueFactory(new PropertyValueFactory<FoundTableRecords, String>("finderPhone"));
		loca.setCellValueFactory(new PropertyValueFactory<FoundTableRecords, String>("finderLocation"));
		date.setCellValueFactory(new PropertyValueFactory<FoundTableRecords, String>("dateFound"));
		hairColor.setCellValueFactory(new PropertyValueFactory<FoundTableRecords, String>("hairColor"));
		match.setCellValueFactory(new PropertyValueFactory<FoundTableRecords, String>("match"));
		
		
		table.setItems(lostList);
	}

// setting the list to initialize the table
public void setList() {
	System.out.println(SysData.getInstance().getImportedmissing().get(0).getFoundedBy().getLocation());
	System.out.println(SysData.getInstance().getImportedmissing().get(0).getFoundedBy().getLocation());

	for(LostPerson lp : SysData.getInstance().getImportedmissing()) {


		records.add(new FoundTableRecords(lp.getName(), lp.getId(), lp.getHeight(), lp.getWeight(), lp.getFoundedBy().getName(),
				lp.getFoundedBy().getId(), lp.getFoundedBy().getEmail(),
				lp.getFoundedBy().getPhone(), lp.getFoundedBy().getLocation(),
			    lp.getDateFound(), lp.getColor(), lp.getMatchPercent()));
		

	}
	
	lostList.addAll(records);
	System.out.println(records);
}
}
