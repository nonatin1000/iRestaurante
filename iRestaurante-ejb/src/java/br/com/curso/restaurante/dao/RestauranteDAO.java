/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.dao;

import br.com.curso.restaurante.modelo.Restaurante;
import javax.ejb.Local;

/**
 *
 * @author nonato
 */
@Local
public interface RestauranteDAO
        extends BaseDAO<Restaurante> {
}
