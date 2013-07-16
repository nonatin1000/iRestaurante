/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.dao;

import java.util.List;

/**
 *
 * @author nonato
 */
public interface BaseDAO<T> {

    public T salvar(T t);
    public void remover(T t);
    public T recuperarPorId(Long id);
    public List<T> recuperarTodos();
    public List<T> recuperarPorCampo(String campo, Object valor);
}
