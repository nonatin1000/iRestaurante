/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.bo;

import br.com.curso.restaurante.dao.ItemCardapioDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author nonato
 */
@Stateless
public class ItemCardapioBO {
    
    @EJB
    private ItemCardapioDAO itemCardapioDAO;

    public ItemCardapioDAO getItemCardapioDAO() {
        return itemCardapioDAO;
    }
    
}
