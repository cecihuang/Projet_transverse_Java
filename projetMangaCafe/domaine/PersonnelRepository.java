package epsi.design_patterns.projetMangaCafe.domaine;

import org.springframework.data.repository.CrudRepository;

public interface PersonnelRepository extends CrudRepository<Personnel, Long>{
	public Personnel findByNom(String nom);
	public Personnel findByPrenom(String prenom);
	public Personnel findByTel(String tel);
	public Personnel findByAdresse(String adresse);
}
