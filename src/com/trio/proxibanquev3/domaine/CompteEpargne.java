package com.trio.proxibanquev3.domaine;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe permettant d'utiliser des objets representants des Comptes Epargne
 * <p>
 * héritant de compte bancaire. Un Compte Epargne est donc caractérisé par: une
 * <p>
 * clé d'identification en base de données, un numero de compte, une date
 * <p>
 * d'ouverture, un proprietaire, et un solde. A ceci s'ajoute un taux de
 * <p>
 * remuneration.
 * 
 * @author Vincent Blameble
 *
 */
@Entity
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends CompteBancaire {

	private double tauxRemuneration;

	/**
	 * Constructeur d'objet CompteEpargne vide.
	 */
	public CompteEpargne() {
	}

	/**
	 * Constructeur d'objet CompteEpargne a partir de: son numero de compte, sa
	 * <p>
	 * date d'ouverture, son solde, son propriétaire, et son taux de
	 * <p>
	 * remuneration.
	 *
	 * @param numCompte
	 *            le numero de compte
	 * @param dateOUverture
	 *            la date d'ouverture du compte
	 * @param solde
	 *            le solde actuel du compte
	 * @param proprietaire
	 *            le client proprietaire du compte
	 * @param tauxRemuneration
	 *            le taux de remuneration de l'epargne
	 */
	public CompteEpargne(long numCompte, Date dateOUverture, double solde, Client proprietaire,
			double tauxRemuneration) {
		super(numCompte, dateOUverture, solde, proprietaire);
		this.tauxRemuneration = tauxRemuneration;
	}

	/**
	 * @return le tauxRemuneration
	 */
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	/**
	 * @param tauxRemuneration valeur définie pour de la propriété tauxRemuneration
	 */
	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

	
}
