/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.controller;

import br.com.curso.restaurante.bo.ItemPedidoBO;
import br.com.curso.restaurante.modelo.ItemPedido;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author nonato
 */
@ManagedBean
@ViewScoped
public class ItemPedidoController {
    private ItemPedido itemPedido;
    private List<ItemPedido> itemPedidos;
    @EJB
    private ItemPedidoBO itemPedidoBO;

    @PostConstruct
    public void init() {
        itemPedido = new ItemPedido();
        itemPedidos = itemPedidoBO
                .getItemPedidoDAO()
                .recuperarTodos();
    }

    public void salvar() {
        try {
            itemPedido = itemPedidoBO.getItemPedidoDAO().salvar(itemPedido);
            if (itemPedido != null) {
                FacesContext.getCurrentInstance()
                        .addMessage(null,
                        new FacesMessage(
                        FacesMessage.SEVERITY_INFO,
                        "itemPedido cadastrado",
                        "itemPedido cadastrado"));
            }
        } catch (Exception ex) {
            Logger.getLogger(
                    ItemPedidoController.class.getName())
                    .log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "itemPedido não cadastrado",
                    "itemPedido não cadastrado"));
            return;
        }
        init();
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public List<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(List<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    public ItemPedidoBO getItemPedidoBO() {
        return itemPedidoBO;
    }

    public void setItemPedidoBO(ItemPedidoBO itemPedidoBO) {
        this.itemPedidoBO = itemPedidoBO;
    }
    
}
