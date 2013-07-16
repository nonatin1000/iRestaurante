/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.bo;

import br.com.curso.restaurante.dao.AreaDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author dimmyk
 */
@Stateless
public class AreaBO {

    @EJB
    private AreaDAO areaDAO;

    public AreaDAO getAreaDAO() {
        return areaDAO;
    }
}
