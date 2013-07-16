/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.dao.impl;

import br.com.curso.restaurante.dao.AreaDAO;
import br.com.curso.restaurante.modelo.Area;
import javax.ejb.Stateless;

/**
 *
 * @author dimmyk
 */
@Stateless
public class AreaDAOImpl
        extends BaseDAOImpl<Area>
        implements AreaDAO {
}
