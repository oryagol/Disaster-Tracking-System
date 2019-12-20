package Model;

import java.io.Serializable;

public class Finder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String phone;
	private String email;
	private Integer id;
	private String location;
	private LostPerson foundPerson;

	public Finder(String name, String phone, String email, int id, String location, LostPerson foundPerson) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.id = id;
		this.location = location;
		this.foundPerson = foundPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LostPerson getFoundPerson() {
		return foundPerson;
	}

	public void setFoundPerson(LostPerson foundPerson) {
		this.foundPerson = foundPerson;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	


}