package com.trio.proxibanquev3.domaine;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Classe permettant d'utiliser des objets representants des Client héritant de
 * <p>
 * la classe personne. Un client est donc caractérisé par un nom, un prenom, une
 * <p>
 * adresse, un mail. A ceci s'ajoute une clé d'identification dans la base de
 * <p>
 * donnée, un conseiller et une liste de comptes bancaires.
 * 
 * @author Vincent Blameble
 *
 */
@Entity
public class Client extends Personne {

	
	@ManyToOne
	private Conseiller conseiller;
	
	@OneToMany(mappedBy="proprietaire")
	private Collection<CompteBancaire> comptes;

	/**
	 * Constructeur d'objet Client vide:
	 */
	public Client() {
	}

	/**
	 * Constructeur d'objet Client a partir de: son nom, son prenom, son
	 * <p>
	 * adresse, son mail, le conseiller qui le suit et sa liste de compte.
	 *
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param mail
	 * @param conseiller
	 * @param comptes
	 */
	public Client(String nom, String prenom, Adresse adresse,String telephone, String mail, Conseiller conseiller,
			Collection<CompteBancaire> comptes) {
		super(nom, prenom, adresse,telephone, mail);
		this.conseiller = conseiller;
		this.comptes = comptes;
	}

	/**
	 * Constructeur d'objet Client a partir de: son nom, son prenom, son
	 * <p>
	 * adresse, son mail, et le conseiller qui le suit.
	 * <p>
	 * la liste de compte est initialisée comme etant vide.
	 *
	 * @param nom nom du client
	 * @param prenom prenom du client
	 * @param adresse adresse
	 * @param mail adresse mail 
	 * @param conseiller conseiller chargé du dossier du client
	 */
	public Client(String nom, String prenom, Adresse adresse,String telephone, String mail, Conseiller conseiller) {
		super(nom, prenom, adresse,telephone, mail);
		this.conseiller = conseiller;
		this.comptes = new HashSet<CompteBancaire>();
	}

	/**
	 * @return le conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
	}

	/**
	 * @param conseiller valeur définie pour la propriété conseiller
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	/**
	 * @return le comptes
	 */
	public Collection<CompteBancaire> getComptes() {
		return comptes;
	}

	/**
	 * @param comptes valeur définie pour la propriété comptes
	 */
	public void setComptes(Collection<CompteBancaire> comptes) {
		this.comptes = comptes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [nom:"+this.getNom()+", prenom: "+this.getPrenom()+", adresse: "+this.getAdresse().toString()+", mail: "+this.getMail()+ "]";
	}
	
	
	
}
