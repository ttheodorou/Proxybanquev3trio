/**
 * 
 */
package com.trio.proxibanquev3.service;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.trio.proxibanquev3.dao.ConseillerDAO;
import com.trio.proxibanquev3.dao.IConseillerDAO;
import com.trio.proxibanquev3.exception.DAOException;

/**
 * Classe permettant d'utiliser un objet AdresseService utilise lors des
 * <p>
 * opérations d'identification du use l'application.
 * 
 * @author Vincent Blameble
 *
 */
//@Model
public class AuthService {
	
	//@Inject
	private ConseillerDAO conseillerDAO=new ConseillerDAO();
	
	public boolean authentification(String login,String password) throws DAOException{
		return conseillerDAO.authentification(login,password);
	}

}
