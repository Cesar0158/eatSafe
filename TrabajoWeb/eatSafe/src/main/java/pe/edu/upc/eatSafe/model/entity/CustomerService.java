package pe.edu.upc.eatSafe.model.entity;

public class CustomerService {
private Integer id;
private String email;



public CustomerService(Integer id, String email) {
	super();
	this.id = id;
	this.email = email;
}



public CustomerService() {
	super();
	// TODO Auto-generated constructor stub
}



public Integer getId() {
	return id;
}



public void setId(Integer id) {
	this.id = id;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}


}
