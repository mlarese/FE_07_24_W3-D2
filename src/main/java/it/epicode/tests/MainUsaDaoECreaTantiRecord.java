package it.epicode.tests;

import com.github.javafaker.Faker;
import it.epicode.dao.AutoreDAO;
import it.epicode.entity.Autore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainUsaDaoECreaTantiRecord {

        public static void main(String[] args) {
            // recupero i dati da persistence.xml con la classe Persistence e creo il collegamento con db EntityManagerFactory
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");

            // uso il factory per creare dei gestori entità che sono le classi java che rappresentano le tabelle del db
            // questo gestore ha i metodi che salvano cancellano e recuperano i dati da db
            EntityManager em = emf.createEntityManager();
            Faker faker = new Faker(new Locale("it"));

            AutoreDAO autoreDAO = new AutoreDAO(em);
            List<Autore> lista = new ArrayList<>();

            for (int i = 0; i < 20; i++) {
                Autore a = new Autore();
                a.setNome(faker.name().firstName());
                a.setCognome(faker.name().lastName());
                a.setAnnoNascita(faker.number().numberBetween(1900, 2021));

                lista.add(a);

            }

            autoreDAO.insertAll(lista);

        }
}
