package com.trio.proxibanquev3.service;

import java.util.List;

import com.trio.proxibanquev3.dao.CompteBancaireDAO;
import com.trio.proxibanquev3.domaine.CompteBancaire;
import com.trio.proxibanquev3.exception.DAOException;
import com.trio.proxibanquev3.exception.ServiceException;

/**
 * Classe permettant d'utiliser un objet CompteBancaireService en charge des
 * <p>
 * opérations en lien avec les comptes bancaires.
 * 
 * @author Vincent Blameble
 *
 */
public class CompteBancaireService {

	private CompteBancaireDAO compteBancaireDAO = new CompteBancaireDAO();

	private boolean debite(CompteBancaire compteDebite, double montant) throws ServiceException {
		boolean goodWork = true;
		try {
			compteDebite.debite(montant);
			compteBancaireDAO.MAJUnCompteBancaire(compteDebite);
		} catch (DAOException e) {
			goodWork = false;
			compteDebite.credite(montant);
			throw new ServiceException(
					"probleme dans la couche service au niveau du debit du compte: " + e.getMessage());
		} catch (Exception e) {
			goodWork = false;
			throw new ServiceException("probleme dans la couche service au niveau du debit du compte");
		}

		return goodWork;

	}

	private boolean credite(CompteBancaire compteCredite, double montant) throws ServiceException {
		boolean goodWork = true;
		try {
			compteCredite.credite(montant);
			compteBancaireDAO.MAJUnCompteBancaire(compteCredite);
		} catch (DAOException e) {
			goodWork = false;
			compteCredite.debite(montant);
			throw new ServiceException(
					"probleme dans la couche service au niveau du credit du compte: " + e.getMessage());
		} catch (Exception e) {
			goodWork = false;
			throw new ServiceException("probleme dans la couche service au niveau du credit du compte");
		}

		return goodWork;

	}

	public void virement(CompteBancaire compteDebite, CompteBancaire compteCredite, double montant)
			throws ServiceException {
		if (debite(compteDebite, montant)) {
			try {
				credite(compteCredite, montant);
			} catch (ServiceException e) {
				try {
					credite(compteDebite, montant);
					throw new ServiceException("virement interrompu: " + e.getMessage());
				} catch (ServiceException e2) {
					throw new ServiceException(
							"probleme de virement, debit sans credit, reversement impossible pour cause de: "
									+ e2.getMessage());
				}
			}
		}
	}

	public void creerUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException {
		compteBancaireDAO.creerUnCompteBancaire(compteBancaire);
	}

	public List<CompteBancaire> lireToutesLesCompteBancaires() throws DAOException {
		return compteBancaireDAO.lireToutesLesCompteBancaires();
	}

	public CompteBancaire lireUnCompteBancaire(long idCompteBancaire) throws DAOException {
		return compteBancaireDAO.lireUnCompteBancaire(idCompteBancaire);
	}

	public void MAJUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException {
		compteBancaireDAO.MAJUnCompteBancaire(compteBancaire);
	}

	public void SupprimerUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException {
		compteBancaireDAO.SupprimerUnCompteBancaire(compteBancaire);
	}

}
