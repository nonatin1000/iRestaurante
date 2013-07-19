/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.controller;

import br.com.curso.restaurante.bo.ItemPedidoBO;
import br.com.curso.restaurante.modelo.ItemCardapio;
import br.com.curso.restaurante.modelo.ItemPedido;
import br.com.curso.restaurante.modelo.Pedido;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author nonato
 */
@ManagedBean
@SessionScoped
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
   
    public void salvar(Pedido pedido) {
        try {
            itemPedido.setPedido(pedido);
            itemPedido.setValorTotal(itemPedido.getItemCardapio().getPreco().multiply(new BigDecimal(itemPedido.getQuantidade())));
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
    
    public ItemPedido buscarPorID(Long id){
         return itemPedidoBO.getItemPedidoDAO().recuperarPorId(id);
    }
    
    public void remover(ItemPedido itemPedido){
        try {
            itemPedidoBO.getItemPedidoDAO().remover(itemPedido);
            if (itemPedido != null) {
                FacesContext.getCurrentInstance()
                        .addMessage(null,
                        new FacesMessage(
                        FacesMessage.SEVERITY_INFO,
                        "Item do Cardapio removido",
                        "Item do Cardapio removido"));
            }
        } catch (Exception ex) {
            Logger.getLogger(
                    ItemPedidoController.class.getName())
                    .log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Item do Pedido não removido",
                    "Item do Pedido não removido"));
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
