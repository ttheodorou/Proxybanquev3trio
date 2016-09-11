/**
 * 
 */
package com.trio.proxibanquev3.service;

import com.trio.proxibanquev3.dao.ConseillerDAO;
import com.trio.proxibanquev3.exception.DAOException;

/**
 * Classe permettant d'utiliser un objet AdresseService utilise lors des
 * <p>
 * opérations d'identification du use l'application.
 * 
 * @author Vincent Blameble
 *
 */
public class AuthService {
	
	private ConseillerDAO conseillerDAO=new ConseillerDAO();
	
	public boolean Authentification(String login,String password) throws DAOException{
		return conseillerDAO.Authentification(login,password);
	}

}
