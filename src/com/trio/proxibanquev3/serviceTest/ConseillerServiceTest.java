package com.trio.proxibanquev3.serviceTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

import com.trio.proxibanquev3.domaine.Adresse;
import com.trio.proxibanquev3.domaine.Client;
import com.trio.proxibanquev3.domaine.Conseiller;
import com.trio.proxibanquev3.exception.DAOException;
import com.trio.proxibanquev3.service.ConseillerService;

public class ConseillerServiceTest {
	ConseillerService conseillerService;

	@Before
	public void avantChaqueTest() {
		conseillerService = new ConseillerService();
	}

	/**
	 * Méthode de test qui permet de vérifier que la méthode créer un conseiller
	 * dans la DB renvoie bien un id non null.
	 */
	@Test
	public void testCreerUnConseiller() {
		Conseiller conseiller = new Conseiller("marley", "bob", new Adresse("2", "rue jean", 69005, "Lyon"),
				"0628078524", "thomas@moi.fr", "bmarley", "azerty", new ArrayList<Client>());
		try {
			conseillerService.creerUnConseiller(conseiller);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long idConseiller = conseiller.getIdPersonne();
		
		assertNotNull(idConseiller);

	}


	@Test
	public void testLireUnConseillerLong1() throws DAOException {
		int idConseiller = 1;
		assertNotNull(conseillerService.lireUnConseiller(idConseiller));
	}


	@Test
	public void testLireUnConseillerString() throws DAOException {
		String idConseiller = "vink";
		assertNotNull(conseillerService.lireUnConseiller(idConseiller));
	}

	/**
	 * Méthode permettant de vérifier que la modification faite en base est bien celle demandée.
	 * @throws DAOException
	 */
	@Test
	public void testMAJUnConseiller() throws DAOException {
		Conseiller conseiller = new Conseiller("marley", "bob", new Adresse("2", "rue jean", 69005, "Lyon"),
				"0628078524", "thomas@moi.fr", "bmarley", "azerty", new ArrayList<Client>());
		try {
			conseillerService.creerUnConseiller(conseiller);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nouveauPrenom = "Jon";
		conseiller.setPrenom(nouveauPrenom);
		conseillerService.MAJUnConseiller(conseiller);
		long idConseiller = conseiller.getIdPersonne();
		String nouveauPrenomEnBase = conseillerService.lireUnConseiller(idConseiller).getPrenom();
		assertEquals(nouveauPrenom, nouveauPrenomEnBase);
	}

	@Test
	public void testSupprimerUnConseiller() throws DAOException {
		Conseiller conseiller = new Conseiller("marley", "bob", new Adresse("2", "rue jean", 69005, "Lyon"),
				"0628078524", "thomas@moi.fr", "bmarley", "azerty", new ArrayList<Client>());
		try {
			conseillerService.creerUnConseiller(conseiller);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conseillerService.SupprimerUnConseiller(conseiller);
		
	}

}
