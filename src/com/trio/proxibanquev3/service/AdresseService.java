package com.trio.proxibanquev3.service;

import java.util.List;

import com.trio.proxibanquev3.dao.AdresseDAO;
import com.trio.proxibanquev3.domaine.Adresse;
import com.trio.proxibanquev3.exception.DAOException;

/**
 * Classe permettant d'utiliser un objet AdresseService en charge des
 * <p>
 * opérations en lien avec les adresses.
 * 
 * @author Vincent Blameble
 *
 */
public class AdresseService {

	private AdresseDAO adresseDAO = new AdresseDAO();

	public void creerUneAdresse(Adresse adresse) throws DAOException {
		adresseDAO.creerUneAdresse(adresse);
	}

	public List<Adresse> lireToutesLesAdresses() throws DAOException {
		return adresseDAO.lireToutesLesAdresses();
	}

	public Adresse lireUneAdresse(long idAdresse) throws DAOException {
		return adresseDAO.lireUneAdresse(idAdresse);
	}

	public void MAJUneAdresse(Adresse adresse) throws DAOException {
		adresseDAO.MAJUneAdresse(adresse);
	}

	public void SupprimerUneAdresse(Adresse adresse) throws DAOException {
		adresseDAO.SupprimerUneAdresse(adresse);
	}

}
