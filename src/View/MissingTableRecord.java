package View;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import Model.Finder;
import Model.HairColor;
import javafx.scene.control.Hyperlink;

// a class that describe a record in the missing person table
public class MissingTableRecord {
		
		private String Name;
		private Integer ID;
		private Double height;
		private Double weight;
		private Hyperlink photo;
		private String searchName;
		private String searchEmail;
		private String searchPhone;
		private String submitDate;
		private String foundPerson;
		private String dateFound;
		private String hairColor;
		private String match;
		
		
		public MissingTableRecord(String name, Integer iD, Double height, Double weight,String photoURL, String searchName,
				Integer searchID, String searchEmail, String searchPhone,  Finder foundPerson,
				Calendar dateFound, HairColor hairColor, Double match) {
			super();
			Name = name;
			ID = iD;
			this.height = height;
			this.weight = weight;
			this.photo = new Hyperlink("photo");
			photo.setOnAction(evt -> {
	            File file = new File(photoURL+".jpg");
	            Desktop desktop = Desktop.getDesktop();
	            if(file.exists())
					try {
						desktop.open(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        });
			this.searchName = searchName;
			this.searchEmail = searchEmail;
			this.searchPhone = searchPhone;
			Calendar cal = Calendar.getInstance();
			this.submitDate = cal.get(Calendar.DAY_OF_MONTH)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.YEAR);
			if(foundPerson != null)
				this.foundPerson = foundPerson.getName();
			else
				this.foundPerson = "";
			if(dateFound != null)
				this.dateFound = dateFound.get(Calendar.DAY_OF_MONTH)+"-"+(dateFound.get(Calendar.MONTH)+1)+"-"+dateFound.get(Calendar.YEAR);
			else
				this.dateFound = "";
			this.hairColor = hairColor.toString();
			this.match = match.toString()+"%";
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
		public String getSearchName() {
			return searchName;
		}
		public void setSearchName(String searchName) {
			this.searchName = searchName;
		}
		public String getSearchEmail() {
			return searchEmail;
		}
		public void setSearchEmail(String searchEmail) {
			this.searchEmail = searchEmail;
		}
		public String getSearchPhone() {
			return searchPhone;
		}
		public void setSearchPhone(String searchPhone) {
			this.searchPhone = searchPhone;
		}
		public String getSubmitDate() {
			return submitDate;
		}
		public void setSubmitDate(String submitDate) {
			this.submitDate = submitDate;
		}
		public String getFoundPerson() {
			return foundPerson;
		}
		public void setFoundPerson(String foundPerson) {
			this.foundPerson = foundPerson;
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
		public Hyperlink getPhoto() {
			return photo;
		}
		public void setPhoto(Hyperlink photo) {
			this.photo = photo;
		}
		
		
		
		
}
