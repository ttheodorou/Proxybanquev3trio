/**
 * 
 */
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

import com.trio.proxibanquev3.domaine.Adresse;
import com.trio.proxibanquev3.exception.DAOException;

/**
 * Classe permettant d'utiliser un objet AdresseDAO en charge de l'ecriture et
 * <p>
 * de la lecture des Adresse dans la base de donnée.
 * 
 * @author Vincent Blameble
 *
 */
public class AdresseDAO {

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

	public void creerUneAdresse(Adresse adresse) throws DAOException {
		try {
			startContext();
			tx.begin();
			em.persist(adresse);
			tx.commit();
			closeContext();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: sauvegarde de l'adresse impossible");
		} finally {
			closeContext();
		}
	}

	public List<Adresse> lireToutesLesAdresses() throws DAOException {
		List<Adresse> adresses = new ArrayList<Adresse>();
		try {
			startContext();
			tx.begin();
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Adresse> criteriaRequete = criteriaBuilder.createQuery(Adresse.class);
			Root<Adresse> fromadresse = criteriaRequete.from(Adresse.class);
			criteriaRequete.select(fromadresse);
			TypedQuery<Adresse> requete = em.createQuery(criteriaRequete);
			adresses = requete.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: récupération de la liste d'adresse impossible");
		} finally {
			closeContext();
		}
		return adresses;
	}

	public Adresse lireUneAdresse(long idAdresse) throws DAOException {
		Adresse adresse = null;
		try {
			startContext();
			tx.begin();

			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Adresse> criteriaRequete = criteriaBuilder.createQuery(Adresse.class);
			Root<Adresse> fromadresse = criteriaRequete.from(Adresse.class);
			criteriaRequete.select(fromadresse);
			criteriaRequete.where(criteriaBuilder.equal(fromadresse.get("idAdresse"), idAdresse));
			TypedQuery<Adresse> requete = em.createQuery(criteriaRequete);
			adresse = requete.getSingleResult();

			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException(
					"probleme dans la couche DAO: la lecture de l'adresse avec l'id " + idAdresse + " est impossible");
		} finally {
			closeContext();
		}
		return adresse;
	}

	public void MAJUneAdresse(Adresse adresse) throws DAOException {
		try {
			startContext();
			tx.begin();
			adresse = em.merge(adresse);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: modification de l'adresse impossible");
		} finally {
			closeContext();
		}
	}

	public void SupprimerUneAdresse(Adresse adresse) throws DAOException {
		try {
			startContext();
			tx.begin();
			adresse = em.merge(adresse);
			em.remove(adresse);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: suppression de l'adresse impossible");
		} finally {
			closeContext();
		}
	}

}
