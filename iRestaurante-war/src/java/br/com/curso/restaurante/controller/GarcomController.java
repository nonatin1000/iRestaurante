package br.com.curso.restaurante.controller;

import br.com.curso.restaurante.bo.GarcomBO;
import br.com.curso.restaurante.modelo.Garcom;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nonato
 */
@ManagedBean
@SessionScoped
public class GarcomController {
    
    private Garcom garcom;
    private List<Garcom> garcoms;
    
    @EJB
    private GarcomBO garcomBO;
    
    @PostConstruct
    public void init(){
        garcom = new Garcom();
        garcoms = garcomBO
                .getGarcomDAO()
                .recuperarTodos();
    }
    
    public void salvar() {
        try {
            garcom = garcomBO.getGarcomDAO().salvar(garcom);
            if (garcom != null) {
                FacesContext.getCurrentInstance()
                        .addMessage(null,
                        new FacesMessage(
                        FacesMessage.SEVERITY_INFO,
                        "Garcom cadastrado",
                        "Garcom cadastrado"));
            }
        } catch (Exception ex) {
            Logger.getLogger(
                    GarcomController.class.getName())
                    .log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Garcom não cadastrado",
                    "Garcom não cadastrado"));
            return;
        }
        init();
    }

    public Garcom getGarcom() {
        return garcom;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

    public List<Garcom> getGarcoms() {
        return garcoms;
    }

    public void setGarcoms(List<Garcom> garcoms) {
        this.garcoms = garcoms;
    }

    public GarcomBO getGarcomBO() {
        return garcomBO;
    }

    public void setGarcomBO(GarcomBO garcomBO) {
        this.garcomBO = garcomBO;
    }
    
}
