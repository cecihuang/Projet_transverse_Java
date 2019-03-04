package epsi.design_patterns.projetMangaCafe.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import epsi.design_patterns.projetMangaCafe.domaine.Evenement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Veuillez donner le nom du nouveau projet : ");
        ProposerEvent newEvent = new InteractionEvent();
        ValiderEvent newEventValidator = new InteractionPersonel(null);
        try {
			String nom = br.readLine();
	        Evenement event = newEvent.proposerEvent(nom,1);
	        newEventValidator.validerEvent(event, false); 
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
