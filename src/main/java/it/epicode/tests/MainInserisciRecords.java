package it.epicode.tests;

import com.github.javafaker.Faker;
import it.epicode.entity.Autore;
import it.epicode.entity.CasaEditrice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Locale;

public class MainInserisciRecords {
    public static void main(String[] args) {
        // crea dati random in lingua italiana
        Faker faker = new Faker(new Locale("it"));

        // recupero i dati da persistence.xml con la classe Persistence e creo il collegamento con db EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");

        // uso il factory per creare dei gestori entità che sono le classi java che rappresentano le tabelle del db
        // questo gestore ha i metodi che salvano cancellano e recuperano i dati da db
        EntityManager em = emf.createEntityManager();


        // inserisco 40 autori e 40 case editrici random

        // per eseguire l'inserimento devo iniziare una transazione in modo di fare il commit alla fine della transazione stessa
        em.getTransaction().begin();
        for (int i = 0; i < 40; i++) {
            Autore autore = new Autore();
            autore.setNome(faker.name().firstName());
            autore.setCognome(faker.name().lastName());
            autore.setAnnoNascita(faker.number().numberBetween(1900, 2021));

            CasaEditrice casaEditrice = new CasaEditrice();
            casaEditrice.setNome(faker.company().name());
            casaEditrice.setCitta(faker.address().city());
            casaEditrice.setEmail(faker.internet().emailAddress());
            casaEditrice.setTelefono(faker.phoneNumber().phoneNumber());


            // salvo con persist l'oggetto autore e casaEditrice
            em.persist(autore);
            em.persist(casaEditrice);


        }
        // faccio il commit della transazione
        em.getTransaction().commit();
        // chiudo il gestore entità e il factory
        em.close();
        emf.close();
    }
}
