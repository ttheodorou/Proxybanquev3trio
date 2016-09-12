package com.trio.proxibanquev3.dao;

import java.util.List;

import com.trio.proxibanquev3.domaine.Client;
import com.trio.proxibanquev3.domaine.CompteBancaire;
import com.trio.proxibanquev3.exception.DAOException;

public interface ICompteBancaireDAO {

	void startContext();

	void closeContext();

	void creerUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException;

	List<CompteBancaire> lireToutesLesCompteBancaires() throws DAOException;

	List<CompteBancaire> lireToutesLesCompteBancairesByClient(long idClient) throws DAOException;

	List<CompteBancaire> lireToutesLesCompteBancairesByClient(Client client) throws DAOException;

	CompteBancaire lireUnCompteBancaire(long idCompteBancaire) throws DAOException;

	void mAJUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException;

	void supprimerUnCompteBancaire(CompteBancaire compteBancaire) throws DAOException;

}