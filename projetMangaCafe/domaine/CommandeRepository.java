package epsi.design_patterns.projetMangaCafe.domaine;

import org.springframework.data.repository.CrudRepository;

public interface CommandeRepository  extends CrudRepository<Commande,Long>{
	public Commande findByClient(Client client);
	public Commande findByNom(String nom);
	public Commande findByStatutCommande(boolean statutCommande);
	public Commande findById(long id);
}
