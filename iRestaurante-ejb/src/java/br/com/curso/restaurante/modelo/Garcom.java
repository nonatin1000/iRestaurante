/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author nonato
 */
@Entity
public class Garcom extends Funcionario implements Serializable{
    
    @OneToOne(mappedBy = "garcom")
    private Restaurante restaurante;
    private BigDecimal comissao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicioDoServico;

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public Date getInicioDoServico() {
        return inicioDoServico;
    }

    public void setInicioDoServico(Date inicioDoServico) {
        this.inicioDoServico = inicioDoServico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.restaurante != null ? this.restaurante.hashCode() : 0);
        hash = 59 * hash + (this.comissao != null ? this.comissao.hashCode() : 0);
        hash = 59 * hash + (this.inicioDoServico != null ? this.inicioDoServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Garcom other = (Garcom) obj;
        if (this.restaurante != other.restaurante && (this.restaurante == null || !this.restaurante.equals(other.restaurante))) {
            return false;
        }
        if (this.comissao != other.comissao && (this.comissao == null || !this.comissao.equals(other.comissao))) {
            return false;
        }
        if (this.inicioDoServico != other.inicioDoServico && (this.inicioDoServico == null || !this.inicioDoServico.equals(other.inicioDoServico))) {
            return false;
        }
        return true;
    }
    
}
