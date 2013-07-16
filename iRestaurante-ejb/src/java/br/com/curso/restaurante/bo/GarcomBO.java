/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.bo;

import br.com.curso.restaurante.dao.GarcomDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author nonato
 */
@Stateless
public class GarcomBO {
    
    @EJB
    private GarcomDAO garcomDAO;

    public GarcomDAO getGarcomDAO() {
        return garcomDAO;
    }
        
}
