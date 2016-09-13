package com.trio.proxibanquev3.service;

import java.util.List;

import com.trio.proxibanquev3.domaine.Adresse;
import com.trio.proxibanquev3.exception.DAOException;

public interface IAdresseService {

	/**
	 * Sauvegarde une adresse initialement non presente dans la base de donnée
	 * 
	 * @param adresse
	 *            adresse a sauvegarder
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	void creerUneAdresse(Adresse adresse) throws DAOException;

	/**
	 * renvoie la liste de toutes les adresses enregistrées en base de donnée
	 * 
	 * @return une liste d'adresse
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	List<Adresse> lireToutesLesAdresses() throws DAOException;

	/**
	 * renvoie un objet Adresse creer a partir de l'enregistrement en base de
	 * <p>
	 * donnée repertorié par l'id idAdresse
	 * 
	 * @param idAdresse
	 *            id de l'adresse a lire
	 * @return un objet Adresse
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	Adresse lireUneAdresse(long idAdresse) throws DAOException;

	/**
	 * mettre a jour l'enregistrement d'une adresse en base de donnée
	 * 
	 * @param adresse
	 *            objet Adresse a mettre a jour dans la base
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	void mAJUneAdresse(Adresse adresse) throws DAOException;

	/**
	 * Supprimer l'enregistrement representant un objet Adresse
	 * 
	 * @param adresse
	 *            objet Adresse a supprimer de la base de donnée;
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	void supprimerUneAdresse(Adresse adresse) throws DAOException;

}