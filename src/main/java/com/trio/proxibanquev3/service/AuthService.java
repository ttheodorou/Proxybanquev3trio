/**
 * 
 */
package com.trio.proxibanquev3.service;

import com.trio.proxibanquev3.dao.ConseillerDAO;
import com.trio.proxibanquev3.exception.DAOException;
import org.apache.log4j.Logger;

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

	private final static Logger logger = Logger.getLogger(AuthService.class);
	
	//@Inject
	private ConseillerDAO conseillerDAO=new ConseillerDAO();
	
	/* (non-Javadoc)
	 * @see com.trio.proxibanquev3.service.IAuthService#authentification(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean authentification(String login,String password) throws DAOException{
		logger.info("On demande a authentifier un utilisateur comme conseiller pour une session");
		return conseillerDAO.authentification(login,password);
	}

}
