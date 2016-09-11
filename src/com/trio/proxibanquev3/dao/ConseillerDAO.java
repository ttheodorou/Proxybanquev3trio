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

import com.trio.proxibanquev3.domaine.Conseiller;
import com.trio.proxibanquev3.exception.DAOException;

/**
 ** Classe permettant d'utiliser un objet ConseillerDAO en charge de l'ecriture
 * et
 * <p>
 * de la lecture des Conseillers dans la base de donnée.
 * <p>
 * 
 * @author Vincent Blameble
 *
 */
public class ConseillerDAO {
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

	public void creerUnConseiller(Conseiller conseiller) throws DAOException {
		try {
			startContext();
			tx.begin();
			em.persist(conseiller);
			tx.commit();
			closeContext();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: sauvegarde du conseiller impossible");
		} finally {
			closeContext();
		}
	}

	public List<Conseiller> lireToutesLesConseillers() throws DAOException {
		List<Conseiller> conseillers = new ArrayList<Conseiller>();
		try {
			startContext();
			tx.begin();
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Conseiller> criteriaRequete = criteriaBuilder.createQuery(Conseiller.class);
			Root<Conseiller> fromConseiller = criteriaRequete.from(Conseiller.class);
			criteriaRequete.select(fromConseiller);
			TypedQuery<Conseiller> requete = em.createQuery(criteriaRequete);
			conseillers = requete.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: récupération de la liste de conseillers impossible");
		} finally {
			closeContext();
		}
		return conseillers;
	}

	public Conseiller lireUnConseiller(long idConseiller) throws DAOException {
		Conseiller conseiller = null;

		try {
			startContext();
			tx.begin();

			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Conseiller> criteriaRequete = criteriaBuilder.createQuery(Conseiller.class);
			Root<Conseiller> fromConseiller = criteriaRequete.from(Conseiller.class);
			criteriaRequete.select(fromConseiller);
			criteriaRequete.where(criteriaBuilder.equal(fromConseiller.get("idPersonne"), idConseiller));
			TypedQuery<Conseiller> requete = em.createQuery(criteriaRequete);
			conseiller = requete.getSingleResult();

			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: la lecture du conseiller avec l'id " + idConseiller
					+ " est impossible");
		} finally {
			closeContext();
		}
		return conseiller;
	}

	public void MAJUnConseiller(Conseiller conseiller) throws DAOException {
		try {
			startContext();
			tx.begin();
			conseiller = em.merge(conseiller);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: modification du conseiller impossible");
		} finally {
			closeContext();
		}
	}

	public void SupprimerUnConseiller(Conseiller conseiller) throws DAOException {
		try {
			startContext();
			tx.begin();
			conseiller = em.merge(conseiller);
			em.remove(conseiller);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: suppression du conseiller impossible");
		} finally {
			closeContext();
		}
	}

	public boolean Authentification(String login, String password) throws DAOException {

		String mdp = null;

		try {
			startContext();
			tx.begin();

			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<String> criteriaRequete = criteriaBuilder.createQuery(String.class);
			Root<Conseiller> fromConseiller = criteriaRequete.from(Conseiller.class);
			criteriaRequete.multiselect(fromConseiller.get("password"));	
			criteriaRequete.where(criteriaBuilder.equal(fromConseiller.get("login"), login));
			TypedQuery<String> requete = em.createQuery(criteriaRequete);
			mdp = requete.getSingleResult();

			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException(
					"probleme dans la couche DAO: la lecture du password lié au login " + login + " est impossible");
		} finally {
			closeContext();
		}
		if (password.equalsIgnoreCase(mdp)) {
			return true;
		} else {
			return false;
		}

	}

}
