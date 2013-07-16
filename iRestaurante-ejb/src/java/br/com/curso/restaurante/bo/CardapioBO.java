/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.bo;

import br.com.curso.restaurante.dao.CardapioDAO;
import br.com.curso.restaurante.modelo.Cardapio;
import br.com.curso.restaurante.modelo.ItemCardapio;
import java.util.ArrayList;
import java.util.List;
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
    
    public Cardapio salvar(Cardapio cardapio) throws Exception {
        boolean erro = false;
        String mensagem = "";
        if (cardapio == null) {
            erro = true;
            mensagem = "Nenhum cardapio foi informado";
        }
        List r = cardapioDAO
                .recuperarPorCampo("descricao", cardapio.getDescricao());
        if (r != null && !r.isEmpty()) {
            erro = true;
            mensagem = "Já existe um cardapio para essa descrição";
        }
        if (cardapio.getDescricao() == null
                || cardapio.getDescricao().isEmpty()) {
            erro = true;
            mensagem = "Informe a Descrição";
        }
        if (erro) {
            throw new Exception(mensagem);
        }
        return cardapioDAO.salvar(cardapio);
    }
    
    public Cardapio inicializarRelacoes(Cardapio cardapio) {
        cardapio = cardapioDAO.recuperarPorId(cardapio.getId());
        if (cardapio.getItemCardapios() == null) {
            cardapio.setItemCardapios(new ArrayList<ItemCardapio>());
        }
        int i = cardapio.getItemCardapios() != null ? cardapio.getItemCardapios().size() : 0;
        return cardapio;
    }
    
}
