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
@Table(name="payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
private Integer id;
	
	@Column(name = "payment_date")
	@Temporal(TemporalType.DATE)
private Date paymentDate;
	
	@Column(name = "payment_amount", length = 40,nullable = false)
private String amount;
}
