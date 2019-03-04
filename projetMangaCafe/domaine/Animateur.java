package epsi.design_patterns.projetMangaCafe.domaine;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Animateur{
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	long id_animateur;
	String nom,prenom,tel;
	@OneToMany(mappedBy="animateur", cascade = CascadeType.ALL)
	Collection<Evenement> events_valide = new ArrayList<Evenement>();
	public Animateur(){
		nom = "epsi";
		prenom = "paris";
		tel = "0123456789";
	}
	public Animateur(String nom,String prenom,String tel){
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}
	public Animateur(Animateur i){
		this.prenom = i.prenom;
		this.nom = i.nom;
		this.tel = i.tel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public long getId_animateur() {
		return id_animateur;
	}
	public void setId_animateur(int id_animateur) {
		this.id_animateur = id_animateur;
	}
	public Collection<Evenement> getEvents_valide() {
		return events_valide;
	}
	public void setEvents_valide(Collection<Evenement> events_valide) {
		this.events_valide = events_valide;
	}
	public Collection<Evenement> getEvent() {
		return events_valide;
	}

	public void setEvenement(Collection<Evenement> event) {
		events_valide = event;
	}
	
	public void proposeEvenement(Evenement event,Personnel p) {
		event.setAnimateur(this);
	}
	public void setId_animateur(long id_animateur) {
		this.id_animateur = id_animateur;
	}
	public void removeEvenement(Evenement event) {
		events_valide.remove(event);
		event.setAnimateur(null);
	}
	public void addEvent(Evenement event) {
		events_valide.add(event);
		event.setAnimateur(this);
	}
	@Override
	public String toString() {
		return "Animateur [id_animateur=" + id_animateur + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel
				+ ", events_valide=" + events_valide + "]";
	}
}
