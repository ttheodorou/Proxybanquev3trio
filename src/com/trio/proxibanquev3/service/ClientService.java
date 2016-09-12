/**
 * 
 */
package com.trio.proxibanquev3.service;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

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
@Model
public class ClientService {
	
	@Inject
	private IClientDAO clientDAO;// = new ClientDAO();

	public void creerUnClient(Client client) throws DAOException {
		clientDAO.creerUnClient(client);
	}

	public List<Client> lireToutesLesClients() throws DAOException {
		return clientDAO.lireToutesLesClients();
	}

	public Client lireUnClient(long idClient) throws DAOException {
		return clientDAO.lireUnClient(idClient);
	}

	public void mAJUnClient(Client client) throws DAOException {
		clientDAO.mAJUnClient(client);
	}

	public void supprimerUnClient(Client client) throws DAOException {
		clientDAO.supprimerUnClient(client);
	}

}
