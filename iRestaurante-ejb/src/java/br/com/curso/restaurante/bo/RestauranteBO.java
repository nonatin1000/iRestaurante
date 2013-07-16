/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.bo;

import br.com.curso.restaurante.dao.RestauranteDAO;
import br.com.curso.restaurante.modelo.Area;
import br.com.curso.restaurante.modelo.Restaurante;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ValidationException;

/**
 *
 * @author nonato
 */
@Stateless
public class RestauranteBO {

    @EJB
    private RestauranteDAO restauranteDAO;

    public RestauranteDAO getRestauranteDAO() {
        return restauranteDAO;
    }

    public Restaurante salvar(Restaurante restaurante)
            throws Exception {
        boolean erro = false;
        String mensagem = "";
        if (restaurante == null) {
            erro = true;
            mensagem = "Nenhum restaurante foi informado";
        }
        List r = restauranteDAO
                .recuperarPorCampo("cnpj", restaurante.getCnpj());
        if (r != null && !r.isEmpty()) {
            erro = true;
            mensagem = "Já existe um restaurante para esse CNPJ";
        }
        if (restaurante.getPhone1() == null
                || restaurante.getPhone1().isEmpty()) {
            erro = true;
            mensagem = "Informe o Telefone Principal";
        }
        if (erro) {
            throw new Exception(mensagem);
        }
        return restauranteDAO.salvar(restaurante);
    }

    public Restaurante inicializarRelacoes(Restaurante restaurante) {
        restaurante = restauranteDAO.recuperarPorId(restaurante.getID());
        if (restaurante.getAreas() == null) {
            restaurante.setAreas(new ArrayList<Area>());
        }
        int i = restaurante.getAreas() != null ? restaurante.getAreas().size() : 0;
        return restaurante;
    }
}
