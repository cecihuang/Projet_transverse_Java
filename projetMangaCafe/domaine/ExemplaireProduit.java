package epsi.design_patterns.projetMangaCafe.domaine;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ExemplaireProduit {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	Commande commande;
	@ManyToOne(cascade = CascadeType.ALL)
	Produit produit;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	@Override
	public String toString() {
		return "ExemplaireProduit [id=" + id + ", commande=" + commande.getId() + ", produit=" + produit.getId() + "]";
	}

}
