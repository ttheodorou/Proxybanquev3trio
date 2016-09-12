package com.trio.proxibanquev3.dao;

import java.util.List;

import com.trio.proxibanquev3.domaine.Adresse;
import com.trio.proxibanquev3.exception.DAOException;

public interface IAdresseDAO {

	void startContext();

	void closeContext();

	void creerUneAdresse(Adresse adresse) throws DAOException;

	List<Adresse> lireToutesLesAdresses() throws DAOException;

	Adresse lireUneAdresse(long idAdresse) throws DAOException;

	void mAJUneAdresse(Adresse adresse) throws DAOException;

	void supprimerUneAdresse(Adresse adresse) throws DAOException;

}