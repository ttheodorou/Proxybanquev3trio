package com.trio.proxibanquev3.presentation;

import com.trio.proxibanquev3.domaine.Client;
import com.trio.proxibanquev3.exception.DAOException;
import com.trio.proxibanquev3.service.ClientService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

/**
 * Created by Stagiaire on 13/09/2016.
 */
@ManagedBean
@ViewScoped
public class MenuConseillerBean {

    private List<Client> clients;
    private Client selectedClient;


    public MenuConseillerBean() {

        LoginBean loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
        ClientService clientService = new ClientService();

        try {
            clients = clientService.lireToutesLesClientsByidConseiller(loginBean.getConseiller());
            System.out.println();
        } catch (DAOException e) {

            e.printStackTrace();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(loginBean.getNavigateBean().redirectToError(e.getMessage()));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }


    public String doRefresh(){
        LoginBean loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
        ClientService clientService = new ClientService();

        try {
            clients = clientService.lireToutesLesClientsByidConseiller(loginBean.getConseiller());
            System.out.println();
        } catch (DAOException e) {

            e.printStackTrace();
            return loginBean.getNavigateBean().redirectToError(e.getMessage());
        }

        return null;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }
    
}
