package pe.edu.upc.eatSafe.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Restaurants")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id", nullable = false)
	private Integer id;
	@Column(name = "restaurant_name", length = 40,nullable = false)
	private String name;
	@Column(name = "restaurant_address", length = 40,nullable = false)
	private String address;
	@Column(name = "restaurant_capacity", length = 40,nullable = false)
	private Integer capacity;
	@Column(name = "restaurant_parking", length = 40,nullable = false)
	private String parking;
	@Column(name = "restaurant_phone", length = 40,nullable = false)
	private Integer phone;
}
