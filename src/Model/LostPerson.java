package Model;

import java.util.Calendar;

public class LostPerson {
	private String firstName;
	private String LastName;
	private String Phone;
	private String Email;
	private String ImgURL;
	private String id;
	private Calendar missingReportDate;
	private String additionalInfo;
	private String Height;
	private String Weight;
	private Finder foundedBy;
	private Calendar DateFound;
	
	
	public LostPerson(Finder foundedBy) {
		super();
		this.foundedBy = foundedBy;
	}


	public LostPerson(String name, String phone, String email, String imgURL, String id, Calendar missingReportDate,
			String additionalInfo, String height, String weight, Finder foundedBy) {
		super();
		firstName = name;
		Phone = phone;
		Email = email;
		ImgURL = imgURL;
		this.id = id;
		this.missingReportDate = missingReportDate;
		this.additionalInfo = additionalInfo;
		Height = height;
		Weight = weight;
		this.foundedBy = foundedBy;
	}


	public String getName() {
		return firstName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public Calendar getDateFound() {
		return DateFound;
	}


	public void setDateFound(Calendar dateFound) {
		DateFound = dateFound;
	}


	public void setName(String name) {
		firstName = name;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getImgURL() {
		return ImgURL;
	}


	public void setImgURL(String imgURL) {
		ImgURL = imgURL;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Calendar getMissingReportDate() {
		return missingReportDate;
	}


	public void setMissingReportDate(Calendar missingReportDate) {
		this.missingReportDate = missingReportDate;
	}


	public String getAdditionalInfo() {
		return additionalInfo;
	}


	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}


	public String getHeight() {
		return Height;
	}


	public void setHeight(String height) {
		Height = height;
	}


	public String getWeight() {
		return Weight;
	}


	public void setWeight(String weight) {
		Weight = weight;
	}


	public Finder getFoundedBy() {
		return foundedBy;
	}


	public void setFoundedBy(Finder foundedBy) {
		this.foundedBy = foundedBy;
	}


	@Override
	public String toString() {
		return "LostPerson [firstName=" + firstName + ", LastName=" + LastName + ", Phone=" + Phone + ", Email=" + Email
				+ ", ImgURL=" + ImgURL + ", id=" + id + ", missingReportDate=" + missingReportDate + ", additionalInfo="
				+ additionalInfo + ", Height=" + Height + ", Weight=" + Weight + ", foundedBy=" + foundedBy
				+ ", DateFound=" + DateFound + "]";
	}
	
	
	
	
	
	
	
}
