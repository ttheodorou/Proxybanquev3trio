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
import com.trio.proxibanquev3.domaine.Conseiller;
import com.trio.proxibanquev3.exception.DAOException;

/**
 * Classe permettant d'utiliser un objet ClientDAO en charge de l'ecriture et
 * <p>
 * de la lecture des Clients dans la base de donnée.
 * <p>
 * 
 * @author Vincent Blameble
 *
 */
public class ClientDAO {

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

	public void creerUnClient(Client client) throws DAOException {
		try {
			startContext();
			tx.begin();
			em.persist(client);
			tx.commit();
			closeContext();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: sauvegarde du client impossible");
		} finally {
			closeContext();
		}
	}

	public List<Client> lireToutesLesClients() throws DAOException {
		List<Client> clients = new ArrayList<Client>();
		try {
			startContext();
			tx.begin();
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Client> criteriaRequete = criteriaBuilder.createQuery(Client.class);
			Root<Client> fromclient = criteriaRequete.from(Client.class);
			criteriaRequete.select(fromclient);
			TypedQuery<Client> requete = em.createQuery(criteriaRequete);
			clients = requete.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: récupération de la liste de clients impossible");
		} finally {
			closeContext();
		}
		return clients;
	}
	
	public List<Client> lireToutesLesClientsByidConseiller(long idConseiller) throws DAOException {
		List<Client> clients = new ArrayList<Client>();
		try {
			startContext();
			tx.begin();
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Client> criteriaRequete = criteriaBuilder.createQuery(Client.class);
			Root<Client> fromclient = criteriaRequete.from(Client.class);
			criteriaRequete.select(fromclient);
			criteriaRequete.where(criteriaBuilder.equal(fromclient.get("conseiller_idPersonne"), idConseiller));
			TypedQuery<Client> requete = em.createQuery(criteriaRequete);
			clients = requete.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: récupération de la liste de clients du conseiller impossible");
		} finally {
			closeContext();
		}
		return clients;
	}

	public List<Client> lireToutesLesClientsByidConseiller(Conseiller conseiller) throws DAOException {
		List<Client> clients = new ArrayList<Client>();
		try {
			startContext();
			tx.begin();
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Client> criteriaRequete = criteriaBuilder.createQuery(Client.class);
			Root<Client> fromclient = criteriaRequete.from(Client.class);
			criteriaRequete.select(fromclient);
			criteriaRequete.where(criteriaBuilder.equal(fromclient.get("conseiller_idPersonne"), conseiller.getIdPersonne()));
			TypedQuery<Client> requete = em.createQuery(criteriaRequete);
			clients = requete.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: récupération de la liste de clients du conseiller impossible");
		} finally {
			closeContext();
		}
		return clients;
	}
	public Client lireUnClient(long idClient) throws DAOException {
		Client client = null;
		try {
			startContext();
			tx.begin();

			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Client> criteriaRequete = criteriaBuilder.createQuery(Client.class);
			Root<Client> fromclient = criteriaRequete.from(Client.class);
			criteriaRequete.select(fromclient);
			criteriaRequete.where(criteriaBuilder.equal(fromclient.get("idPersonne"), idClient));
			TypedQuery<Client> requete = em.createQuery(criteriaRequete);
			client = requete.getSingleResult();

			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException(
					"probleme dans la couche DAO: la lecture du client avec l'id " + idClient + " est impossible");
		} finally {
			closeContext();
		}
		return client;
	}

	public void mAJUnClient(Client client) throws DAOException {
		try {
			startContext();
			tx.begin();
			client = em.merge(client);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: modification du client impossible");
		} finally {
			closeContext();
		}
	}

	public void supprimerUnClient(Client client) throws DAOException {
		try {
			startContext();
			tx.begin();
			client = em.merge(client);
			em.remove(client);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new DAOException("probleme dans la couche DAO: suppression du client impossible");
		} finally {
			closeContext();
		}
	}

}
