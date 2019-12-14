package Model;

public class Searcher {
	private String Name;
	private String Phone;
	private String Email;
	private Integer id;
	
	
	
	public Searcher(String name, String phone, String email, Integer id) {
		super();
		Name = name;
		Phone = phone;
		Email = email;
		this.id = id;
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
	
	
	
}
