package epsi.design_patterns.projetMangaCafe.domaine;


import org.springframework.data.repository.CrudRepository;


public interface ProduitRepository extends CrudRepository<Produit,Long>{
	public Produit findByNom(String nom);
	public Produit findByPrix(double prix);
	public Produit findById(long id);
}
