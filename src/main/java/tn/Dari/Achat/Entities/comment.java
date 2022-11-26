package tn.Dari.Achat.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

//@ToString

@Table(name="commentaire")
public class comment {


	public comment(String description, int numberLikes, boolean modif) {
		super();
		this.description = description;
		this.numberLikes = numberLikes;
		this.modif = modif;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	
	@Column(name = "description", updatable = true, nullable = true)
	private String description;
	private int numberLikes;
	
	@Column(updatable = true)
	private boolean modif;

	@ManyToOne
	@JoinColumn(name = "Ad_id")
	private Ad ad;

	public comment(Long id, String description, int numberLikes, boolean modif, Ad ad) {
		super();
			this.id = id;
		this.description = description;
		this.numberLikes = numberLikes;
		this.modif = modif;
		this.ad = ad;
	}

	public comment() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberLikes() {
		return numberLikes;
	}

	public void setNumberLikes(int numberLikes) {
		this.numberLikes = numberLikes;
	}

	public boolean isModif() {
		return modif;
	}

	public void setModif(boolean modif) {
		this.modif = modif;
	}

	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

	@Override
	public String toString() {
		return "comment [id=" + id + ", description=" + description + ", numberLikes=" + numberLikes + ", modif="
				+ modif + ", ad=" + ad + "]";
	}
	
	//@PostPersist
	//public void prepers() {
		//if (this.id>0) {this.modif=true;}
	//}
	
	
	
	
	
	}
