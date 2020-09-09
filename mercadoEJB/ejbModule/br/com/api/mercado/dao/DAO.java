package br.com.api.mercado.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

abstract public class DAO<T> {

    private EntityManager entityManager = getEntityManager();
    
    public T add(T objeto) {
        entityManager.getTransaction().begin();
        entityManager.persist(objeto);
        entityManager.getTransaction().commit();
        return objeto;
    }

    public void delete(T objeto, Integer cod) {
        entityManager.getTransaction().begin();
        objeto = (T) entityManager.find(objeto.getClass(), cod);
        entityManager.remove(objeto);
        entityManager.getTransaction().commit();
    }

    public T update(T objeto) {
        entityManager.getTransaction().begin();
        entityManager.merge(objeto);
        entityManager.getTransaction().commit();
        return objeto;
    }

    public T filtrar(T objeto, Integer cod) {
        objeto = (T) entityManager.find(objeto.getClass(), cod);
        return objeto;
    }

    public List<T> buscarTodos(T objeto) {
        List<T> al = new ArrayList<>();

        String classe = objeto.getClass().toString().replace("class br.com.api.mercado.model.", "");
        System.out.println("br.com.api.mercado.dao.DAO.buscarTodos(): " + "SELECT o FROM " + classe + " o");
        Query query = entityManager.createQuery("SELECT o FROM " + classe + " o");
        al = query.getResultList();

        return al;
    }

    private EntityManager getEntityManager() {

        if (entityManager == null) {
            EntityManagerFactory factory = null;
            try {
                //Obtém o factory a partir da unidade de persistência.
                factory = Persistence.createEntityManagerFactory("PersistenciaJPAPU");
                //Cria um entity manager.
                entityManager = factory.createEntityManager();
                //Fecha o factory para liberar os recursos utilizado.
            } finally {
                //factory.close();
            }
        }
        return entityManager;
    }
    
}
