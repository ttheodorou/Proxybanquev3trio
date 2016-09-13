
package com.trio.proxibanquev3.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe permettant d'utiliser des objets representants des adresses.
 * <p>
 * Un Adresse est caractérisé par: un numero de rue, un nom de rue, un code
 * <p>
 * postal et une ville.
 * 
 * @author Vincent Blameble
 *
 */
@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAdresse;
	private String numRue;
	private String nomRue;
	private int codePostal;
	private String ville;

	/**
	 * Constructeur d'objet Adresse vide,
	 */
	public Adresse() {
	}

	/**
	 * Constructeur d'objet Adresse a partir du numero et nom de rue, du code
	 * <p>
	 * postal et de la ville.
	 * 
	 * @param numRue
	 *            numero de la rue
	 * @param nomRue
	 *            nom et type de rue(exemple: rue des closets, Avenue Charles
	 *            Nedelec,...)
	 * @param codePostal
	 *            code postal
	 * @param ville
	 *            nom de la ville
	 */
	public Adresse(String numRue, String nomRue, int codePostal, String ville) {
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	/**
	 * @return le idAdresse
	 */
	public long getIdAdresse() {
		return idAdresse;
	}

	/**
	 * @param idAdresse
	 *            valeur définie pour la propriété idAdresse
	 */
	public void setIdAdresse(long idAdresse) {
		this.idAdresse = idAdresse;
	}

	/**
	 * @return le numRue
	 */
	public String getNumRue() {
		return numRue;
	}

	/**
	 * @param numRue
	 *            valeur définie pour la propriété numRue
	 */
	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	/**
	 * @return le nomRue
	 */
	public String getNomRue() {
		return nomRue;
	}

	/**
	 * @param nomRue
	 *            valeur définie pour la propriété nomRue
	 */
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	/**
	 * @return le codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal
	 *            valeur définie pour la propriété codePostal
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return le ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville
	 *            valeur définie pour la propriété ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}


	@Override
	public String toString() {
		return numRue + " " + nomRue + " " + codePostal + " " + ville;
	}
}
