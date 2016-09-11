package com.trio.proxibanquev3.exception;

import java.io.IOException;

/**
 * Classe permettant de signaler des exceptions provenant de la couche Service.
 *<p>
 *Une ServiceException dispose d'un message associé fourni lors de sa création.
 *<p>
 * @author Vincent Blameble
 *
 */
public class ServiceException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(String message){
		super(message);
	}
}
