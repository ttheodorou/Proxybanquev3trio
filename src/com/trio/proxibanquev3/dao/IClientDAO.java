package com.trio.proxibanquev3.dao;

import java.util.List;

import com.trio.proxibanquev3.domaine.Client;
import com.trio.proxibanquev3.domaine.Conseiller;
import com.trio.proxibanquev3.exception.DAOException;

public interface IClientDAO {

	void startContext();

	void closeContext();

	void creerUnClient(Client client) throws DAOException;

	List<Client> lireToutesLesClients() throws DAOException;

	List<Client> lireToutesLesClientsByidConseiller(long idConseiller) throws DAOException;

	List<Client> lireToutesLesClientsByidConseiller(Conseiller conseiller) throws DAOException;

	Client lireUnClient(long idClient) throws DAOException;

	void mAJUnClient(Client client) throws DAOException;

	void supprimerUnClient(Client client) throws DAOException;

}