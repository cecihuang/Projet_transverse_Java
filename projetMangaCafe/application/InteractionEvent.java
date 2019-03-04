package epsi.design_patterns.projetMangaCafe.application;


import epsi.design_patterns.projetMangaCafe.domaine.Animateur;
import epsi.design_patterns.projetMangaCafe.domaine.Evenement;

public class InteractionEvent implements AnimerEvent,ProposerEvent{

	@Override
	public Evenement proposerEvent(String activite,int id_aminateur) {
		Animateur animateur = new Animateur();
		animateur.setId_animateur(id_aminateur);
		Evenement event = new Evenement();
		event.setNom(activite);
		animateur.addEvent(event);
		return event;
	}

	@Override
	public Evenement animerevent(Evenement event) {
		
		return event;
	}

}
