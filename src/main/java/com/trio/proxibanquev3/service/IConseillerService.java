package com.trio.proxibanquev3.service;

import java.util.List;

import com.trio.proxibanquev3.domaine.Conseiller;
import com.trio.proxibanquev3.exception.DAOException;

public interface IConseillerService {

	/**
	 * mettre a jour l'enregistrement d'un conseiller en base de donnée
	 * 
	 * @param conseiller
	 *            objet Conseiller a mettre a jour dans la base
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	void MAJUnConseiller(Conseiller conseiller) throws DAOException;

	/**
	 * Supprimer l'enregistrement representant un objet Conseiller
	 * 
	 * @param adresse
	 *            objet Conseiller a supprimer de la base de donnée;
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	void SupprimerUnConseiller(Conseiller conseiller) throws DAOException;

	/**
	 * Sauvegarde un conseiller initialement non present dans la base de donnée
	 * 
	 * @param conseiller
	 *            conseiller a sauvegarder
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	void creerUnConseiller(Conseiller conseiller) throws DAOException;

	/**
	 * renvoie la liste de tous les conseillers enregistrés en base de donnée
	 * 
	 * @return une liste de conseillers
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	List<Conseiller> lireToutesLesConseillers() throws DAOException;

	/**
	 * renvoie un objet Conseiller creer a partir de l'enregistrement en base de
	 * <p>
	 * donnée repertorié par l'id idConseiller
	 * 
	 * @param idConseiller
	 *            id de Conseiller a lire
	 * @return un objet Conseiller
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	Conseiller lireUnConseiller(long idConseiller) throws DAOException;

	/**
	 * renvoie un objet Conseiller creer a partir de l'enregistrement en base de
	 * <p>
	 * donnée repertorié par le login login
	 * 
	 * @param login
	 *            login de Conseiller a lire
	 * @return un objet Conseiller
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	Conseiller lireUnConseiller(String login) throws DAOException;

}