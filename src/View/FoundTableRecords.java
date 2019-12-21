package View;

import java.util.Calendar;

import Model.Finder;
import Model.HairColor;

public class FoundTableRecords {
	private String Name;
	private Integer ID;
	private Double height;
	private Double weight;
	private String finderName;
	private String finderEmail;
	private String finderPhone;
	private String finderID;
	private String finderLocation;
	private String dateFound;
	private String hairColor;
	private String match;
	private String state;


	public FoundTableRecords(String name, Integer iD, Double height, Double weight, String finderName,
			Integer finderID, String finderEmail, String finderPhone,String finderLocation,
			Calendar dateFound, HairColor hairColor, Double match, String state) {
		super();
		
		if(name != null)
			Name = name;
		else 
			Name = "No Info";

		ID = iD;

		if(height!=null)
			this.height = height;
		else
			this.height=(double) -1;
		if(weight!=null)
			this.weight = weight;
		else
			this.weight=(double) -1;
		if(finderName!=null)		
			this.finderName =finderName ;
		else
			this.finderName = "no info";		
		if(finderEmail!=null)	
			this.finderEmail = finderEmail;
		else
			this.finderEmail = "no info";
		if(finderPhone!=null)	
			this.finderPhone = finderPhone;
		else
			this.finderPhone = "no info";
		this.finderID=String.valueOf(finderID);
		if(finderLocation!=null)	
			this.finderLocation=finderLocation;
		else
			this.finderLocation = "no info";
		this.dateFound = dateFound.get(Calendar.DAY_OF_MONTH)+"-"+dateFound.get(Calendar.MONTH)+"-"+dateFound.get(Calendar.YEAR);
		if(hairColor!=null)	
		this.hairColor = hairColor.toString();
		else
			this.hairColor = "no info";
		if(match != null)
			this.match = match.toString()+"%";
		else
			this.match = "";
		this.state = state;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}


	public Double getHeight() {
		return height;
	}


	public void setHeight(Double height) {
		this.height = height;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}





	public String getFinderName() {
		return finderName;
	}


	public void setFinderName(String finderName) {
		this.finderName = finderName;
	}


	public String getFinderEmail() {
		return finderEmail;
	}


	public void setFinderEmail(String finderEmail) {
		this.finderEmail = finderEmail;
	}


	public String getFinderPhone() {
		return finderPhone;
	}


	public void setFinderPhone(String finderPhone) {
		this.finderPhone = finderPhone;
	}


	public String getFinderID() {
		return finderID;
	}


	public void setFinderID(String finderID) {
		this.finderID = finderID;
	}


	public String getFinderLocation() {
		return finderLocation;
	}


	public void setFinderLocation(String finderLocation) {
		this.finderLocation = finderLocation;
	}


	public String getFinderLocation(String finderLocation) {
		return finderLocation;
	}

	public String getDateFound() {
		return dateFound;
	}


	public void setDateFound(String dateFound) {
		this.dateFound = dateFound;
	}


	public String getHairColor() {
		return hairColor;
	}


	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	

	public String getMatch() {
		return match;
	}


	public void setMatch(String match) {
		this.match = match;
	}


	@Override
	public String toString() {
		return "FoundTableRecords [finderLocation=" + finderLocation + ", hairColor=" + hairColor + "]";
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	

}
