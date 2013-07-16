/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.controller;

import br.com.curso.restaurante.bo.RestauranteBO;
import br.com.curso.restaurante.dao.GerenteDAO;
import br.com.curso.restaurante.modelo.Area;
import br.com.curso.restaurante.modelo.Gerente;
import br.com.curso.restaurante.modelo.Restaurante;
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
 * @author dimmyk
 */
@ManagedBean
@ViewScoped
public class RestauranteController {

    private Restaurante restaurante;
    private List<Restaurante> restaurantes;
    @EJB
    private RestauranteBO restauranteBO;

    @PostConstruct
    public void init() {
        restaurante = new Restaurante();
        restaurantes = restauranteBO
                .getRestauranteDAO()
                .recuperarTodos();
    }

    public void carregarAreas() {
        restaurante = restauranteBO.inicializarRelacoes(restaurante);
    }

    public void adicionarArea(Area area) {
        if (restaurante.getAreas() == null) {
            restaurante.setAreas(new ArrayList<Area>());
        }
        restaurante.getAreas().add(area);
        restaurante = restauranteBO.getRestauranteDAO().salvar(restaurante);
    }

    public void salvar() {
        try {
            restaurante.getGerente().setRestaurante(restaurante);
            restaurante = restauranteBO
                    .salvar(restaurante);
            if (restaurante != null) {
                FacesContext.getCurrentInstance()
                        .addMessage(null,
                        new FacesMessage(
                        FacesMessage.SEVERITY_INFO,
                        "Restaurante cadastrado",
                        "Restaurante cadastrado"));
            }
        } catch (Exception ex) {
            Logger.getLogger(
                    RestauranteController.class.getName())
                    .log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                    new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Restaurante não cadastrado",
                    "Restaurante não cadastrado"));
            return;
        }
        init();
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }
}
