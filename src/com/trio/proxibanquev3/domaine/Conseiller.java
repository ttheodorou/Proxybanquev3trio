package com.trio.proxibanquev3.domaine;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Classe permettant d'utiliser des objets representants des Conseillers.
 * <p>
 * héritant de la classe personne. Un Conseiller est donc caractérisé par un
 * nom,
 * <p>
 * un prenom, une adresse, un mail. A ceci s'ajoute une clé d'identification
 * <p>
 * dans la base de donnée, un identifiant de connexion, un mot de passe ainsi
 * <p>
 * qu'une liste de clients.
 * 
 * @author Vincent Blameble
 *
 */
@Entity
public class Conseiller extends Personne {
	
	private String login;
	private String password;
	
	@OneToMany(mappedBy="conseiller")
	private Collection<Client> clients;

	/**
	 * Constructeur d'objet Conseiller vide:
	 */
	public Conseiller() {
	}

	/**
	 * Constructeur d'objet Conseiller a partir de: son nom, son prenom, son
	 * <p>
	 * adresse, son mail, son identifiant de connexion, son mot de passe et sa
	 * <p>
	 * liste de clients.
	 *
	 * @param nom
	 *            nom du conseiller
	 * @param prenom
	 *            prenom du conseiller
	 * @param adresse
	 *            adresse a laquelle joindre le conseiller
	 * @param mail
	 *            adresse mail professionnelle du conseiller
	 * @param login
	 *            identifiant de connexion du conseiller au systeme
	 * @param password
	 *            mot de passe du conseiller
	 * @param clients
	 *            liste des clients du conseiller
	 */
	public Conseiller(String nom, String prenom, Adresse adresse, String mail, String login, String password,
			Collection<Client> clients) {
		super(nom, prenom, adresse, mail);
		this.login = login;
		this.password = password;
		this.clients = clients;
	}

	/**
	 * Constructeur d'objet Conseiller a partir de: son nom, son prenom, son
	 * <p>
	 * adresse, son mail, son identifiant de connexion et son mot de passe. la
	 * <p>
	 * liste de client est initialisée comme etant vide.
	 *
	 * @param nom
	 *            nom du conseiller
	 * @param prenom
	 *            prenom du conseiller
	 * @param adresse
	 *            adresse a laquelle joindre le conseiller
	 * @param mail
	 *            adresse mail professionnelle du conseiller
	 * @param login
	 *            identifiant de connexion du conseiller au systeme
	 * @param password
	 *            mot de passe du conseiller
	 */
	public Conseiller(String nom, String prenom, Adresse adresse, String mail, String login, String password) {
		super(nom, prenom, adresse, mail);
		this.login = login;
		this.password = password;
		this.clients = new HashSet<Client>();
	}



	/**
	 * @return le login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login valeur définie pour la propriété login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return le password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password valeur définie pour la propriété password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return le clients
	 */
	public Collection<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients valeur définie pour la propriété clients
	 */
	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}
	
	

}
