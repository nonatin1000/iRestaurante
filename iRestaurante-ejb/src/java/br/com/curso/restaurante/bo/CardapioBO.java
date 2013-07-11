/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.bo;

import br.com.curso.restaurante.dao.CardapioDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author nonato
 */
@Stateless
public class CardapioBO {
    
    @EJB
    private CardapioDAO cardapioDAO;

    public CardapioDAO getCardapioDAO() {
        return cardapioDAO;
    }
    
}
