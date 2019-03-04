package epsi.design_patterns.projetMangaCafe.application;

import java.util.List;

import epsi.design_patterns.projetMangaCafe.domaine.Commande;
import epsi.design_patterns.projetMangaCafe.domaine.Produit;

public interface ConsommerProduit {
	public void payerCommande(String commande,String client);
	public boolean ajouterProduit(Commande commande);
	public List<Produit> voirListeProduit();
	public void voirListeCommande(long i);
}
