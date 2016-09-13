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
public class AuthService implements IAuthService {
	
	//@Inject
	private ConseillerDAO conseillerDAO=new ConseillerDAO();
	
	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IAuthService#authentification(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean authentification(String login,String password) throws DAOException{
		return conseillerDAO.authentification(login,password);
	}

}
