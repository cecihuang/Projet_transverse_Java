package epsi.design_patterns;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import epsi.design_patterns.projetMangaCafe.application.InteractionClient;
import epsi.design_patterns.projetMangaCafe.application.InteractionPersonel;
import epsi.design_patterns.projetMangaCafe.domaine.Client;
import epsi.design_patterns.projetMangaCafe.domaine.ClientRepository;
import epsi.design_patterns.projetMangaCafe.domaine.Commande;
import epsi.design_patterns.projetMangaCafe.domaine.CommandeRepository;
import epsi.design_patterns.projetMangaCafe.domaine.ProduitRepository;
import epsi.design_patterns.projetMangaCafe.domaine.ProduitType;


@SpringBootApplication
public class DesignPatternsApplication {

	private static final Logger log = LoggerFactory.getLogger(DesignPatternsApplication.class);
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	ClientRepository clientRepository;
	public static void main(String[] args) {
		
		SpringApplication.run(DesignPatternsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CommandeRepository repository) {
		return (args) -> {
			// save a couple of customers
			Commande commande1 = new Commande("test",false);
			System.out.println(commande1.getId());
			Client client1 = new Client("aa","bb");
			clientRepository.save(client1);
			InteractionClient intClient = new InteractionClient(commande1, client1, produitRepository,
					repository, clientRepository);
			InteractionPersonel test = new InteractionPersonel(produitRepository);
			test.ajouterProduit("figurine",ProduitType.Goodie);
			test.ajouterProduit("poster",ProduitType.Goodie);
			test.ajouterProduit("Menu Yakitori",ProduitType.Menu);
			intClient.voirListeProduit();
			intClient.ajouterProduit(commande1);
			intClient.payerCommande(commande1.getNom(),client1.getNom());
			//client
			
			// fetch all customers
			log.info("Commande found with findAll():" + repository.findAll().spliterator().estimateSize());
			log.info("-------------------------------");
			for (Commande commande : repository.findAll()) {
				log.info(commande.toString());
			}
			log.info("");
			
		};
	}

}
