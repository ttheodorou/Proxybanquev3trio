package com.trio.proxibanquev3.domaine;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe permettant d'utiliser des objets representants des Comptes courants
 * <p>
 * héritant de compte bancaire. Un Compte courant est donc caractérisé par: une
 * <p>
 * clé d'identification en base de données, un numero de compte, une date
 * <p>
 * d'ouverture, un proprietaire, et un solde. A ceci s'ajoute une limite de
 * <p>
 * decouvert autorise.
 * 
 * @author Vincent Blameble
 *
 */
@Entity
@DiscriminatorValue("COURANT")
public class CompteCourant extends CompteBancaire {

	private double decouvertAutorise;

	/**
	 * Constructeur d'objet CompteCourant vide.
	 */
	public CompteCourant() {
	}

	/**
	 * Constructeur d'objet CompteCourant a partir de: son numero de compte, sa
	 * <p>
	 * date d'ouverture, son solde, son propriétaire, et sa limite de découvert
	 * <p>
	 * autorise.
	 * 
	 * @param numCompte
	 *            le numero de compte
	 * @param dateOUverture
	 *            la date d'ouverture du compte
	 * @param solde
	 *            le solde actuel du compte
	 * @param proprietaire
	 *            le client proprietaire du compte
	 * @param decouvertAutorise
	 *            la limite de decouvert autorise sur ce compte
	 */
	public CompteCourant(long numCompte, Date dateOUverture, double solde, Client proprietaire,
			double decouvertAutorise) {
		super(numCompte, dateOUverture, solde, proprietaire);
		this.decouvertAutorise = decouvertAutorise;
	}

	/**
	 * @return le decouvertAutorise
	 */
	public double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	/**
	 * @param decouvertAutorise valeur définie pour la propriété decouvertAutorise
	 */
	public void setDecouvertAutorise(double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	
}
