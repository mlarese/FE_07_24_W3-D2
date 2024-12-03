package it.epicode.tests;

import it.epicode.dao.AutoreDAO;
import it.epicode.entity.Autore;
import it.epicode.entity.CasaEditrice;
import it.epicode.dao.CasaEditriceDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainDao
{
    public static void main(String[] args) {

        // recupero i dati da persistence.xml con la classe Persistence e creo il collegamento con db EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");

        // uso il factory per creare dei gestori entità che sono le classi java che rappresentano le tabelle del db
        // questo gestore ha i metodi che salvano cancellano e recuperano i dati da db
        EntityManager em = emf.createEntityManager();

        // inserimento di un record attraverso il dao

        AutoreDAO autoreDao = new AutoreDAO(em);
        Autore a = new Autore();
        a.setNome("Gianni");
        a.setCognome("De angelis");
        a.setAnnoNascita(1990);


        autoreDao.insertAutore(a);


        CasaEditrice c = new CasaEditrice();
        c.setNome("Mondadori");
        c.setCitta("Milano");
        c.setEmail("gianni@email.it");

        CasaEditriceDAO casaEditriceDAO = new CasaEditriceDAO(em);
        casaEditriceDAO.insertCasaEditrice(c);

        em.close();




    }
}
