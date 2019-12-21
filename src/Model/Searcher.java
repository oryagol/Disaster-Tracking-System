package Model;

import java.io.Serializable;

public class Searcher implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Name;
	private String Phone;
	private String Email;
	private Integer id;
	private LostPerson searchPerson;
	
	
	
	public Searcher(String name, String phone, String email, Integer id, LostPerson searchPerson) {
		super();
		Name = name;
		Phone = phone;
		Email = email;
		this.id = id;
		this.searchPerson = searchPerson;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LostPerson getSearchPerson() {
		return searchPerson;
	}
	public void setSearchPerson(LostPerson searchPerson) {
		this.searchPerson = searchPerson;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Searcher [Name=" + Name + ", Phone=" + Phone + ", Email=" + Email + ", id=" + id + "]";
	}
	
	
	
	
}
