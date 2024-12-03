package it.epicode.dao;

import it.epicode.entity.Autore;
import it.epicode.entity.CasaEditrice;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AutoreDAO {
    private EntityManager em;

    public AutoreDAO(EntityManager em) {
        this.em = em;
    }

    public void insertAutore(Autore autore) {
        em.getTransaction().begin();
        em.persist(autore);
        em.getTransaction().commit();
    }

    public Autore findAutoreById(Long id) {
        return em.find(Autore.class, id);
    }

    public void updateAutore(Autore autore) {
        em.getTransaction().begin();
        em.merge(autore);
        em.getTransaction().commit();
    }

    public void updateAutore(Long id, Autore autore) {
        Autore aReale = findAutoreById(id);
        aReale.setNome(autore.getNome());
        aReale.setCognome(autore.getCognome());
        aReale.setAnnoNascita(autore.getAnnoNascita());

        em.getTransaction().begin();
        em.merge(aReale);
        em.getTransaction().commit();
    }

    public void deleteAutore(Long id) {
        Autore aReale = findAutoreById(id);
        em.getTransaction().begin();
        em.remove(aReale);
        em.getTransaction().commit();
    }

    public void deleteAutore(Autore autore) {
        em.getTransaction().begin();
        em.remove(autore);
        em.getTransaction().commit();
    }

    public void insertAll(List<Autore> lista) {
        em.getTransaction().begin();
        for (Autore c : lista) {
            em.persist(c);
        }
        em.getTransaction().commit();
    }
}
