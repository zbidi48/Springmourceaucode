package tn.Dari.Achat.EventListner;

import java.util.List;

import javax.persistence.PostPersist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import tn.Dari.Achat.Entities.Location;
import tn.Dari.Achat.Entities.SellAd;
import tn.Dari.Achat.Repositories.SellRepo;

//@Component
public class RunnableTask implements Runnable{

	@Autowired
	private SellRepo van;
	
	private int surface;
	private int nbrpieces;
	private String location;
	private int prixmin;
	private int prixmax;
	
	private boolean trouve;

	
	@Autowired
	private JavaMailSender JavaMailSender;
	
	List<SellAd> annatest;
	boolean locker=false;
	
	
	@PostPersist
	public void detectentity() {
		
		if (annatest == null) {
			trouve=false;
		}
		else {
			trouve=true;
		}
		
	}
	

	
	
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		
		int isurf=getSurface();
		int isnbrpiece =getNbrpieces();
		String isloca=getLocation();
		Location loc = null;
		loc.valueOf(isloca);
		int isprixmin=getPrixmin();
		int isprixmax=getPrixmax();
		
		annatest = van.findPrincipal(isurf, isnbrpiece, loc, isprixmin, isprixmax);
		
		detectentity();
		//Optional<Annonce> anna = van.findByNb1(ay);
		
		if (trouve == true && this.locker==false ) {System.out.println("annonce avec ces critères non trouvée");
		simpleMailMessage.setFrom("springprojet4se2@gmail.com");
		 simpleMailMessage.setTo("oussama.issaoui1@esprit.tn");
		 simpleMailMessage.setSubject("subjectTest");
		 simpleMailMessage.setText("l'annonce que vous cherchez dont le critère est "+ isurf + isnbrpiece+ 
				 isloca + isprixmin + isprixmax + " ont été trouvées" );
		 JavaMailSender.send(simpleMailMessage);
		 System.out.println("email envoyé");
		 this.locker=true;
		 
		}
		else 
			System.out.println("recherche annonce avec les critères");
	}
		








	public RunnableTask() {
		super();
	}
	
	







	public RunnableTask(int surface, int nbrpieces, String location, int prixmin, int prixmax) {
		super();
		this.surface = surface;
		this.nbrpieces = nbrpieces;
		this.location = location;
		this.prixmin = prixmin;
		this.prixmax = prixmax;
	}







	public int getSurface() {
		return surface;
	}







	public void setSurface(int surface) {
		this.surface = surface;
	}







	public int getNbrpieces() {
		return nbrpieces;
	}







	public void setNbrpieces(int nbrpieces) {
		this.nbrpieces = nbrpieces;
	}







	public String getLocation() {
		return location;
	}







	public void setLocation(String location) {
		this.location = location;
	}







	public int getPrixmin() {
		return prixmin;
	}







	public void setPrixmin(int prixmin) {
		this.prixmin = prixmin;
	}







	public int getPrixmax() {
		return prixmax;
	}







	public void setPrixmax(int prixmax) {
		this.prixmax = prixmax;
	}
	
	

}
