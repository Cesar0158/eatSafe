package pe.edu.upc.eatSafe.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Restaurants")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id", nullable = false)
	private Integer id;
	@Column(name = "restaurant_name", length = 40, nullable = false)
	private String name;
	@Column(name = "restaurant_address", length = 40, nullable = false)
	private String address;
	@Column(name = "restaurant_capacity", length = 40, nullable = false)
	private Integer capacity;
	@Column(name = "restaurant_phone", length = 9, nullable = false)
	private String phone;
		
	@OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
	private List<Comment> opinions;
	@OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
	private List<Tables> tables;
	public Restaurant(Integer id, String name, String address, Integer capacity, String phone, List<Comment> opinions,
			List<Tables> tables) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.capacity = capacity;
		this.phone = phone;
		this.opinions = opinions;
		this.tables = tables;
	}
	public Restaurant() {
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public List<Comment> getOpinions() {
		return opinions;
	}
	public void setOpinions(List<Comment> opinions) {
		this.opinions = opinions;
	}
	public List<Tables> getTables() {
		return tables;
	}
	public void setTables(List<Tables> tables) {
		this.tables = tables;
	}
	

	
	
}
