/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.controller;

import br.com.curso.restaurante.bo.AreaBO;
import br.com.curso.restaurante.modelo.Area;
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
public class AreaController {

    private Area area;
    private List<Area> areas;
    @EJB
    private AreaBO areaBO;

    @PostConstruct
    public void init() {
        area = new Area();
        areas = areaBO
                .getAreaDAO()
                .recuperarTodos();
    }

    public void salvar() {
        try {
            area = areaBO.getAreaDAO().salvar(area);
            if (area != null) {
                FacesContext.getCurrentInstance()
                        .addMessage(null,
                        new FacesMessage(
                        FacesMessage.SEVERITY_INFO,
                        "Area cadastrado",
                        "Area cadastrado"));
            }
        } catch (Exception ex) {
            Logger.getLogger(
                    AreaController.class.getName())
                    .log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Area não cadastrado",
                    "Area não cadastrado"));
            return;
        }
        init();
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}
