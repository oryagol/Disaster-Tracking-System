package Model;

import java.io.Serializable;
import java.util.Calendar;

public class LostPerson implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String ImgURL;
	private Integer id;
	private Calendar missingReportDate;
	private Double Height;
	private Double Weight;
	private Finder foundedBy;
	private Searcher searchBy;
	private Calendar DateFound;
	private String discription;


	public LostPerson(Finder foundedBy) {
		super();
		this.foundedBy = foundedBy;
	}
	
	public LostPerson(Searcher searchBy) {
		super();
		this.searchBy = searchBy;
	}

	public LostPerson(String name, String imgURL, int id, Calendar missingReportDate
			, Double height, Double weight, Finder foundedBy, Searcher searcher ,String discription) {
		super();
		this.name = name;
		this.ImgURL = imgURL;
		this.id = id;
		this.missingReportDate = missingReportDate;
		Height = height;
		Weight = weight;
		this.foundedBy = foundedBy;
		this.searchBy = searcher;
		this.discription = discription;
		
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	public Calendar getDateFound() {
		return DateFound;
	}


	public void setDateFound(Calendar dateFound) {
		DateFound = dateFound;
	}


	public String getImgURL() {
		return ImgURL;
	}


	public void setImgURL(String imgURL) {
		ImgURL = imgURL;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Calendar getMissingReportDate() {
		return missingReportDate;
	}


	public void setMissingReportDate(Calendar missingReportDate) {
		this.missingReportDate = missingReportDate;
	}



	public double getHeight() {
		return Height;
	}


	public void setHeight(double height) {
		Height = height;
	}


	public double getWeight() {
		return Weight;
	}


	public void setWeight(double weight) {
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
		return "LostPerson [name=" + name + ", ImgURL=" + ImgURL + ", id=" + id + ", missingReportDate="
				+ missingReportDate + ", Height=" + Height + ", Weight=" + Weight + ", foundedBy=" + foundedBy
				+ ", searchBy=" + searchBy + ", DateFound=" + DateFound + ", discription=" + discription + "]";
	}

	public Searcher getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(Searcher searchBy) {
		this.searchBy = searchBy;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setHeight(Double height) {
		Height = height;
	}

	public void setWeight(Double weight) {
		Weight = weight;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	
	






}
