package epsi.design_patterns.projetMangaCafe.domaine;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Personnel{
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	public String nom,prenom,tel,adresse;
	@OneToMany(mappedBy="personnel")
	Collection<ExemplaireEvent> events = new ArrayList<ExemplaireEvent>();
	public Personnel(){
		nom = "epsi";
		prenom = "paris";
		adresse = "test";
		tel = "0123456789";
	}
	public Personnel(String nom,String prenom,String tel,String adresse){
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
	}
	public Personnel(Personnel i){
		this.adresse = i.adresse;
		this.prenom = i.prenom;
		this.nom = i.nom;
		this.tel = i.tel;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}
