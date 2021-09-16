package pe.edu.upc.eatSafe.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ParkingReservations")
public class ParkingReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parking_reservation_id")
private Integer id;
	@ManyToOne
	@JoinColumn(name = "reservation_id",nullable = false)//Foreing Key
	private Reservation reservation;
	@ManyToOne
	@JoinColumn(name = "parking_id",nullable = false)//Foreing Key
	private Parking parking;
	public ParkingReservation(Integer id, Reservation reservation, Parking parking) {
		super();
		this.id = id;
		this.reservation = reservation;
		this.parking = parking;
	}
	
	public ParkingReservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public Parking getParking() {
		return parking;
	}
	public void setParking(Parking parking) {
		this.parking = parking;
	}
	
}
