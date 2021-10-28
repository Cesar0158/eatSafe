package pe.edu.upc.eatSafe.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Restaurants",indexes = { @Index(columnList = "restaurant_name, restaurant_address", name = "restaurants_index_last_first_name") })
@SequenceGenerator(name = "Restaurants_restaurant_id_seq", initialValue = 1, allocationSize = 1)

public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Restaurants_restaurant_id_seq")
	@Column(name = "restaurant_id", columnDefinition = "NUMERIC(6)")
	private Integer id;
	
	@NotNull(message= "El name debe contener un valor")
	@NotBlank(message= "El name debe contener datos")
	@Size(max = 40, message = "Maximo 40 caracteres")
	@Column(name = "restaurant_name", length = 40)
	private String name;
	@NotNull(message= "El address debe contener un valor")
	@NotBlank(message= "El address debe contener datos")
	@Size(max = 40, message = "Maximo 40 caracteres")
	@Column(name = "restaurant_address", length = 40)
	private String address;
	@NotNull(message= "La capacity debe contener un valor")
	@NotBlank(message= "La capacity debe contener datos")
	@Size(max = 40, message = "Maximo 40 caracteres")
	@Column(name = "restaurant_capacity", length = 40)
	private Integer capacity;
	@NotNull(message= "El phone debe contener un valor")
	@NotBlank(message= "El phone debe contener datos")
	@Size(max = 40, message = "Maximo 9 caracteres")
	@Column(name = "restaurant_phone", length = 9)
	private String phone;
		
	/*@OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
	private List<Opinion> opinions;*/
	@OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
	private List<Tables> tables;
	public Restaurant(Integer id, String name, String address, Integer capacity, String phone/*, List<Opinion> opinions*/,
			List<Tables> tables) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.capacity = capacity;
		this.phone = phone;
	/*	this.opinions = opinions;*/
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
	
	/*public List<Opinion> getOpinions() {
		return opinions;
	}
	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}*/
	public List<Tables> getTables() {
		return tables;
	}
	public void setTables(List<Tables> tables) {
		this.tables = tables;
	}
	

	
	
}
