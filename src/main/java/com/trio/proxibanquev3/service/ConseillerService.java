/**
 * 
 */
package com.trio.proxibanquev3.service;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.trio.proxibanquev3.dao.ConseillerDAO;
import com.trio.proxibanquev3.dao.IConseillerDAO;
import com.trio.proxibanquev3.domaine.Conseiller;
import com.trio.proxibanquev3.exception.DAOException;

/**
 * Classe permettant d'utiliser un objet ConseillerService en charge des
 * <p>
 * opérations en lien avec les conseillers.
 * 
 * @author Vincent Blameble
 *
 */
//@Model
public class ConseillerService implements IConseillerService {
	
	//@Inject
	private ConseillerDAO conseillerDAO = new ConseillerDAO();

	
	
	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IConseillerService#creerUnConseiller(com.trio.proxibanquev3.domaine.Conseiller)
	 */
	@Override
	public void creerUnConseiller(Conseiller conseiller) throws DAOException {
		conseillerDAO.creerUnConseiller(conseiller);
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IConseillerService#lireToutesLesConseillers()
	 */
	@Override
	public List<Conseiller> lireToutesLesConseillers() throws DAOException {
		return conseillerDAO.lireToutesLesConseillers();
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IConseillerService#lireUnConseiller(long)
	 */
	@Override
	public Conseiller lireUnConseiller(long idConseiller) throws DAOException {
		return conseillerDAO.lireUnConseiller(idConseiller);
	}
	
	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IConseillerService#lireUnConseiller(java.lang.String)
	 */
	@Override
	public Conseiller lireUnConseiller(String login) throws DAOException {
		return conseillerDAO.lireUnConseiller(login);
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IConseillerService#MAJUnConseiller(com.trio.proxibanquev3.domaine.Conseiller)
	 */
	@Override
	public void MAJUnConseiller(Conseiller conseiller) throws DAOException {
		conseillerDAO.mAJUnConseiller(conseiller);
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IConseillerService#SupprimerUnConseiller(com.trio.proxibanquev3.domaine.Conseiller)
	 */
	@Override
	public void SupprimerUnConseiller(Conseiller conseiller) throws DAOException {
		conseillerDAO.supprimerUnConseiller(conseiller);
	}

}
