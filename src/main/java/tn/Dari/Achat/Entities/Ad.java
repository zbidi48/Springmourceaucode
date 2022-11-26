package tn.Dari.Achat.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


//@JsonIdentityInfo(generator= ObjectIdGenerators.PropretyGenerator.Class, property="id")
//au lieu de @JsonBackReference + JsonManagedReference pour l'infinite recursion 
//@MappedSuperclass

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Ad implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE) // auto no marche pas etant une classe abstraire with inhertiance
	@Column(name = "Add_id",insertable=false, updatable=false)
	protected Long id;
	
	@Column(name = "title", length = 100, nullable = false)
	protected String title;
	
	
	// verifier si length fonctionne pour type int car par défaut pour string !!!!!!!!
	@Column(name = "phoneNumber", length = 8, nullable = false) 
	protected int phoneNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	protected Date date ; // a verifier !!!! ( ajout ne constructeur pour date
	
	protected Boolean favorite;
	
	protected int viewsNumber; 
	
	//methode pour le filtre pour augmenter viewsNumber
	public void IncreVNumber() {
		viewsNumber++;
	}
	
	protected String description;
	
	protected int surface;
	protected int nbrPieces;
	protected int Prixm2;
	protected int prixEstim;
	
	public int getPrixEstim() {
		return prixEstim;
	}


	public void setPrixEstim(int prixEstim) {
		this.prixEstim = prixEstim;
	}


	@PrePersist
	void FixPrixEstime() {
		
		String inter = getAdresse().getLocation().label;
		int estim = Integer.parseInt(inter);
		setPrixm2(estim);
		
		Estimer();
	}
	
	
	void Estimer () {
		
		int iterim = getPrixm2();
	int pieceestim = getNbrPieces();
	 if (pieceestim>2) {iterim= iterim*2;};
	 int surfestim=getSurface();
	 if (surfestim>=150) {iterim= iterim*2*surfestim;};
	 boolean critpiscine = getAutresCriteres().isGarage();
	 if (critpiscine=true) {iterim=iterim*3;};
	 setPrixEstim(iterim);
		
	}
	
	@Embedded
	protected adresse adresse;
	
	@Embedded
	protected autresCriteres autresCriteres;
	
	@OneToMany(mappedBy = "ad",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	protected Set<comment>comments;  // verifier l'ajour de newHashSet !!!!!!!! 
	
	public void addcomment (comment comment) {
		comments.add(comment);
	}
	
	@OneToMany(mappedBy = "ad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	protected Set<Claim> claims;
	
	@OneToMany(mappedBy = "ad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	protected Set<Appointement> appointements ;
	
	@OneToMany(mappedBy = "ad", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	protected Set<imgDesc> imgdesc;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	protected testCustomer AdCustomrelation;
	
	

	public Ad(String title, int phoneNumber, Date date, Boolean favorite, int viewsNumber, String description,
			int surface, int nbrPieces, tn.Dari.Achat.Entities.adresse adresse, Set<comment> comments,
			Set<Claim> claims, Set<Appointement> appointements, Set<imgDesc> imgdesc,
			tn.Dari.Achat.Entities.testCustomer testCustomer) {
		this.title = title;
		this.phoneNumber = phoneNumber;
		this.date = date;
		this.favorite = favorite;
		this.viewsNumber = viewsNumber;
		this.description = description;
		this.surface = surface;
		this.nbrPieces = nbrPieces;
		this.adresse = adresse;
		this.comments = comments;
		this.claims = claims;
		this.appointements = appointements;
		this.imgdesc = imgdesc;
		this.AdCustomrelation = AdCustomrelation;
	}
	

	public Ad() {
		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

	public int getViewsNumber() {
		return viewsNumber;
	}

	public void setViewsNumber(int viewsNumber) {
		this.viewsNumber = viewsNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public int getNbrPieces() {
		return nbrPieces;
	}

	public void setNbrPieces(int nbrPieces) {
		this.nbrPieces = nbrPieces;
	}

	public adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(adresse adresse) {
		this.adresse = adresse;
	}

	public Set<comment> getComments() {
		return comments;
	}

	public void setComments(Set<comment> comments) {
		this.comments = comments;
	}

	public Set<Claim> getClaims() {
		return claims;
	}

	public void setClaims(Set<Claim> claims) {
		this.claims = claims;
	}

	public Set<Appointement> getAppointements() {
		return appointements;
	}

	public void setAppointements(Set<Appointement> appointements) {
		this.appointements = appointements;
	}

	public Set<imgDesc> getImgdesc() {
		return imgdesc;
	}

	public void setImgdesc(Set<imgDesc> imgdesc) {
		this.imgdesc = imgdesc;
	}

	public testCustomer getTestCustomer() {
		return AdCustomrelation;
	}

	public void setTestCustomer(testCustomer testCustomer) {
		this.AdCustomrelation = testCustomer;
	}

	
	public autresCriteres getAutresCriteres() {
		return autresCriteres;
	}


	public void setAutresCriteres(autresCriteres autresCriteres) {
		this.autresCriteres = autresCriteres;
	}


	public testCustomer getAdCustomrelation() {
		return AdCustomrelation;
	}


	public void setAdCustomrelation(testCustomer adCustomrelation) {
		AdCustomrelation = adCustomrelation;
	}


	@Override
	public String toString() {
		return "Ad [id=" + id + ", title=" + title + ", phoneNumber=" + phoneNumber + ", date=" + date + ", favorite="
				+ favorite + ", viewsNumber=" + viewsNumber + ", description=" + description + ", surface=" + surface
				+ ", nbrPieces=" + nbrPieces + ", adresse=" + adresse + ", autresCriteres=" + autresCriteres
				+ ", comments=" + comments + ", claims=" + claims + ", appointements=" + appointements + ", imgdesc="
				+ imgdesc + ", AdCustomrelation=" + AdCustomrelation + "]";
	}


	public int getPrixm2() {
		return Prixm2;
	}


	public void setPrixm2(int prixm2) {
		Prixm2 = prixm2;
	}


	

	
	
	
	
	
	

}
