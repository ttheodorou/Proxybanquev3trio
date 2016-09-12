/**
 * 
 */
package com.trio.proxibanquev3.service;

import java.util.List;

import com.trio.proxibanquev3.dao.ConseillerDAO;
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
public class ConseillerService {

	private ConseillerDAO conseillerDAO = new ConseillerDAO();

	public void creerUnConseiller(Conseiller conseiller) throws DAOException {
		conseillerDAO.creerUnConseiller(conseiller);
	}

	public List<Conseiller> lireToutesLesConseillers() throws DAOException {
		return conseillerDAO.lireToutesLesConseillers();
	}

	public Conseiller lireUnConseiller(long idConseiller) throws DAOException {
		return conseillerDAO.lireUnConseiller(idConseiller);
	}

	public void MAJUnConseiller(Conseiller conseiller) throws DAOException {
		conseillerDAO.mAJUnConseiller(conseiller);
	}

	public void SupprimerUnConseiller(Conseiller conseiller) throws DAOException {
		conseillerDAO.supprimerUnConseiller(conseiller);
	}

}
