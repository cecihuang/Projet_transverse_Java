package epsi.design_patterns.projetMangaCafe.domaine;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Evenement {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	@ManyToOne
	Animateur animateur;
	@OneToMany(mappedBy="evenement")
	Collection<ExemplaireEvent> events = new ArrayList<ExemplaireEvent>();
	@ManyToOne
	Client client;
	int nbPlace;
	String nom;
	Date dateFin;
	Date date;
	public SimpleDateFormat ft = new SimpleDateFormat ("dd/mm/yyyy hh:mm:ss");
	public boolean valide;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Collection<ExemplaireEvent> getEvents() {
		return events;
	}

	public void setEvents(Collection<ExemplaireEvent> events) {
		this.events = events;
	}
	public Evenement(){
		id=1;
		animateur = new Animateur();
		nom = "test";
		//date_evt.setTime();
		valide = false;
		nbPlace = 20;
	}

	public Animateur getAnimateur() {
		return animateur;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public Client getClient() {
		return client;
	}

	public void setAnimateur(Animateur animateur) {
		this.animateur = animateur;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public SimpleDateFormat getFt() {
		return ft;
	}

	public void setFt(SimpleDateFormat ft) {
		this.ft = ft;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

}
