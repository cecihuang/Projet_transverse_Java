package epsi.design_patterns.projetMangaCafe.application;

import epsi.design_patterns.projetMangaCafe.domaine.Evenement;

public interface ProposerEvent {
	public Evenement proposerEvent(String Activite,int id_aminateur);
}
