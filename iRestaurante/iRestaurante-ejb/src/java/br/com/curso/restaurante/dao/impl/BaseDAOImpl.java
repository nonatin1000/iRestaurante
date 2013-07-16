/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.dao.impl;

import br.com.curso.restaurante.dao.BaseDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dimmyk
 */
public class BaseDAOImpl<T> implements BaseDAO<T> {

    private Class classe;
    @PersistenceContext(unitName = "restaurantePU")
    private EntityManager entityManager;

    public BaseDAOImpl() {
        Object object = ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
        if (object instanceof Class<?>) {
            classe = (Class<T>) ((ParameterizedType) getClass()
                    .getGenericSuperclass())
                    .getActualTypeArguments()[0];
        } else {
            if (object instanceof Class) {
                classe = (Class) ((ParameterizedType) getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
            }
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public T salvar(T t) {
        return getEntityManager().merge(t);
    }

    @Override
    public void remover(T t) {
        getEntityManager().remove(t);
    }

    @Override
    public T recuperarPorId(Long id) {
        Query query = getEntityManager()
                .createQuery("from "
                + classe.getName()
                + " where id = :id ");
        query.setParameter("id", id);
        return (T) query.getSingleResult();
    }

    @Override
    public List<T> recuperarTodos() {
        Query query = getEntityManager().createQuery(""
                + "from " + classe.getName());
        return query.getResultList();
    }

    @Override
    public List<T> recuperarPorCampo(String campo,
            Object valor) {
        Query query = getEntityManager()
                .createQuery("from "
                + classe.getName()
                + " where " + campo + " = :campo ");
        query.setParameter("campo", valor);
        return query.getResultList();
    }
}
