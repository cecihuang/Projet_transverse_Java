package epsi.design_patterns.projetMangaCafe.application;

import java.util.List;

import epsi.design_patterns.projetMangaCafe.domaine.Client;
import epsi.design_patterns.projetMangaCafe.domaine.Evenement;

public interface ParticiperEvent {
	public boolean reserveEvent(Evenement event,Client i);
	public List<Evenement> voirListeEvent();
}
