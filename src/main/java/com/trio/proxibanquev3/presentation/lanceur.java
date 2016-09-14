package com.trio.proxibanquev3.presentation;

import com.trio.proxibanquev3.domaine.*;
import com.trio.proxibanquev3.service.ClientService;
import com.trio.proxibanquev3.service.CompteBancaireService;
import com.trio.proxibanquev3.service.ConseillerService;
import org.apache.log4j.BasicConfigurator;

import java.util.Date;

public class lanceur {
	
	
	public static void main(String[] args) {

		//creationBase();
		BasicConfigurator.configure();
		
	}
	
	
	public static void creationBase() {
		Adresse adresse = new Adresse("73", "chemin des closets", 73460, "Gresy-sur-Isere");
		Adresse adresse1 = new Adresse("2 bis", "rue des cochons", 69009, "Lyon");
		Adresse adresse2 = new Adresse("265", "avenue Charles Nedelec", 69009, "Lyon");
		Adresse adresse3 = new Adresse("49", "Boulevard Montreux", 69009, "Lyon");
		Adresse adresse4 = new Adresse("le muscadier", "Chemin BIROT", 97213, "Gros-Morne");
		Adresse adresse5 = new Adresse("4", "le Cluzot", 88000, "La creuse");
		Adresse adresse6 = new Adresse("babar", "chez plouf", 00000, "a trifouilli les oie");
		Adresse adresse7 = new Adresse("dans", "la rue obscur", 66666, "la ou le soleil ne brille jamais");
		Adresse adresse8=new Adresse("80", "rue du general de gaule", 66666, "quelquepart");

		Conseiller conseiller = new Conseiller("Blameble", "Vincent", adresse,"+33 0678999", "v.bloomble@hotmail.fr", "vink", "root");
		Conseiller conseiller1 = new Conseiller("Blameble", "Paul", adresse4,"+33 0678999", "v.blameble@gmail.com", "Polo",
				"Meyal092");

		Client client = new Client("Theodorou", "Thomas", adresse1,"+33 0678999", "ttheodorou@blabla.com", conseiller);
		Client client1 = new Client("Tardy", "Brice", adresse2,"+33 0678999", "btardy@blabla.com", conseiller);
		Client client2 = new Client("jemerappelleplus", "guillaume", adresse3,"+33 0678999", "ouaimaiscestpasca@blabla.com",
				conseiller);
		Client client3 = new Client("vietnamien", "Sylvain", adresse8,"+33 0678999", "cestnormal@blabla.com", conseiller);
		Client client4 = new Client("cestpasmonprenom", "Elise", adresse5,"+33 0678999", "labelleeliseu@blabla.com", conseiller);
		Client client5 = new Client("Dupont", "guy-george", adresse6,"+33 0678999", "guyguyu@blabla.com", conseiller);
		Client client6 = new Client("Durant", "jean-guy", adresse7,"+33 0678999", "benguyguyu@blabla.com", conseiller);

		CompteCourant compteCourant = new CompteCourant(101, new Date(), 5000, client, 1000);
		CompteEpargne compteEpargne = new CompteEpargne(201, new Date(), 7500, client, 0.03);
		CompteCourant comptecourant1 = new CompteCourant(102, new Date(), 500, client3, 1000);
		CompteEpargne compteEpargne1 = new CompteEpargne(202, new Date(), 250, client3, 0.03);
		CompteCourant compteCourant2 = new CompteCourant(103, new Date(), 50, client2, 0);
		CompteEpargne compteEpargne2 = new CompteEpargne(203, new Date(), 7, client1, 0.03);
		CompteCourant comptecourant3 = new CompteCourant(104, new Date(), 78500, client5, 2000);
		CompteEpargne compteEpargne3 = new CompteEpargne(204, new Date(), 55250, client6, 0.07);

//		AdresseService adresseService = new AdresseService();
		ClientService clientService=new ClientService();
		CompteBancaireService compteBancaireService = new CompteBancaireService();
		ConseillerService conseillerService = new ConseillerService();

		try {
//			adresseService.creerUneAdresse(adresse);
//			adresseService.creerUneAdresse(adresse1);
//			adresseService.creerUneAdresse(adresse2);
//			adresseService.creerUneAdresse(adresse3);
//			adresseService.creerUneAdresse(adresse4);
//			adresseService.creerUneAdresse(adresse5);
//			adresseService.creerUneAdresse(adresse6);
//			adresseService.creerUneAdresse(adresse7);

			conseillerService.creerUnConseiller(conseiller);
			conseillerService.creerUnConseiller(conseiller1);

			clientService.creerUnClient(client);
			clientService.creerUnClient(client1);
			clientService.creerUnClient(client2);
			clientService.creerUnClient(client3);
			clientService.creerUnClient(client4);
			clientService.creerUnClient(client5);
			clientService.creerUnClient(client6);

			compteBancaireService.creerUnCompteBancaire(compteCourant);
			compteBancaireService.creerUnCompteBancaire(compteEpargne);
			compteBancaireService.creerUnCompteBancaire(comptecourant1);
			compteBancaireService.creerUnCompteBancaire(compteEpargne1);
			compteBancaireService.creerUnCompteBancaire(compteCourant2);
			compteBancaireService.creerUnCompteBancaire(compteEpargne2);
			compteBancaireService.creerUnCompteBancaire(compteEpargne3);
			compteBancaireService.creerUnCompteBancaire(comptecourant3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
