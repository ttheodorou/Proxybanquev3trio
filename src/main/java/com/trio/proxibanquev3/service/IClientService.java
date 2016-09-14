package com.trio.proxibanquev3.service;

import java.util.List;

import com.trio.proxibanquev3.domaine.Client;
import com.trio.proxibanquev3.domaine.Conseiller;
import com.trio.proxibanquev3.exception.DAOException;

public interface IClientService {

	/**
	 * Sauvegarde un client initialement non present dans la base de donnée
	 * 
	 * @param client
	 *            client a sauvegarder
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	void creerUnClient(Client client) throws DAOException;

	/**
	 * renvoie la liste de tous les clients enregistrés en base de donnée
	 * 
	 * @return une liste de clients
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	List<Client> lireToutesLesClients() throws DAOException;

	/**
	 * renvoie un objet Client creer a partir de l'enregistrement en base de
	 * <p>
	 * donnée repertorié par l'id idClient
	 * 
	 * @param idClient
	 *            id de client a lire
	 * @return un objet client
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	Client lireUnClient(long idClient) throws DAOException;

	/**
	 * mettre a jour l'enregistrement d'un client en base de donnée
	 * 
	 * @param client
	 *            objet Client a mettre a jour dans la base
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	void mAJUnClient(Client client) throws DAOException;

	/**
	 * Supprimer l'enregistrement representant un objet Client
	 * 
	 * @param client
	 *            objet Client a supprimer de la base de donnée;
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	void supprimerUnClient(Client client) throws DAOException;

	/**
	 * renvoie la liste de tous les clients d'un conseiller enregistrés en base
	 * de donnée
	 * 
	 * @param idConseiller
	 *            l'id du conseiller dont on cherche les clients
	 * @return une liste de clients
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	public List<Client> lireToutesLesClientsByidConseiller(long idConseiller) throws DAOException;

	/**
	 * renvoie la liste de tous les clients d'un conseiller enregistrés en base
	 * de donnée
	 * 
	 * @param conseiller
	 *            l'objet conseiller dont on cherche les clients
	 * @return une liste de clients
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	public List<Client> lireToutesLesClientsByidConseiller(Conseiller conseiller) throws DAOException;
}