package pe.edu.upc.eatSafe.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Clients")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private Integer id;
	@Column(name = "client_email", length = 30, nullable = false)
	private String email;
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Comment> opinions;
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Reservation> reservations;
	
	@OneToOne(mappedBy ="client")
	private User user;

	public Customer(Integer id, String email, List<Comment> opinions, List<Reservation> reservations, User user) {
		super();
		this.id = id;
		this.email = email;
		this.opinions = opinions;
		this.reservations = reservations;
		this.user = user;
	}

	public Customer() {
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

	public List<Comment> getOpinions() {
		return opinions;
	}

	public void setOpinions(List<Comment> opinions) {
		this.opinions = opinions;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
