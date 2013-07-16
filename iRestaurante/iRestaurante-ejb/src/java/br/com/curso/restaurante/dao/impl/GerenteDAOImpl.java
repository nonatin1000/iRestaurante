/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.dao.impl;

import br.com.curso.restaurante.dao.GerenteDAO;
import br.com.curso.restaurante.modelo.Gerente;
import javax.ejb.Stateless;

/**
 *
 * @author dimmyk
 */
@Stateless
public class GerenteDAOImpl
        extends BaseDAOImpl<Gerente>
        implements GerenteDAO {
}
