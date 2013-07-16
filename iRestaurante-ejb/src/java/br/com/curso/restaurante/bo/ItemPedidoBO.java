/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.bo;

import br.com.curso.restaurante.dao.ItemPedidoDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author nonato
 */
@Stateless
public class ItemPedidoBO {
    
    @EJB
    private ItemPedidoDAO itemPedidoDAO;

    public ItemPedidoDAO getItemPedidoDAO() {
        return itemPedidoDAO;
    }
    
}
