package tn.Dari.Achat.Entities;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Sell_entity")

//@AttributeOverride(name = "Add_id", column = @Column(name="SellAd_id"))
//@AssociationOverride(
	//	name = "AdCustomrelation",
		//joinTable = @JoinTable(
			//	name="SellAdCustomrelation",
		      //  joinColumns=@JoinColumn(name="SellAdCustomrelation_id")

				//)
		//)

public class SellAd extends Ad {
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(updatable = false)
	//private Long id;

	private int prix;

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	

}
