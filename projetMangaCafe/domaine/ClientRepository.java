package epsi.design_patterns.projetMangaCafe.domaine;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository  extends CrudRepository<Client,Long>{
	public Client findByNom(String nom);
	public Client findByPrenom(String prenom);
	public Client findByTel(String tel);
	public Client findByAdresse(String adresse);
	public Client findById(long id);
}
