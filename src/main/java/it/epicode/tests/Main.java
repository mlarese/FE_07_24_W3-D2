package it.epicode.tests;

import com.github.javafaker.Faker;
import it.epicode.entity.Autore;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker(new Locale("it"));

        // Print examples of numbers
        System.out.println("Numero casuale: " + faker.number().randomDigit());
        System.out.println("Numero casuale tra 1 e 100: " + faker.number().numberBetween(1, 100));

        // Print examples of dates
        System.out.println("Data casuale: " + faker.date().birthday());
        System.out.println("Data futura: " + faker.date().future(10, java.util.concurrent.TimeUnit.DAYS));
        System.out.println("Data passata: " + faker.date().past(10, java.util.concurrent.TimeUnit.DAYS));

        // Print examples of company names
        System.out.println("Nome azienda casuale: " + faker.company().name());
        System.out.println("Slogan azienda: " + faker.company().catchPhrase());

        // Print examples of emails
        System.out.println("Email casuale: " + faker.internet().emailAddress());
        System.out.println("Email professionale: " + faker.internet().safeEmailAddress());

        // Print examples of names
        System.out.println("Nome casuale: " + faker.name().firstName());
//        System.out.println("Cognome casuale: " + faker.name().lastName());
        System.out.println("Nome completo: " + faker.name().fullName());

        // Print examples of addresses
        System.out.println("Indirizzo: " + faker.address().streetAddress());
        System.out.println("Città: " + faker.address().city());
        System.out.println("CAP: " + faker.address().zipCode());

        // Print examples of phone numbers
        System.out.println("Numero di telefono: " + faker.phoneNumber().phoneNumber());
        System.out.println("Cellulare: " + faker.phoneNumber().cellPhone());

        // Print examples of credit card details
        System.out.println("Numero di carta di credito: " + faker.finance().creditCard());
        System.out.println("IBAN: " + faker.finance().iban());

        // Print examples of lorem text
        System.out.println("Testo lorem: " + faker.lorem().sentence());
        System.out.println("Paragrafo lorem: " + faker.lorem().paragraph());

        // Print examples of book details
        System.out.println("Titolo libro: " + faker.book().title());
        System.out.println("Autore libro: " + faker.book().author());

        // Print examples of job details
        System.out.println("Professione: " + faker.job().title());
        System.out.println("Settore: " + faker.job().field());

        // Print examples of food
        System.out.println("Cibo: " + faker.food().dish());
        System.out.println("Ingrediente: " + faker.food().ingredient());


        for (int i = 0; i < 40; i++) {
            Autore a = new Autore();
            a.setNome(faker.name().firstName());
            a.setCognome(faker.name().lastName());
            a.setAnnoNascita(faker.number().numberBetween(1900, 2021));
            System.out.println(a);
        }



    }
}
