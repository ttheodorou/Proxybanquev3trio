package com.trio.proxibanquev3.dao;

import java.util.List;

import com.trio.proxibanquev3.domaine.Conseiller;
import com.trio.proxibanquev3.exception.DAOException;

public interface IConseillerDAO {

	void startContext();

	void closeContext();

	void creerUnConseiller(Conseiller conseiller) throws DAOException;

	List<Conseiller> lireToutesLesConseillers() throws DAOException;

	Conseiller lireUnConseiller(long idConseiller) throws DAOException;

	void mAJUnConseiller(Conseiller conseiller) throws DAOException;

	void supprimerUnConseiller(Conseiller conseiller) throws DAOException;

	boolean authentification(String login, String password) throws DAOException;

}