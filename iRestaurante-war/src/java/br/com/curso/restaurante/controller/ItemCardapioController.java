/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.controller;

import br.com.curso.restaurante.bo.ItemCardapioBO;
import br.com.curso.restaurante.modelo.ItemCardapio;
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
public class ItemCardapioController {
    
    private ItemCardapio itemCardapio;
    private List<ItemCardapio> itemCardapios;
    @EJB
    private ItemCardapioBO itemCardapioBO;

    @PostConstruct
    public void init() {
        itemCardapio = new ItemCardapio();
        itemCardapios = itemCardapioBO
                .getItemCardapioDAO()
                .recuperarTodos();
    }

    public void salvar() {
        try {
            itemCardapio.getCardapio().setItemCardapios(itemCardapios);
            itemCardapio = itemCardapioBO.getItemCardapioDAO().salvar(itemCardapio);
            if (itemCardapio != null) {
                FacesContext.getCurrentInstance()
                        .addMessage(null,
                        new FacesMessage(
                        FacesMessage.SEVERITY_INFO,
                        "ItemCardapio cadastrado",
                        "ItemCardapio cadastrado"));
            }
        } catch (Exception ex) {
            Logger.getLogger(
                    ItemCardapioController.class.getName())
                    .log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "ItemCardapio não cadastrado",
                    "ItemCardapio não cadastrado"));
            return;
        }
        init();
    }

    public ItemCardapio getItemCardapio() {
        return itemCardapio;
    }

    public void setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }

    public List<ItemCardapio> getItemCardapios() {
        return itemCardapios;
    }

    public void setItemCardapios(List<ItemCardapio> itemCardapios) {
        this.itemCardapios = itemCardapios;
    }

    public ItemCardapioBO getItemCardapioBO() {
        return itemCardapioBO;
    }

    public void setItemCardapioBO(ItemCardapioBO itemCardapioBO) {
        this.itemCardapioBO = itemCardapioBO;
    }
    
}
