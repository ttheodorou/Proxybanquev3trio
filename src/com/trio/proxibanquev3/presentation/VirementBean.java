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
public class VirementBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Client> listeDesClients = new ArrayList<Client>();
	private List<CompteBancaire> listeDesComptes = new ArrayList<CompteBancaire>();
	private Client client;
	private CompteBancaire compte;
	private String client2;
	private String compte2;
	private Map<String,String> clients;
	private Map<String,String> comptes;
	
	
	private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
	
	
    private String country; 
    private String city;  
    private Map<String,String> countries;
    private Map<String,String> cities;
    
    ClientService clientService = new ClientService();
    
    @PostConstruct
    public void init() {
    	try {
			listeDesClients = clientService.lireToutesLesClients();
						
			clients  = new HashMap<String, String>();
			int tailleListe = listeDesClients.size();
			
			for (int i = 0; i < tailleListe; i++) {
				String prenom = listeDesClients.get(i).getPrenom();
				String nom = listeDesClients.get(i).getNom();
				long id = listeDesClients.get(i).getIdPersonne();
				String prenomEtNom = prenom +" "+nom+", id : "+String.valueOf(id);
				clients.put(prenomEtNom, prenomEtNom);
			}
			
			
	         
	        Map<String,String> map = new HashMap<String, String>();
	        
	        
	        
	        map.put("New York", "New York");
	        map.put("San Francisco", "San Francisco");
	        map.put("Denver", "Denver");
	        data.put("USA", map);
	         
	        map = new HashMap<String, String>();
	        map.put("Berlin", "Berlin");
	        map.put("Munich", "Munich");
	        map.put("Frankfurt", "Frankfurt");
	        data.put("Germany", map);
	         
	        map = new HashMap<String, String>();
	        map.put("Sao Paolo", "Sao Paolo");
	        map.put("Rio de Janerio", "Rio de Janerio");
	        map.put("Salvador", "Salvador");
	        data.put("Brazil", map);
			
			
			
			
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
	 * @param listeDesClients the listeDesClients to set
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
	 * @param listeDesComptes the listeDesComptes to set
	 */
	public void setListeDesComptes(List<CompteBancaire> listeDesComptes) {
		this.listeDesComptes = listeDesComptes;
	}



	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}



	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}



	/**
	 * @return the compte
	 */
	public CompteBancaire getCompte() {
		return compte;
	}



	/**
	 * @param compte the compte to set
	 */
	public void setCompte(CompteBancaire compte) {
		this.compte = compte;
	}



	public Map<String, Map<String, String>> getData() {
        return data;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public Map<String, String> getCountries() {
        return countries;
    }
 
    public Map<String, String> getCities() {
        return cities;
    }
 
    public void onCountryChange() {
        if(country !=null && !country.equals(""))
            cities = data.get(country);
        else
            cities = new HashMap<String, String>();
    }
     
    public void displayLocation() {
        FacesMessage msg;
        if(city != null && country != null)
            msg = new FacesMessage("Selected", city + " of " + country);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected."); 
             
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
	


	
	
	
	

}
