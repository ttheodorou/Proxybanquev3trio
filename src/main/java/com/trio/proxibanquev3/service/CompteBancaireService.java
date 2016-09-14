package com.trio.proxibanquev3.service;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.trio.proxibanquev3.dao.CompteBancaireDAO;
import com.trio.proxibanquev3.dao.ICompteBancaireDAO;
import com.trio.proxibanquev3.domaine.Client;
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
//@Model
public class CompteBancaireService implements ICompteBancaireService {

	//@Inject
	private CompteBancaireDAO compteBancaireDAO= new CompteBancaireDAO();

	
	 
	
	
	
	private boolean debite(CompteBancaire compteDebite, double montant) throws ServiceException {
		boolean goodWork = true;
		try {
			compteDebite.setSolde(compteDebite.getSolde()-montant);
			compteBancaireDAO.mAJUnCompteBancaire(compteDebite);
		} catch (DAOException e) {
			goodWork = false;
			compteDebite.setSolde(compteDebite.getSolde()+montant);
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
			compteCredite.setSolde(compteCredite.getSolde()+montant);
			compteBancaireDAO.mAJUnCompteBancaire(compteCredite);
		} catch (DAOException e) {
			goodWork = false;
			compteCredite.setSolde(compteCredite.getSolde()-montant);
			throw new ServiceException(
					"probleme dans la couche service au niveau du credit du compte: " + e.getMessage());
		} catch (Exception e) {
			goodWork = false;
			throw new ServiceException("probleme dans la couche service au niveau du credit du compte");
		}

		return goodWork;

	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.ICompteBancaireService#virement(com.trio.proxibanquev3.domaine.CompteBancaire, com.trio.proxibanquev3.domaine.CompteBancaire, double)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.ICompteBancaireService#creerUnCompteBancaire(com.trio.proxibanquev3.domaine.CompteBancaire)
	 */
	@Override
	public void creerUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException {
		compteBancaireDAO.creerUnCompteBancaire(compteBancaire);
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.ICompteBancaireService#lireToutesLesCompteBancaires()
	 */
	@Override
	public List<CompteBancaire> lireToutesLesCompteBancaires() throws DAOException {
		return compteBancaireDAO.lireToutesLesCompteBancaires();
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.ICompteBancaireService#lireUnCompteBancaire(long)
	 */
	@Override
	public CompteBancaire lireUnCompteBancaire(long idCompteBancaire) throws DAOException {
		return compteBancaireDAO.lireUnCompteBancaire(idCompteBancaire);
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.ICompteBancaireService#mAJUnCompteBancaire(com.trio.proxibanquev3.domaine.CompteBancaire)
	 */
	@Override
	public void mAJUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException {
		compteBancaireDAO.mAJUnCompteBancaire(compteBancaire);
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.ICompteBancaireService#supprimerUnCompteBancaire(com.trio.proxibanquev3.domaine.CompteBancaire)
	 */
	@Override
	public void supprimerUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException {
		compteBancaireDAO.supprimerUnCompteBancaire(compteBancaire);
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.ICompteBancaireService#lireToutesLesCompteBancairesByClient(long)
	 */
	@Override
	public List<CompteBancaire> lireToutesLesCompteBancairesByClient(long idClient) throws DAOException {
		return compteBancaireDAO.lireToutesLesCompteBancairesByClient( idClient);
	}

	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.ICompteBancaireService#lireToutesLesCompteBancairesByClient(com.trio.proxibanquev3.domaine.Client)
	 */
	@Override
	public List<CompteBancaire> lireToutesLesCompteBancairesByClient(Client client) throws DAOException {
		return compteBancaireDAO.lireToutesLesCompteBancairesByClient(client);
	}

}
