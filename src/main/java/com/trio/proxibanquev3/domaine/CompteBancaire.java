/**
 * 
 */
package com.trio.proxibanquev3.domaine;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 * Classe permettant d'utiliser des objets representants des comptes bancaires.
 * <p>
 * Un compte bancaire est caractérisé par: une clé d'identification en base de
 * <p>
 * données, un numero de compte, une date d'ouverture, un proprietaire, et un
 * <p>
 * solde.
 * 
 * @author Vincent Blameble
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE")
@DiscriminatorValue("MERE")
public abstract class CompteBancaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCompte;
	private long numCompte;
	private Date dateOuverture;
	private double solde;

	@ManyToOne
	private Client proprietaire;

	/**
	 * Constructeur d'objet CompteBancaire vide.
	 *
	 */
	public CompteBancaire() {
	}

	/**
	 * Constructeur d'objet CompteBancaire a partir de: son numero de compte,
	 * <p>
	 * sa date d'ouverture, son solde et de son propriétaire.
	 *
	 * @param numCompte
	 *            numero de compte
	 * @param dateOuverture
	 *            date d'ouverture du compte bancaire
	 * @param solde
	 *            solde du compte
	 * @param proprietaire
	 *            client proprietaire du compte
	 */
	public CompteBancaire(long numCompte, Date dateOUverture, double solde, Client proprietaire) {
		this.numCompte = numCompte;
		this.dateOuverture = dateOUverture;
		this.solde = solde;
		this.proprietaire = proprietaire;
	}

	/**
	 * @return le idCompte
	 */
	public long getIdCompte() {
		return idCompte;
	}

	/**
	 * @param idCompte
	 *            valeur définie pour la propriété idCompte
	 */
	public void setIdCompte(long idCompte) {
		this.idCompte = idCompte;
	}

	/**
	 * @return le dateOuverture
	 */
	public Date getDateOuverture() {
		return dateOuverture;
	}

	/**
	 * @param dateOuverture
	 *            valeur définie pour la propriété dateOuverture
	 */
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	/**
	 * @return le numCompte
	 */
	public long getNumCompte() {
		return numCompte;
	}

	/**
	 * @param numCompte
	 *            valeur définie pour la propriété numCompte
	 */
	public void setNumCompte(long numCompte) {
		this.numCompte = numCompte;
	}

	/**
	 * @return le solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde
	 *            valeur définie pour la propriété solde
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * @return le proprietaire
	 */
	public Client getProprietaire() {
		return proprietaire;
	}

	/**
	 * @param proprietaire
	 *            valeur définie pour la propriété proprietaire
	 */
	public void setProprietaire(Client proprietaire) {
		this.proprietaire = proprietaire;
	}

}
