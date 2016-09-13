package com.trio.proxibanquev3.service;

import com.trio.proxibanquev3.exception.DAOException;

public interface IAuthService {

	/**
	 * renvoie un objet boolean. Si un conseiller est trouvé en base avec le
	 * <p>
	 * login , une comparaison des password est effectué. Si les passwords sont
	 * <p>
	 * identique alors le boolean renvoyé est egale a true. En cas d erreur ou
	 * <p>
	 * d'incohérence le boolean est renvoyé a false
	 * 
	 * 
	 * @param login
	 *            login a verifié
	 * @param password
	 *            password a verifié
	 * @return un boolean
	 * @throws DAOException
	 *             renvoie une DAOexception avec un message
	 */
	boolean authentification(String login, String password) throws DAOException;

}