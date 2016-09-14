package com.trio.proxibanquev3.service;

import java.util.List;

import com.trio.proxibanquev3.domaine.Client;
import com.trio.proxibanquev3.domaine.CompteBancaire;
import com.trio.proxibanquev3.exception.DAOException;
import com.trio.proxibanquev3.exception.ServiceException;

public interface ICompteBancaireService {

	void virement(CompteBancaire compteDebite, CompteBancaire compteCredite, double montant) throws ServiceException;

	/**
	 * Sauvegarde un CompteBancaire initialement non present dans la base de
	 * <p>
	 * donnée
	 * 
	 * @param compteBancaire
	 *            CompteBancaire a sauvegarder
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	void creerUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException;

	/**
	 * renvoie la liste de tous les Comptes Bancaires enregistrés en base de
	 * donnée
	 * 
	 * @return une liste de Comptes Bancaires
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	List<CompteBancaire> lireToutesLesCompteBancaires() throws DAOException;

	/**
	 * renvoie la liste de tous les Comptes Bancaires d'un client enregistrés en
	 * base de donnée
	 * 
	 * @param idClient
	 *            l'id du Client dont on cherche les Comptes Bancaires
	 * @return une liste de Comptes Bancaires
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	List<CompteBancaire> lireToutesLesCompteBancairesByClient(long idClient) throws DAOException;

	/**
	 * renvoie la liste de tous les Comptes Bancaires d'un Client enregistrés en
	 * base de donnée
	 * 
	 * @param conseiller
	 *            l'objet Client dont on cherche les Comptes Bancaires
	 * @return une liste de Comptes Bancaires
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	List<CompteBancaire> lireToutesLesCompteBancairesByClient(Client client) throws DAOException;

	/**
	 * renvoie un objet CompteBancaire creer a partir de l'enregistrement en
	 * base de
	 * <p>
	 * donnée repertorié par l'id idCompteBancaire
	 * 
	 * @param idCompteBancaire
	 *            id de CompteBancaire a lire
	 * @return un objet CompteBancaire
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	CompteBancaire lireUnCompteBancaire(long idCompteBancaire) throws DAOException;

	/**
	 * mettre a jour l'enregistrement d'un CompteBancaire en base de donnée
	 * 
	 * @param compteBancaire
	 *            objet CompteBancaire a mettre a jour dans la base
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	void mAJUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException;

	/**
	 * Supprimer l'enregistrement representant un objet CompteBancaire
	 * 
	 * @param compteBancaire
	 *            objet CompteBancaire a supprimer de la base de donnée;
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	void supprimerUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException;

}