package pe.edu.upc.eatSafe.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="opinions")
public class Opinion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "opinion_id")
private Integer id;
	@Column(name = "opinion_qualification",length = 2,nullable=false)
private Integer qualification;
	@Column(name = "opinion_comment", length = 60)
private String comment;
	
private Client client;
private Restaurant restaurant;
}
