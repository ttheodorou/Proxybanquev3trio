/**
 * 
 */
package com.trio.proxibanquev3.service;

import java.util.List;

import com.trio.proxibanquev3.dao.ClientDAO;
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
public class ClientService {

	private ClientDAO clientDAO = new ClientDAO();

	public void creerUnClient(Client client) throws DAOException {
		clientDAO.creerUnClient(client);
	}

	public List<Client> lireToutesLesClients() throws DAOException {
		return clientDAO.lireToutesLesClients();
	}

	public Client lireUnClient(long idClient) throws DAOException {
		return clientDAO.lireUnClient(idClient);
	}

	public void MAJUnClient(Client client) throws DAOException {
		clientDAO.MAJUnClient(client);
	}

	public void SupprimerUnClient(Client client) throws DAOException {
		clientDAO.SupprimerUnClient(client);
	}

}
