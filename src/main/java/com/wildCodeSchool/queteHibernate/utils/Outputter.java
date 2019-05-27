package com.wildCodeSchool.queteHibernate.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wildCodeSchool.queteHibernate.entities.Wilder;
import com.wildCodeSchool.queteHibernate.repositories.WilderDao;


@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("Wilder");

    @Autowired
    private WilderDao wilderDao;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD
        LOG.info("******************");
        LOG.info("Objects in DB : " + wilderDao.count());

        // Crée un nouvel utilisateur et l'enregistre dans la BDD
        Wilder user1 = new Wilder("Brenda", "Wildeuse", 19);
        LOG.info("******************");
        LOG.info(user1 + " has been created !");
        wilderDao.save(user1);
        LOG.info(user1 + " has been saved !");

        // Crée un second utilisateur et l'enregistre dans la BDD
        Wilder user2 = new Wilder("Brandon", "Wilder", 33);
        LOG.info("******************");
        LOG.info(user2 + " has been created !");
        wilderDao.save(user2);
        LOG.info(user2 + " has been saved !");

        // Lit les informations correspondant au second utilisateur
        Wilder tempUser = wilderDao.findById(2L).get(); /* On écrit "2L" car
                                                       le type de l'id est Long */
        LOG.info("******************");
        LOG.info("Second user's firstName is " + tempUser.getFirstName());
        LOG.info("Second user's lastName is " + tempUser.getLastName());
        LOG.info("Second user's age is " + tempUser.getAge());

        // Liste les utilisateurs enregistrés dans la BDD
        LOG.info("******************");
        LOG.info("Users in list are ");
        for(Wilder myUser : wilderDao.findAll()) {
            LOG.info(myUser.toString());
        };

        // Supprime le second utilisateur de la BDD
        wilderDao.deleteById(2L); /* risque de provoquer une erreur si
                                tu n'as pas vidé ta table avant de relancer
                                ton application ! */

        /*     Liste les utilisateurs enregistrés dans la BDD
             (permet de vérifier que le second utilisateur
             a bien été supprimé de la BDD) */
        LOG.info("******************");
        LOG.info("Users in list are ");
        for(Wilder myUser : wilderDao.findAll()) {
            LOG.info(myUser.toString());
        };
    }
}
