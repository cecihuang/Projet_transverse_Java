package epsi.design_patterns.projetMangaCafe.application;

import epsi.design_patterns.projetMangaCafe.domaine.Evenement;
import epsi.design_patterns.projetMangaCafe.domaine.Produit;
import epsi.design_patterns.projetMangaCafe.domaine.ProduitRepository;
import epsi.design_patterns.projetMangaCafe.domaine.ProduitType;

public class InteractionPersonel implements ValiderEvent,EventProduit{
	ProduitRepository produitRepository;
	public InteractionPersonel(ProduitRepository produitRepository) {
		super();
		this.produitRepository = produitRepository;
	}

	@Override
	public void validerEvent(Evenement event, boolean i) {
		// TODO Auto-generated method stub
		event.setValide(i);
	}

	@Override
	public void venteProduit(String produit) {
		System.out.println(produitRepository.count());
		//Produit produits = produitRepository.findByNom(produit.getNom());

		for (Produit produitList : produitRepository.findAll()) {
			if(produitList.getNom().equals(produit)) {
				if(produitList.getQuantite()>=1) {
					produitList.setQuantite(produitList.getQuantite()-1);
					produitRepository.save(produitList);
					System.out.println("Produit vendu : "+produitList.toString());
				}
				else
					System.out.println("Le produit n'est plus disponible dans notre boutique");
			}
			else {
				System.out.println("Le produit n'est pas disponible dans notre boutique");
			}
		}
	}

	@Override
	public void ajouterProduit(String produit,ProduitType type) {
		Produit produits = produitRepository.findByNom(produit);
		//System.out.println(produit.toString());
		if(produits==null) {
			produits = new Produit(produit, 1, 10, type);
		}
		else {
			produits.setQuantite(produits.getQuantite()+1);
		}
		produitRepository.save(produits);
		for (Produit produitList : produitRepository.findAll()) {
			System.out.println("Produit ajouté : "+produitList.toString());
		}
	}

}
