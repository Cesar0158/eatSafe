package pe.edu.upc.eatSafe.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	private Integer id;
	
	@Column(name = "user_name", length = 30, nullable = false)
	private String name;
	
	@Column(name = "user_lastName", length = 30, nullable = false)
	private String lastName;
	
	@Column(name = "user_phone", length = 9, nullable = false)
	private String phone;
	
	@Column(name = "user_email", length = 30, nullable = false)
	private String email;
	
	@Column(name = "user_password", length = 60, nullable = false)
	private String password;
	
	private boolean enable;
	
	@OneToOne
	@MapsId 
	@JoinColumn(name="id")
	private Client client;
		
	@OneToOne
	@MapsId 
	@JoinColumn(name="id")
	private Admin admin;

	public User(Integer id, String name, String lastName, String phone, String email, String password, boolean enable,
			Client client, Admin admin) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.enable = enable;
		this.client = client;
		this.admin = admin;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
}
