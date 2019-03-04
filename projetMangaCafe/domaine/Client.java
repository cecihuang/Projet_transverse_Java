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
public class Client{
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	String nom,prenom,tel,adresse;
	@OneToMany(mappedBy="client", cascade = CascadeType.ALL)
	Collection<Commande> listCommande = new ArrayList<Commande>();
	@OneToMany(mappedBy="client", cascade = CascadeType.ALL)
	Collection<Evenement> listEvenement = new ArrayList<Evenement>();
	public Client(){
		this.nom = "Fiord";
		this.prenom = "Marius";
		this.adresse = "1 boulevard de Tales";
		this.tel = "0612345678";
	}
	public Client(String nom_cli,String prenom_cli){
		this.nom = nom_cli;
		this.prenom = prenom_cli;
	}
	public Client(String nom_cli,String prenom_cli,String tel_cli,String adresse_cli){
		this.nom = nom_cli;
		this.prenom = prenom_cli;
		this.tel = tel_cli;
		this.adresse = adresse_cli;
	}
	public Client(Client client){
		nom = client.nom;
		prenom= client.prenom;
		tel= client.tel;
		adresse = client.adresse;
	}
	public void passerCommande(Commande commande) {
        if(listCommande.contains(commande)==false) {
        	listCommande.add(commande);
        }
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Collection<Commande> getListCommande() {
		return listCommande;
	}
	public void setListCommande(Collection<Commande> listCommande) {
		this.listCommande = listCommande;
	}
	public Collection<Evenement> getListEvenement() {
		return listEvenement;
	}
	public void setListEvenement(Collection<Evenement> listEvenement) {
		this.listEvenement = listEvenement;
	}
	public Collection<Commande> getCommandes() {
		return listCommande;
	}
	public void addCommande(Commande commande) {
		listCommande.add(commande);
		commande.setClient(this);
	}
	public void addEvent(Evenement event) {
		listEvenement.add(event);
		event.setClient(this);
	}
	/*@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", adresse=" + adresse
				+ ", listCommande=" + listCommande + ", listEvenement=" + listEvenement + "]";
	}*/
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
}
