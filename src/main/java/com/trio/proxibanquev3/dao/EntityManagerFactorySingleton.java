/**
 * 
 */
package com.trio.proxibanquev3.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe permettant d'instancer un unique EntityManagerFactory pour nos DAO.
 * <p>
 * 
 * @author Vincent Blameble
 *
 */
public class EntityManagerFactorySingleton {

	protected String nom;
	protected String adresse;
	protected String email;

	private static EntityManagerFactory _instance = null;

	private EntityManagerFactorySingleton() {
	}

	public static EntityManagerFactory Instance() {
		if (_instance == null)
			_instance = Persistence.createEntityManagerFactory("proxibanquev3-pu");
		return _instance;
	}

	public static void close() {
		if (_instance != null) {
			_instance.close();
			_instance = null;
		}
	}

}
