package com.trio.proxibanquev3.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.trio.proxibanquev3.domaine.Client;
import com.trio.proxibanquev3.domaine.CompteBancaire;
import com.trio.proxibanquev3.exception.DAOException;

/**
 ** Classe permettant d'utiliser un objet CompteBancaireDAO en charge de
 * l'ecriture et
 * <p>
 * de la lecture des Comptes Bancaires dans la base de donnée.
 * <p>
 * 
 * @author Vincent Blameble
 *
 */
public class CompteBancaireDAO {
	// private EntityManagerFactory emf =
	// Persistence.createEntityManagerFactory("proxibanquev3-pu");
	private EntityManagerFactory emf = EntityManagerFactorySingleton.Instance();
	private EntityManager em = null;
	private EntityTransaction tx = null;

	public void startContext() {
		if (em == null) {
			em = emf.createEntityManager();
			tx = em.getTransaction();
		}
	}

	public void closeContext() {
		if (em != null) {
			em.close();
			em = null;
		}
	}

	public void creerUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException {
		try {
			startContext();
			tx.begin();
			em.persist(compteBancaire);
			tx.commit();
			closeContext();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: sauvegarde du compte bancaire impossible");
		} finally {
			closeContext();
		}
	}

	public List<CompteBancaire> lireToutesLesCompteBancaires() throws DAOException {
		List<CompteBancaire> comptesBancaires = new ArrayList<CompteBancaire>();
		try {
			startContext();
			startContext();
			tx.begin();
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<CompteBancaire> criteriaRequete = criteriaBuilder.createQuery(CompteBancaire.class);
			Root<CompteBancaire> fromcompteBancaire = criteriaRequete.from(CompteBancaire.class);
			criteriaRequete.select(fromcompteBancaire);
			TypedQuery<CompteBancaire> requete = em.createQuery(criteriaRequete);
			comptesBancaires = requete.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException(
					"probleme dans la couche DAO: récupération de la liste de comptes bancaires impossible");
		} finally {
			closeContext();
		}
		return comptesBancaires;
	}

	public List<CompteBancaire> lireToutesLesCompteBancairesByClient(long idClient) throws DAOException {
		List<CompteBancaire> comptesBancaires = new ArrayList<CompteBancaire>();
		try {
			startContext();
			startContext();
			tx.begin();
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<CompteBancaire> criteriaRequete = criteriaBuilder.createQuery(CompteBancaire.class);
			Root<CompteBancaire> fromcompteBancaire = criteriaRequete.from(CompteBancaire.class);
			criteriaRequete.select(fromcompteBancaire);
			criteriaRequete.where(criteriaBuilder.equal(fromcompteBancaire.get("proprietaire_idPersonne"), idClient));
			TypedQuery<CompteBancaire> requete = em.createQuery(criteriaRequete);
			comptesBancaires = requete.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException(
					"probleme dans la couche DAO: récupération de la liste de comptes bancaires impossible");
		} finally {
			closeContext();
		}
		return comptesBancaires;
	}

	public List<CompteBancaire> lireToutesLesCompteBancairesByClient(Client client) throws DAOException {
		List<CompteBancaire> comptesBancaires = new ArrayList<CompteBancaire>();
		try {
			startContext();
			startContext();
			tx.begin();
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<CompteBancaire> criteriaRequete = criteriaBuilder.createQuery(CompteBancaire.class);
			Root<CompteBancaire> fromcompteBancaire = criteriaRequete.from(CompteBancaire.class);
			criteriaRequete.select(fromcompteBancaire);
			criteriaRequete.where(
					criteriaBuilder.equal(fromcompteBancaire.get("proprietaire_idPersonne"), client.getIdPersonne()));
			TypedQuery<CompteBancaire> requete = em.createQuery(criteriaRequete);
			comptesBancaires = requete.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException(
					"probleme dans la couche DAO: récupération de la liste de comptes bancaires du client impossible");
		} finally {
			closeContext();
		}
		return comptesBancaires;
	}

	public CompteBancaire lireUnCompteBancaire(long idCompteBancaire) throws DAOException {
		CompteBancaire compteBancaire = null;
		try {
			startContext();
			tx.begin();

			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<CompteBancaire> criteriaRequete = criteriaBuilder.createQuery(CompteBancaire.class);
			Root<CompteBancaire> fromcompteBancaire = criteriaRequete.from(CompteBancaire.class);
			criteriaRequete.select(fromcompteBancaire);
			criteriaRequete.where(criteriaBuilder.equal(fromcompteBancaire.get("idCompte"), idCompteBancaire));
			TypedQuery<CompteBancaire> requete = em.createQuery(criteriaRequete);
			compteBancaire = requete.getSingleResult();

			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: la lecture du compte bancaire avec l'id "
					+ idCompteBancaire + " est impossible");
		} finally {
			closeContext();
		}
		return compteBancaire;
	}

	public void MAJUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException {
		try {
			startContext();
			tx.begin();
			compteBancaire = em.merge(compteBancaire);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: modification du compte bancaire impossible");
		} finally {
			closeContext();
		}
	}

	public void SupprimerUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException {
		try {
			startContext();
			tx.begin();
			compteBancaire = em.merge(compteBancaire);
			em.remove(compteBancaire);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: suppression du compte bancaire impossible");
		} finally {
			closeContext();
		}
	}
}