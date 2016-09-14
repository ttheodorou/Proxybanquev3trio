package com.trio.proxibanquev3.service;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.trio.proxibanquev3.dao.AdresseDAO;
import com.trio.proxibanquev3.dao.IAdresseDAO;
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
//@Model
public class AdresseService implements IAdresseService {
 
	
	private AdresseDAO adresseDAO = new AdresseDAO();

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IAdresseService#creerUneAdresse(com.trio.proxibanquev3.domaine.Adresse)
	 */
	@Override
	public void creerUneAdresse(Adresse adresse) throws DAOException {
		adresseDAO.creerUneAdresse(adresse);
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IAdresseService#lireToutesLesAdresses()
	 */
	@Override
	public List<Adresse> lireToutesLesAdresses() throws DAOException {
		return adresseDAO.lireToutesLesAdresses();
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IAdresseService#lireUneAdresse(long)
	 */
	@Override
	public Adresse lireUneAdresse(long idAdresse) throws DAOException {
		return adresseDAO.lireUneAdresse(idAdresse);
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IAdresseService#mAJUneAdresse(com.trio.proxibanquev3.domaine.Adresse)
	 */
	@Override
	public void mAJUneAdresse(Adresse adresse) throws DAOException {
		adresseDAO.mAJUneAdresse(adresse);
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IAdresseService#supprimerUneAdresse(com.trio.proxibanquev3.domaine.Adresse)
	 */
	@Override
	public void supprimerUneAdresse(Adresse adresse) throws DAOException {
		adresseDAO.supprimerUneAdresse(adresse);
	}

}
