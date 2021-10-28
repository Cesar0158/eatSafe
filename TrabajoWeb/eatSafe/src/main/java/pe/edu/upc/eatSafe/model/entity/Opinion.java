/*package pe.edu.upc.eatSafe.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Opinions",indexes = { @Index(columnList = "opinion_comment", name = "opinions_index_last_first_name") })
@SequenceGenerator(name = "Opinionss_opinion_id_seq", initialValue = 1, allocationSize = 1)

public class Opinion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Opinions_opinion_id_seq")
	@Column(name = "opinion_id")
	private Integer id;
	@Column(name = "opinion_qualification", length = 2, nullable = false)
	private Integer qualification;
	@Column(name = "opinion_comment", length = 60)
	private String comment;
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false) // Foreing Key
	private Client client;
	@ManyToOne
	@JoinColumn(name = "restaurant_id", nullable = false) // Foreing Key
	private Restaurant restaurant;

	public Opinion(Integer id, Integer qualification, String comment, Client client, Restaurant restaurant) {
		super();
		this.id = id;
		this.qualification = qualification;
		this.comment = comment;
		this.client = client;
		this.restaurant = restaurant;
	}

	public Opinion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQualification() {
		return qualification;
	}

	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}*/
