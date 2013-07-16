/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author nonato
 */
@Entity
public class Mesa {
    @Id
    @SequenceGenerator(allocationSize=1, initialValue=1, name="mesa", sequenceName="mesa_id_seq")
    @GeneratedValue(generator="mesa", strategy= GenerationType.SEQUENCE)
    private Long id;
    
    @Column
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
