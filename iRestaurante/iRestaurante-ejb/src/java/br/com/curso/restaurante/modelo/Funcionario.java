/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.modelo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author dimmyk
 */
@Entity
public class Funcionario extends Pessoa {

    @Column(unique = true)
    private String matricula;
    @Column(nullable = false)
    private BigDecimal salario;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
