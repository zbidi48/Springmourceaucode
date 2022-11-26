package tn.Dari.Achat.Entities;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Rent_entity")


@AttributeOverride(name = "Add_id", column = @Column(name="RentAd_id"))
//@AssociationOverride(
	//	name = "AdCustomrelation",
		//joinTable = @JoinTable(
			//	name="RentAdCustomrelation",
		      //  joinColumns=@JoinColumn(name="RentAdCustomrelation_id")

				//)
		//)
public class RentAd extends Ad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	private Long id;

	private int loyer;
	
	@Enumerated(value = EnumType.STRING)
	private type_location typeLocation;
}
