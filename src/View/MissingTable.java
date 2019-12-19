package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.ResourceBundle;

import Model.Finder;
import Model.LostPerson;
import Model.Searcher;
import Model.SysData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MissingTable implements Initializable{
	

		@FXML
    	private TableView<MissingTableRecord> table;
	
	  @FXML
	    private TableColumn<MissingTableRecord, String> fName;

	    @FXML
	    private TableColumn<MissingTableRecord, Integer> ID;

	    @FXML
	    private TableColumn<MissingTableRecord, Double> height;

	    @FXML
	    private TableColumn<MissingTableRecord, Double> weight;

	    @FXML
	    private TableColumn<MissingTableRecord, String> photo;

	    @FXML
	    private TableColumn<MissingTableRecord, String> sFName;

	    @FXML
	    private TableColumn<MissingTableRecord, String> sEmail;

	    @FXML
	    private TableColumn<MissingTableRecord, String> sPhone;

	    @FXML
	    private TableColumn<MissingTableRecord, String> date;

	    @FXML
	    private TableColumn<MissingTableRecord, String> found;

	    @FXML
	    private TableColumn<MissingTableRecord, String> dateFound;
	    
	    @FXML
	    private TableColumn<MissingTableRecord, String> hairColor;
	    
	    @FXML
	    private TableColumn<MissingTableRecord, String> match;
	    
	    private ArrayList<MissingTableRecord> records = new ArrayList<>();
	    
	    private ObservableList<MissingTableRecord> lostList = FXCollections.observableArrayList();
    
	    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			setList();
			//Connect Cell To Object
			fName.setCellValueFactory(new PropertyValueFactory<MissingTableRecord, String>("Name"));
			ID.setCellValueFactory(new PropertyValueFactory<MissingTableRecord, Integer>("ID"));
			height.setCellValueFactory(new PropertyValueFactory<MissingTableRecord, Double>("height"));
			weight.setCellValueFactory(new PropertyValueFactory<MissingTableRecord, Double>("Weight"));
			photo.setCellValueFactory(new PropertyValueFactory<MissingTableRecord, String>("photo"));
			sFName.setCellValueFactory(new PropertyValueFactory<MissingTableRecord, String>("searchName"));
			sEmail.setCellValueFactory(new PropertyValueFactory<MissingTableRecord, String>("searchEmail"));
			sPhone.setCellValueFactory(new PropertyValueFactory<MissingTableRecord, String>("searchPhone"));
			date.setCellValueFactory(new PropertyValueFactory<MissingTableRecord, String>("submitDate"));
			found.setCellValueFactory(new PropertyValueFactory<MissingTableRecord, String>("foundPerson"));
			dateFound.setCellValueFactory(new PropertyValueFactory<MissingTableRecord, String>("dateFound"));
			hairColor.setCellValueFactory(new PropertyValueFactory<MissingTableRecord, String>("hairColor"));
			match.setCellValueFactory(new PropertyValueFactory<MissingTableRecord, String>("match"));
			
			
			table.setItems(lostList);
		}
	
	// setting the list to initialize the table
	public void setList() {

		for(LostPerson lp : SysData.getInstance().getMissingSearched()) {
			records.add(new MissingTableRecord(lp.getName(), lp.getId(), lp.getHeight(), lp.getWeight(), lp.getImgURL(),
					lp.getSearchBy().getName(), lp.getSearchBy().getId(),
					lp.getSearchBy().getEmail(), lp.getSearchBy().getPhone(),
					lp.getFoundedBy(), lp.getDateFound(), lp.getColor(), lp.getMatchPercent()));
		}
		lostList.addAll(records);
	}
}
