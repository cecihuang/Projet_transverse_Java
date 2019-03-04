package epsi.design_patterns.projetMangaCafe.domaine;

import org.springframework.data.repository.CrudRepository;

public interface EvenementRepository extends CrudRepository<Evenement, Long> {
	public Evenement findByAnimateur(Animateur animateur);
	public Evenement findByClient(Client client);
	public Evenement findByNom(String nom);
	public Evenement findByDate(String date);
	public Evenement findByDateFin(String dateFin);
	public Evenement findByValide(String valide);
}
