package epsi.design_patterns.projetMangaCafe.domaine;

import org.springframework.data.repository.CrudRepository;

public interface AnimateurRepository extends CrudRepository<Animateur, Long>{
	public Animateur findByNom(String nom);
	public Animateur findByPrenom(String prenom);
	public Animateur findByTel(String tel);
}
