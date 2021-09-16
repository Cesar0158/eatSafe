package pe.edu.upc.eatSafe.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Tables")
public class Tables {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tables_id", nullable = false)
	private Integer id;
	@Column(name = "tables_capacity", length = 40,nullable = false)
	private Integer capacity;
	@ManyToOne
	@JoinColumn(name = "restaurant_id",nullable = false)//Foreing Key
	private Restaurant restaurant;
	@OneToMany(mappedBy = "tables", fetch = FetchType.LAZY)
	private List<TableReservation> tableReservations;
	public Tables(Integer id, Integer capacity, Restaurant restaurant, List<TableReservation> tableReservations) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.restaurant = restaurant;
		this.tableReservations = tableReservations;
	}
	
	public Tables() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public List<TableReservation> getTableReservations() {
		return tableReservations;
	}
	public void setTableReservations(List<TableReservation> tableReservations) {
		this.tableReservations = tableReservations;
	}
	
}
