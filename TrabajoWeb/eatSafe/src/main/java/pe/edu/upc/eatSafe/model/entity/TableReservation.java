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
@Table(name = "TableReservations")
public class TableReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "table_reservation_id", nullable = false)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "reservation_id",nullable = false)//Foreing Key
	private Reservation reservation;
	@ManyToOne
	@JoinColumn(name = "tables_id",nullable = false)//Foreing Key
	private Tables tables;
	public TableReservation(Integer id, Reservation reservation, Tables tables) {
		super();
		this.id = id;
		this.reservation = reservation;
		this.tables = tables;
	}
	
	public TableReservation() {
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
	public Tables getTables() {
		return tables;
	}
	public void setTables(Tables tables) {
		this.tables = tables;
	}
	
}
