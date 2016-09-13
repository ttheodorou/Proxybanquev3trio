package com.trio.proxibanquev3.presentation;

import com.trio.proxibanquev3.domaine.Conseiller;
import com.trio.proxibanquev3.exception.DAOException;
import com.trio.proxibanquev3.service.AuthService;
import com.trio.proxibanquev3.service.ConseillerService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by Stagiaire on 12/09/2016.
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{

    private static final long serialVersionUID = 1L;



    private String login;
    private String password;

    private boolean loggedIn;

//    @Inject
    private AuthService authService;
    private ConseillerService conseillerService;
    private Conseiller conseiller;


    @ManagedProperty(value="#{navigateBean}")
    private NavigateBean navigateBean;


    public LoginBean() {
        loggedIn = false;
        authService = new AuthService();
        conseillerService = new ConseillerService();
        conseiller = null;
    }

    public String doLogin(){

        try {
            boolean isValidConseiller = authService.authentification(login, password);

             if(isValidConseiller){
                 loggedIn = true;
                 conseiller = conseillerService.lireUnConseiller(login);
                 return navigateBean.redirectToMenuConseiller();

             }else{
                 loggedIn = false;
                 conseiller = null;

                 FacesMessage msg = new FacesMessage("Erreur de login ou de password !", "MESSAGE D'ERREUR");
                 msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                 FacesContext.getCurrentInstance().addMessage(null, msg);

                 return navigateBean.toLogin();
             }

        } catch (DAOException e) {

            e.printStackTrace();
            loggedIn = false;
            conseiller = null;

            return navigateBean.redirectToError(e.getMessage());

        }
    }


    public String disconnect(){
        loggedIn = false;
        password = null;
        login = null;

        conseiller = null;

        return navigateBean.redirectToLogin();
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setNavigateBean(NavigateBean navigateBean) {
        this.navigateBean = navigateBean;
    }

    public NavigateBean getNavigateBean(){
        return navigateBean;
    }

    public Conseiller getConseiller() {
        return conseiller;
    }

    public void setConseiller(Conseiller conseiller) {
        this.conseiller = conseiller;
    }
}
