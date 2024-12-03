package it.epicode.tests;

import it.epicode.entity.Autore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainTestDatiInseriti
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");

        // uso il factory per creare dei gestori entità che sono le classi java che rappresentano le tabelle del db
        // questo gestore ha i metodi che salvano cancellano e recuperano i dati da db
        EntityManager em = emf.createEntityManager();

        Autore autore = em.find(Autore.class, 105L);
        System.out.println(autore);

        em.getTransaction().begin();

            autore.setCognome("De angelis");
            autore.setNome("Roby");

        em.getTransaction().commit();
        em.close();

    }
}
