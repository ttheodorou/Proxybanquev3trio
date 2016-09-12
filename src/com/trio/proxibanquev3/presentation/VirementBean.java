package com.trio.proxibanquev3.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.trio.proxibanquev3.domaine.Client;
import com.trio.proxibanquev3.domaine.CompteBancaire;
import com.trio.proxibanquev3.exception.DAOException;
import com.trio.proxibanquev3.service.ClientService;

@ManagedBean(name = "virementbean")
@SessionScoped
public class VirementBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Client> listeDesClients = new ArrayList<Client>();
	private List<CompteBancaire> listeDesComptes = new ArrayList<CompteBancaire>();
	private String client;
	private String compte;
	private Map<String, String> clients;
	private Map<String, String> comptes;

	private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();

	public Map<String, String> getClients() {
		return clients;
	}

	public void setClients(Map<String, String> clients) {
		this.clients = clients;
	}

	public Map<String, String> getComptes() {
		return comptes;
	}

	public void setComptes(Map<String, String> comptes) {
		this.comptes = comptes;
	}

	public void setData(Map<String, Map<String, String>> data) {
		this.data = data;
	}

	ClientService clientService = new ClientService();

	@PostConstruct
	public void init() {
		try {
			listeDesClients = clientService.lireToutesLesClients();
			clients = new HashMap<String, String>();
			int tailleListeDesClients = listeDesClients.size();

			for (int i = 0; i < tailleListeDesClients; i++) {
				String prenom = listeDesClients.get(i).getPrenom();
				String nom = listeDesClients.get(i).getNom();
				long id = listeDesClients.get(i).getIdPersonne();
				String prenomEtNom = prenom + " " + nom + ", id : " + String.valueOf(id);
				clients.put(prenomEtNom, prenomEtNom);
				Map<String, String> map = new HashMap<String, String>();
				listeDesComptes = listeDesClients.get(i).getComptes();
				int tailleListeDesComptes = listeDesComptes.size();
				for (int j = 0; j < tailleListeDesComptes; j++) {
					long numCompte = listeDesComptes.get(j).getNumCompte();
					String numeroDeCompte = String.valueOf(numCompte);
					double sld = listeDesComptes.get(j).getSolde();
					String solde = String.valueOf(sld);
					long idCompte = listeDesComptes.get(j).getIdCompte();
					String idCompteStr = String.valueOf(idCompte);
					String numEtSolde = numeroDeCompte + " solde de : " + solde+" € , id ="+idCompteStr;
					map.put(numEtSolde, numEtSolde);
				}
				data.put(prenomEtNom, map);

			}
			System.out.println("");

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return the listeDesClients
	 */
	public List<Client> getListeDesClients() {
		return listeDesClients;
	}

	/**
	 * @param listeDesClients
	 *            the listeDesClients to set
	 */
	public void setListeDesClients(List<Client> listeDesClients) {
		this.listeDesClients = listeDesClients;
	}

	/**
	 * @return the listeDesComptes
	 */
	public List<CompteBancaire> getListeDesComptes() {
		return listeDesComptes;
	}

	/**
	 * @param listeDesComptes
	 *            the listeDesComptes to set
	 */
	public void setListeDesComptes(List<CompteBancaire> listeDesComptes) {
		this.listeDesComptes = listeDesComptes;
	}

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * @return the compte
	 */
	public String getCompte() {
		return compte;
	}

	/**
	 * @param compte
	 *            the compte to set
	 */
	public void setCompte(String compte) {
		this.compte = compte;
	}

	public Map<String, Map<String, String>> getData() {
		return data;
	}

	public void onCountryChange() {
		
		if (client != null && !client.equals(""))
			comptes = data.get(client);
		else
			comptes = new HashMap<String, String>();
	}

	public void displayLocation() {
		FacesMessage msg;
		if (compte != null && client != null)
			msg = new FacesMessage("Selected", compte + " of " + client);
		else
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
