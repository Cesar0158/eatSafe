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
@Table(name = "Parkings")
public class Parking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parking_id")
	private Integer id;
	@Column(name = "parking_capacity", length = 40, nullable = false)
	private Integer capacity;
	@Column(name = "parking_address", length = 40, nullable = false)
	private String address;
	@OneToMany(mappedBy = "parking", fetch = FetchType.LAZY)
	private List<ParkingReservation> parkingReservations;

	public Parking(Integer id, Integer capacity, String address, List<ParkingReservation> parkingReservations) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.address = address;
		this.parkingReservations = parkingReservations;
	}

	public Parking() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<ParkingReservation> getParkingReservations() {
		return parkingReservations;
	}

	public void setParkingReservations(List<ParkingReservation> parkingReservations) {
		this.parkingReservations = parkingReservations;
	}

}
