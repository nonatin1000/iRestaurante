/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.controller;

import br.com.curso.restaurante.bo.PedidoBO;
import br.com.curso.restaurante.modelo.Pedido;
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
    
    public void salvar() {
        try {
            pedido = pedidoBO.salvar(pedido);
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
