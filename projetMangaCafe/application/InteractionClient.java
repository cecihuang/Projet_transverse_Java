package epsi.design_patterns.projetMangaCafe.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import epsi.design_patterns.projetMangaCafe.domaine.Client;
import epsi.design_patterns.projetMangaCafe.domaine.ClientRepository;
import epsi.design_patterns.projetMangaCafe.domaine.Commande;
import epsi.design_patterns.projetMangaCafe.domaine.CommandeRepository;
import epsi.design_patterns.projetMangaCafe.domaine.Evenement;
import epsi.design_patterns.projetMangaCafe.domaine.ExemplaireProduit;
import epsi.design_patterns.projetMangaCafe.domaine.Produit;
import epsi.design_patterns.projetMangaCafe.domaine.ProduitRepository;

public class InteractionClient implements ConsommerProduit,ParticiperEvent{

	Commande commande;
	Client client;
	List<Produit> i = new ArrayList<Produit>();
	ProduitRepository produitRepository;
	CommandeRepository commandeRepository;
	ClientRepository clientRepository;
	
	public InteractionClient(Commande commande, Client client, ProduitRepository produitRepository,
			CommandeRepository commandeRepository, ClientRepository clientRepository) {
		super();
		this.commande = commande;
		this.client = client;
		this.produitRepository = produitRepository;
		this.commandeRepository = commandeRepository;
		this.clientRepository = clientRepository;
	}
	public InteractionClient(ProduitRepository produitRepository, List<Produit> i) {
		super();
		this.produitRepository = produitRepository;
		this.i = i;
	}
	public InteractionClient(ClientRepository clientRepository, List<Produit> i) {
		super();
		this.clientRepository = clientRepository;
		this.i = i;
	}
	public InteractionClient(CommandeRepository commandeRepository, List<Produit> i) {
		super();
		this.commandeRepository = commandeRepository;
		this.i = i;
	}
	@Override
	public void payerCommande(String commande, String client) {
		Client clients = clientRepository.findByNom(client);
		Commande commandeClient = commandeRepository.findByNom(commande);
		if(commandeClient!=null) {
			commandeClient.setStatutCommande(true);
			commandeClient.setClient(clients);
			clients.getListCommande().add(commandeClient);
			commandeRepository.save(commandeClient);
			System.out.println(clients.getPrenom()+" "+clients.getNom()+", nous vous remercions d'avoir payé la commande. Au revoir");
		}
		else {
			System.out.println("Pas de commande pour le client");
		}
	}

	@Override
	public List<Produit> voirListeProduit() {
		// TODO Auto-generated method stub
		for (Produit produitDispo : produitRepository.findAll()) {
			if(produitDispo.getQuantite()!=0) {
				System.out.println(produitDispo.getId()+" : "+produitDispo.getNom()+", "+produitDispo.getProduitType());
			}
		}
		return i;
	}

	@Override
	public void voirListeCommande(long i){
		//Commande commandeClient = commandeRepository.findByClient(i);
		for (Commande commandeClient : commandeRepository.findAll()) {
			if(commandeClient.getId()==i) {
				System.out.println(commandeClient.getId()+" : "+commandeClient.getNom());
			}
		}
	}
	@Override
	public boolean ajouterProduit( Commande commande) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("Veuillez donner le nom du produit désiré : ");
	    try {
			String nom = br.readLine();
			Produit produits = produitRepository.findByNom(nom);
			if(produits==null) {
				return false;
			}
			else {
				if(produits.getQuantite() > 0) {
					ExemplaireProduit exemplaireProduit = new ExemplaireProduit();
					produits.setQuantite(produits.getQuantite()-1);
					produits.getListExemplaire().add(exemplaireProduit);
					commande.getListExemplaire().add(exemplaireProduit);
					exemplaireProduit.setCommande(commande);
					exemplaireProduit.setProduit(produits);
					produitRepository.save(produits);
					//commandeRepository.save(commande);
					System.out.println("Vous avez bien ajouté le produit suivant : "+produits.getNom()+" dans votre commande.");
					return true;
				}
				else {
					return false;
				}
			}
		} catch (IOException e) { 
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Evenement> voirListeEvent() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean reserveEvent(Evenement event,Client i) {
		if(event.getNbPlace() > 0) {
			i.addEvent(event);
			event.setNbPlace(event.getNbPlace()-1);;
			return true;
		}
		else {
			return false;
		}
	}
}