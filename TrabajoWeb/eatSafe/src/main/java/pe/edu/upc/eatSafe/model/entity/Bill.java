package pe.edu.upc.eatSafe.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "bills")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_id")
private Integer id;
	@Column(name = "bill_type", length = 20,nullable = false)
private String type;
	
	@Column(name = "bill_date")
	@Temporal(TemporalType.DATE)
private Date date;
}
