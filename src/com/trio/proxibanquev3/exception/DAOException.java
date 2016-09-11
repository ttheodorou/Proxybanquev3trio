package com.trio.proxibanquev3.exception;

import java.io.IOException;

/**
 * Classe permettant de signaler des exceptions provenant de la couche DAO
 *<p>
 *Une DAOException dispose d'un message associé fourni lors de sa création.
 *<p>
 * @author Vincent Blameble
 *
 */
public class DAOException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DAOException(String message) {
		super(message);
	}
	

}
