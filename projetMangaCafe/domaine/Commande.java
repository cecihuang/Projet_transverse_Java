package epsi.design_patterns.projetMangaCafe.domaine;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	@ManyToOne(cascade = CascadeType.ALL)
	Client client;
	@Override
	public String toString() {
		return "Commande [id=" + id + ", client=" + client + ", nom=" + nom + ", statutCommande=" + statutCommande
				+ ", listExemplaire=" + listExemplaire + "]";
	}

	String nom;
	boolean statutCommande;
	@OneToMany(mappedBy="commande", cascade = CascadeType.ALL)
	List<ExemplaireProduit> listExemplaire = new ArrayList<ExemplaireProduit>();

	public Commande(){
		nom = "test";
		statutCommande = false;
	}

	public Commande( String nom,boolean statutCommande){
		this.nom = nom;
		this.statutCommande = statutCommande;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ExemplaireProduit> getListExemplaire() {
		return listExemplaire;
	}

	public void setListExemplaire(List<ExemplaireProduit> listExemplaire) {
		this.listExemplaire = listExemplaire;
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isStatutCommande() {
		return statutCommande;
	}

	public void setStatutCommande(boolean statutCommande) {
		this.statutCommande = statutCommande;
	}


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addProduit(Produit produit) {
		ExemplaireProduit ep = new ExemplaireProduit();
		listExemplaire.add(ep);
		ep.setProduit(produit);
		produit.addCommande(this);
	}
}
