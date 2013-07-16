/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author dimmyk
 */
@Entity
public class Gerente extends Funcionario {

    @OneToOne(mappedBy = "gerente")
    private Restaurante restaurante;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicioDoServico;

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Date getInicioDoServico() {
        return inicioDoServico;
    }

    public void setInicioDoServico(Date inicioDoServico) {
        this.inicioDoServico = inicioDoServico;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gerente other = (Gerente) obj;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.restaurante != null ? this.restaurante.hashCode() : 0);
        hash = 59 * hash + (this.inicioDoServico != null ? this.inicioDoServico.hashCode() : 0);
        return hash;
    }
}
