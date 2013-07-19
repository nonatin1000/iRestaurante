/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.bo;

import br.com.curso.restaurante.dao.PedidoDAO;
import br.com.curso.restaurante.modelo.ItemPedido;
import br.com.curso.restaurante.modelo.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author nonato
 */
@Stateless
public class PedidoBO {
    
    @EJB
    private PedidoDAO pedidoDAO;

    public PedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }
    
    public Pedido salvar(Pedido pedido)
            throws Exception {
        boolean erro = false;
        String mensagem = "";
        if (pedido == null) {
            erro = true;
            mensagem = "Nenhum pedido foi informado";
        }
        List r = pedidoDAO
                .recuperarPorCampo("id", pedido.getId());
        
        return pedidoDAO.salvar(pedido);
    }
    
    public Pedido inicializarRelacoes(Pedido pedido){
        pedido = pedidoDAO.recuperarPorId(pedido.getId());
        if(pedido.getItemPedidos() == null){
            pedido.setItemPedidos(new ArrayList<ItemPedido>());
        }
        int i = pedido.getItemPedidos() !=  null ? pedido.getItemPedidos().size() : 0;
        return pedido;
    }
}
