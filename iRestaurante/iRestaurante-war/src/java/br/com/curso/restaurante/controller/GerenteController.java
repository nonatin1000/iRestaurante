/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.controller;

import br.com.curso.restaurante.bo.GerenteBO;
import br.com.curso.restaurante.modelo.Gerente;
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
 * @author dimmyk
 */
@ManagedBean
@SessionScoped
public class GerenteController {

    private Gerente gerente;
    private List<Gerente> gerentes;
    @EJB
    private GerenteBO gerenteBO;

    @PostConstruct
    public void init() {
        gerente = new Gerente();
        gerentes = gerenteBO
                .getGerenteDAO()
                .recuperarTodos();
    }

    public void salvar() {
        try {
            gerente = gerenteBO.getGerenteDAO().salvar(gerente);
            if (gerente != null) {
                FacesContext.getCurrentInstance()
                        .addMessage(null,
                        new FacesMessage(
                        FacesMessage.SEVERITY_INFO,
                        "Gerente cadastrado",
                        "Gerente cadastrado"));
            }
        } catch (Exception ex) {
            Logger.getLogger(
                    GerenteController.class.getName())
                    .log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Gerente não cadastrado",
                    "Gerente não cadastrado"));
            return;
        }
        init();
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public List<Gerente> getGerentes() {
        return gerentes;
    }

    public void setGerentes(List<Gerente> gerentes) {
        this.gerentes = gerentes;
    }
}
