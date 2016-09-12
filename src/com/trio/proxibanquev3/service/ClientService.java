/**
 * 
 */
package com.trio.proxibanquev3.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.trio.proxibanquev3.dao.ClientDAO;
import com.trio.proxibanquev3.dao.IClientDAO;
import com.trio.proxibanquev3.domaine.Client;
import com.trio.proxibanquev3.exception.DAOException;

/**
 * Classe permettant d'utiliser un objet ClientService en charge des
 * <p>
 * opérations en lien avec les clients.
 * 
 * @author Vincent Blameble
 *
 */
// @Model
public class ClientService implements IClientService {

	//@Inject
	ClientDAO clientDAO= new ClientDAO();

	public ClientService() {
		System.out.println("debut construction Client Service");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.trio.proxibanquev3.service.IClientService#creerUnClient(com.trio.
	 * proxibanquev3.domaine.Client)
	 */
	@Override
	public void creerUnClient(Client client) throws DAOException {
		clientDAO.creerUnClient(client);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.trio.proxibanquev3.service.IClientService#lireToutesLesClients()
	 */
	@Override
	public List<Client> lireToutesLesClients() throws DAOException {
		return clientDAO.lireToutesLesClients();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.trio.proxibanquev3.service.IClientService#lireUnClient(long)
	 */
	@Override
	public Client lireUnClient(long idClient) throws DAOException {
		return clientDAO.lireUnClient(idClient);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.trio.proxibanquev3.service.IClientService#mAJUnClient(com.trio.
	 * proxibanquev3.domaine.Client)
	 */
	@Override
	public void mAJUnClient(Client client) throws DAOException {
		clientDAO.mAJUnClient(client);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.trio.proxibanquev3.service.IClientService#supprimerUnClient(com.trio.
	 * proxibanquev3.domaine.Client)
	 */
	@Override
	public void supprimerUnClient(Client client) throws DAOException {
		clientDAO.supprimerUnClient(client);
	}
	
	

	@PostConstruct
	public void logapresconstruction(){
		System.out.println("DAO construit client");
	}

}
