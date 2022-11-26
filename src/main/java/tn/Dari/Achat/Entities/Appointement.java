package tn.Dari.Achat.Entities;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Appointement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appoint_id", updatable = false)
	private Long id;
	
	@Column(name = "message", length = 300, nullable = true)
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	
	@ManyToOne //(targetEntity = Ad.class)
	@JoinColumn(name = "Appointement_id")
	private Ad ad;

}
