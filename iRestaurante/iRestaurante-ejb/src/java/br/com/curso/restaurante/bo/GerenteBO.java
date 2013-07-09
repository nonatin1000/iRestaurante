/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.bo;

import br.com.curso.restaurante.dao.GerenteDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author dimmyk
 */
@Stateless
public class GerenteBO {

    @EJB
    private GerenteDAO gerenteDAO;

    public GerenteDAO getGerenteDAO() {
        return gerenteDAO;
    }
}
