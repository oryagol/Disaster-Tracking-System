package Model;

import java.io.Serializable;
import java.util.Calendar;

public class LostPerson implements Serializable{

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
	private HairColor color;
	private Finder foundedBy;
	private Searcher searchBy;
	private Calendar DateFound;
	private Double matchPercent;
	private State state;


	public LostPerson(Finder foundedBy) {
		super();
		this.foundedBy = foundedBy;
	}
	
	public LostPerson(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public LostPerson(Searcher searchBy) {
		super();
		this.searchBy = searchBy;
	}

	public LostPerson(String name, String imgURL, int id, Calendar missingReportDate
			, Double height, Double weight,String color, Finder foundedBy, Searcher searcher) {
		super();
		this.name = name;
		this.ImgURL = imgURL;
		this.id = id;
		this.missingReportDate = missingReportDate;
		Height = height;
		Weight = weight;
		setColor(color);
		this.foundedBy = foundedBy;
		this.searchBy = searcher;
		
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
		return "LostPerson name=" + name;
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

	public HairColor getColor() {
		return color;
	}

	public void setColor(String color) {
		if(color.equals(HairColor.Blonde.toString()))
			this.color = HairColor.Blonde;
		else if(color.equals(HairColor.Brown.toString()))
			this.color = HairColor.Brown;
		else if(color.equals(HairColor.LightBlonde.toString()))
			this.color = HairColor.LightBlonde;
		else if(color.equals(HairColor.RedHead.toString()))
			this.color = HairColor.RedHead;
		else if(color.equals(HairColor.Dark.toString()))
			this.color = HairColor.Dark;
		else if(color.equals(HairColor.LightBrown.toString()))
			this.color = HairColor.LightBrown;
		else if(color.equals(HairColor.White.toString()))
			this.color = HairColor.White;
		else if(color.equals(HairColor.Other.toString()))
			this.color = HairColor.Other;
	}

	public Double getMatchPercent() {
		return matchPercent;
	}

	public void setMatchPercent(Double matchPercent) {
		this.matchPercent = matchPercent;
	}

	public State getState() {
		return state;
	}

	public void setState(String state) {
		if(state.equals(State.Alive))
			this.state = State.Alive;
		else if(state.equals(State.Dead))
			this.state = State.Dead;
		else
			this.state = State.Injured;
	}
	
	
	
	






}
