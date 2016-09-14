package com.trio.proxibanquev3.service;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Guillaume on 13/09/2016.
 */
@WebListener
public class PersistanceService implements ServletContextListener {

    private final static Logger logger = Logger.getLogger(PersistanceService.class);

    private static EntityManagerFactory emf;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        logger.debug("On tente de lancer le service de persistance les gars !!");
        emf = Persistence.createEntityManagerFactory("proxibanquev3-pu");
        logger.debug("On a lancé le service de persistance les gars !! (peut avoir échoué)");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        logger.debug("On tente d'arrêter le service de persistance les gars !!");
        emf.close();
        logger.debug("On a arrêté le service de persistance les gars !! (peut avoir échoué)");
    }

    public static EntityManager createEntityManager() {

        logger.debug("On fait une demande de création d'entityManager");

        if (emf == null) {

            logger.error("L'entityManagerFactory est en rade pour toute la durée de vie de l'application, désolé.");
            throw new IllegalStateException("Context is not initialized yet.");
        }

        return emf.createEntityManager();
    }
}
