package epsi.design_patterns.projetMangaCafe.domaine;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produit {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	String nom;
	@OneToMany(mappedBy="produit", cascade = CascadeType.ALL)
	List<ExemplaireProduit> listExemplaire = new ArrayList<ExemplaireProduit>();
	int quantite;
	double prix;
	ProduitType produitType;
	public Produit(String nom,int quantite,double prix,ProduitType produitType){
		this.nom = nom;
		this.quantite = quantite;
		this.prix = prix;
		this.produitType = produitType;
	}
	public Produit(Produit produit){
		this.nom = produit.nom;
		this.quantite = produit.quantite;
		this.prix = produit.prix;
		this.produitType = produit.produitType;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", listExemplaire=" + listExemplaire + ", quantite=" + quantite
				+ ", prix=" + prix + ", produitType=" + produitType + "]";
	}
	public ProduitType getProduitType() {
		return produitType;
	}
	public void setProduitType(ProduitType produitType) {
		this.produitType = produitType;
	}
	public Produit(){
		quantite = 20;
		prix = 4.4;
	}
	public List<ExemplaireProduit> getListExemplaire() {
		return listExemplaire;
	}
	public void setListExemplaire(List<ExemplaireProduit> listExemplaire) {
		this.listExemplaire = listExemplaire;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite_prod) {
		this.quantite = quantite_prod;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void addCommande(Commande commande) {
		ExemplaireProduit ep = new ExemplaireProduit();
		listExemplaire.add(ep);
		ep.setCommande(commande);
		commande.addProduit(this);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
