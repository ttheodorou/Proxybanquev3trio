package com.trio.proxibanquev3.service;

import java.util.List;

import com.trio.proxibanquev3.domaine.Client;
import com.trio.proxibanquev3.exception.DAOException;

public interface IClientService {

	void creerUnClient(Client client) throws DAOException;

	List<Client> lireToutesLesClients() throws DAOException;

	Client lireUnClient(long idClient) throws DAOException;

	void mAJUnClient(Client client) throws DAOException;

	void supprimerUnClient(Client client) throws DAOException;

}