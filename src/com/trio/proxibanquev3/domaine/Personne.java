package com.trio.proxibanquev3.domaine;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 * Classe permettant d'utiliser des objets representants des personnes.
 * <p>
 * Une personne est caractérisée par:
 * <p>
 * 
 * @author Vincent Blameble
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long idPersonne;
	
	private String nom;
	private String prenom;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Adresse adresse;
	private String telephone;
	private String mail;

	/**
	 * Constructeur d'objet Personne vide:
	 */
	public Personne() {
	}

	/**
	 * Constructeur d'objet Personne a partir: d'un nom, d'un prenom, d'une
	 * <p>
	 * adresse et d'un mail.
	 * 
	 * @param nom
	 *            nom de l'individu
	 * @param prenom
	 *            prenom de l'individu
	 * @param adresse
	 *            adresse formatée
	 * @param mail
	 *            adresse mail
	 */
	public Personne(String nom, String prenom, Adresse adresse, String mail) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mail = mail;
	}
	
	/**
	 * @return le idConseiller
	 */
	public long getIdPersonne() {
		return idPersonne;
	}

	/**
	 * @param idConseiller valeur définie pour la propriété idConseiller
	 */
	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}

	/**
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            valeur définie pour la propriété nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return le prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            valeur définie pour la propriété prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return le adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            valeur définie pour la propriété adresse
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * @return le numero de telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param adresse
	 *            valeur définie pour le numero de telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return le mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            valeur définie pour la propriété mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

}
