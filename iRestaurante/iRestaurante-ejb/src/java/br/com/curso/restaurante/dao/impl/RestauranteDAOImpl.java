/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.dao.impl;

import br.com.curso.restaurante.dao.RestauranteDAO;
import br.com.curso.restaurante.modelo.Restaurante;
import javax.ejb.Stateless;

/**
 *
 * @author dimmyk
 */
@Stateless
public class RestauranteDAOImpl 
        extends BaseDAOImpl<Restaurante> 
        implements RestauranteDAO {
}
