/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.controller;

import br.com.curso.restaurante.bo.CardapioBO;
import br.com.curso.restaurante.modelo.Cardapio;
import br.com.curso.restaurante.modelo.ItemCardapio;
import java.util.ArrayList;
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
public class CardapioController {
    
    private Cardapio cardapio;
    private List<Cardapio> cardapios;
    @EJB
    private CardapioBO cardapioBO;
    
    @PostConstruct
    public void init() {
        cardapio = new Cardapio();
        cardapios = cardapioBO
                .getCardapioDAO()
                .recuperarTodos();
    }
    
    public void carregarItemCardapio() {
        cardapio = cardapioBO.inicializarRelacoes(cardapio);
    }

    public void adicionarItemCardapio(ItemCardapio itemCardapio) {
        if (cardapio.getItemCardapios() == null) {
            cardapio.setItemCardapios(new ArrayList<ItemCardapio>());
        }
        cardapio.getItemCardapios().add(itemCardapio);
        cardapio = cardapioBO.getCardapioDAO().salvar(cardapio);
    }

    public void salvar() {
        try {
            cardapio = cardapioBO.getCardapioDAO().salvar(cardapio);
            if (cardapio != null) {
                FacesContext.getCurrentInstance()
                        .addMessage(null,
                        new FacesMessage(
                        FacesMessage.SEVERITY_INFO,
                        "Cardapio cadastrado",
                        "Cardapio cadastrado"));
            }
        } catch (Exception ex) {
            Logger.getLogger(
                    CardapioController.class.getName())
                    .log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Cardapio não cadastrado",
                    "Cardapio não cadastrado"));
            return;
        }
        init();
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public List<Cardapio> getCardapios() {
        return cardapios;
    }

    public void setCardapios(List<Cardapio> cardapios) {
        this.cardapios = cardapios;
    }

    public CardapioBO getCardapioBO() {
        return cardapioBO;
    }

    public void setCardapioBO(CardapioBO cardapioBO) {
        this.cardapioBO = cardapioBO;
    }
    
    
    
}
