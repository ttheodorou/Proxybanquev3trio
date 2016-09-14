package com.trio.proxibanquev3.service;

import com.trio.proxibanquev3.dao.AdresseDAO;
import com.trio.proxibanquev3.domaine.Adresse;
import com.trio.proxibanquev3.exception.DAOException;
import org.apache.log4j.Logger;

import java.util.List;

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

	private final static Logger logger = Logger.getLogger(AdresseService.class);
	
	private AdresseDAO adresseDAO = new AdresseDAO();

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IAdresseService#creerUneAdresse(com.trio.proxibanquev3.domaine.Adresse)
	 */
	@Override
	public void creerUneAdresse(Adresse adresse) throws DAOException {
		logger.info("On demande a créer une adresse");
		adresseDAO.creerUneAdresse(adresse);
		logger.info("On a fini de créer une adresse (peut avoir échoué)");
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IAdresseService#lireToutesLesAdresses()
	 */
	@Override
	public List<Adresse> lireToutesLesAdresses() throws DAOException {
		logger.info("On demande a lire toutes les adresses");
		return adresseDAO.lireToutesLesAdresses();
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IAdresseService#lireUneAdresse(long)
	 */
	@Override
	public Adresse lireUneAdresse(long idAdresse) throws DAOException {
		logger.info("On demande a lire une adresse ciblée par son identifiant");
		return adresseDAO.lireUneAdresse(idAdresse);
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IAdresseService#mAJUneAdresse(com.trio.proxibanquev3.domaine.Adresse)
	 */
	@Override
	public void mAJUneAdresse(Adresse adresse) throws DAOException {
		logger.info("On demande a mettre à jour une adresse");
		adresseDAO.mAJUneAdresse(adresse);
		logger.info("On a fini de mettre à jour une adresse (peut avoir échoué)");
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IAdresseService#supprimerUneAdresse(com.trio.proxibanquev3.domaine.Adresse)
	 */
	@Override
	public void supprimerUneAdresse(Adresse adresse) throws DAOException {
		logger.info("On demande a supprimer une adresse");
		adresseDAO.supprimerUneAdresse(adresse);
		logger.info("On a fini de supprimer une adresse (peut avoir échoué)");
	}

}
