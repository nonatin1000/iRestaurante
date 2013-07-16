/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.controller;

import br.com.curso.restaurante.bo.MesaBO;
import br.com.curso.restaurante.modelo.Mesa;
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
public class MesaController {
    
    private Mesa mesa;
    private List<Mesa> mesas;
    @EJB
    private MesaBO mesaBO;
    
    @PostConstruct
    public void init() {
        mesa = new Mesa();
        mesas = mesaBO
                .getMesaDAO()
                .recuperarTodos();
    }
    
    public void salvar() {
        try {
            mesa = mesaBO.getMesaDAO().salvar(mesa);
            if (mesa != null) {
                FacesContext.getCurrentInstance()
                        .addMessage(null,
                        new FacesMessage(
                        FacesMessage.SEVERITY_INFO,
                        "Mesa cadastrado",
                        "Mesa cadastrado"));
            }
        } catch (Exception ex) {
            Logger.getLogger(
                    MesaController.class.getName())
                    .log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Mesa não cadastrado",
                    "Mesa não cadastrado"));
            return;
        }
        init();
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public MesaBO getMesaBO() {
        return mesaBO;
    }

    public void setMesaBO(MesaBO mesaBO) {
        this.mesaBO = mesaBO;
    }
}
