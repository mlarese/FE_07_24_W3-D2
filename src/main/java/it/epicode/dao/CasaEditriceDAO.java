package it.epicode.dao;

import it.epicode.entity.CasaEditrice;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CasaEditriceDAO {
    private EntityManager em;

    public CasaEditriceDAO(EntityManager em) {
        this.em = em;
    }

    public void insertCasaEditrice(CasaEditrice casaEditrice) {
        em.getTransaction().begin();
        em.persist(casaEditrice);
        em.getTransaction().commit();
    }

    public CasaEditrice findCasaEditriceById(Long id) {
        return em.find(CasaEditrice.class, id);
    }

    public void updateCasaEditrice(CasaEditrice casaEditrice) {
        em.getTransaction().begin();
        em.merge(casaEditrice);
        em.getTransaction().commit();
    }

    public void updateCasaEditrice(Long id, CasaEditrice casaEditrice) {
        CasaEditrice cReale = findCasaEditriceById(id);
        cReale.setNome(casaEditrice.getNome());
        cReale.setCitta(casaEditrice.getCitta());
        cReale.setEmail(casaEditrice.getEmail());
        cReale.setTelefono(casaEditrice.getTelefono());

        em.getTransaction().begin();
        em.merge(cReale);
        em.getTransaction().commit();
    }

    public void deleteCasaEditrice(Long id) {
        CasaEditrice cReale = findCasaEditriceById(id);
        em.getTransaction().begin();
        em.remove(cReale);
        em.getTransaction().commit();
    }

    public void deleteCasaEditrice(CasaEditrice casaEditrice) {
        em.getTransaction().begin();
        em.remove(casaEditrice);
        em.getTransaction().commit();
    }

    public void insertAll(List<CasaEditrice> lista) {
        em.getTransaction().begin();
        for (CasaEditrice c : lista) {
            em.persist(c);
        }
        em.getTransaction().commit();
    }
}
