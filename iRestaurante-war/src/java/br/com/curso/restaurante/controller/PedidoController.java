/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.controller;

import br.com.curso.restaurante.bo.PedidoBO;
import br.com.curso.restaurante.modelo.ItemPedido;
import br.com.curso.restaurante.modelo.Pedido;
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
public class PedidoController {
    
    private Pedido pedido;
    private List<Pedido> pedidos;
    
    @EJB
    private PedidoBO pedidoBO;

    @PostConstruct
    public void init() {
        pedido = new Pedido();
        pedidos = pedidoBO
                .getPedidoDAO()
                .recuperarTodos();
    }
    
    public void carregarItemPedido(){
        pedido = pedidoBO.inicializarRelacoes(pedido);
    }
    
    public void adicionarItemPedido(ItemPedido itemPedido) throws Exception{
        if(pedido.getItemPedidos() == null){
            pedido.setItemPedidos(new ArrayList<ItemPedido>());
        }
        pedido.getItemPedidos().add(itemPedido);
        pedido = pedidoBO.getPedidoDAO().salvar(pedido);
    }
    
     public Pedido buscarPorID(Long id){
        return pedidoBO.getPedidoDAO().recuperarPorId(id);
    }
    
    public void salvar() {
        try {
            pedido = pedidoBO.getPedidoDAO().salvar(pedido);
            if (pedido != null) {
                FacesContext.getCurrentInstance()
                        .addMessage(null,
                        new FacesMessage(
                        FacesMessage.SEVERITY_INFO,
                        "Pedido cadastrado",
                        "Pedido cadastrado"));
            }
        } catch (Exception ex) {
            Logger.getLogger(
                    PedidoController.class.getName())
                    .log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Pedido não cadastrado",
                    "Pedido não cadastrado"));
            return;
        }
        init();
    }
    
    public void remover(){
        try {
            pedidoBO.getPedidoDAO().remover(pedido);
            if (pedido != null) {
                FacesContext.getCurrentInstance()
                        .addMessage(null,
                        new FacesMessage(
                        FacesMessage.SEVERITY_INFO,
                        "Pedido removido com sucesso",
                        "Pedido removido com sucesso"));
            }
        } catch (Exception ex) {
            Logger.getLogger(
                    PedidoController.class.getName())
                    .log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Pedido não removido",
                    "Pedido não removido"));
            return;
        }
        init();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public PedidoBO getPedidoBO() {
        return pedidoBO;
    }

    public void setPedidoBO(PedidoBO pedidoBO) {
        this.pedidoBO = pedidoBO;
    }
}
