package Model;

public class Finder {
private String firstName;
private String lastName;
private String phone;
private String email;
private String id;

public Finder(String firstName, String lastName, String phone, String email, String id) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.phone = phone;
	this.email = email;
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
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

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}




}