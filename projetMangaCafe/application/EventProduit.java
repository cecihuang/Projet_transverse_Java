package epsi.design_patterns.projetMangaCafe.application;

import epsi.design_patterns.projetMangaCafe.domaine.ProduitType;

public interface EventProduit {
	public void venteProduit(String produit);
	public void ajouterProduit(String produit,ProduitType type);
}
