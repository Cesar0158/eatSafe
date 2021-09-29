package pe.edu.upc.eatSafe.model.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private Integer id;
	
	@Column(name = "reservation_date")
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne
	@JoinColumn(name = "client_id",nullable = false)//Foreing Key
	private Customer client;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id",nullable = false)//Foreing Key
	private Restaurant restaurant;
	@OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY)
	private List<ParkingReservation> parkingReservations;
	@OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY)
	private List<TableReservation> tableReservations;
	public Reservation(Integer id, Date date, Customer client, Restaurant restaurant,
			List<ParkingReservation> parkingReservations, List<TableReservation> tableReservations) {
		super();
		this.id = id;
		this.date = date;
		this.client = client;
		this.restaurant = restaurant;
		this.parkingReservations = parkingReservations;
		this.tableReservations = tableReservations;
	}
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Customer getClient() {
		return client;
	}
	public void setClient(Customer client) {
		this.client = client;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public List<ParkingReservation> getParkingReservations() {
		return parkingReservations;
	}
	public void setParkingReservations(List<ParkingReservation> parkingReservations) {
		this.parkingReservations = parkingReservations;
	}
	public List<TableReservation> getTableReservations() {
		return tableReservations;
	}
	public void setTableReservations(List<TableReservation> tableReservations) {
		this.tableReservations = tableReservations;
	}

}
