/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author nonato
 */
@Entity
public class Cardapio implements Serializable {
    
    @Id
    @SequenceGenerator(allocationSize=1, initialValue=1, name="card", sequenceName="card_id_seq")
    @GeneratedValue(generator="card", strategy= GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 500)
    private String descricao;
    
    @ManyToMany(mappedBy = "cardapio")
    private List<ItemCardapio> itemCardapios;
    
    @OneToOne(mappedBy = "cardapio")
    private Restaurante restaurante;

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

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<ItemCardapio> getItemCardapios() {
        return itemCardapios;
    }

    public void setItemCardapios(List<ItemCardapio> itemCardapios) {
        this.itemCardapios = itemCardapios;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 13 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 13 * hash + (this.itemCardapios != null ? this.itemCardapios.hashCode() : 0);
        hash = 13 * hash + (this.restaurante != null ? this.restaurante.hashCode() : 0);
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
        final Cardapio other = (Cardapio) obj;
        return true;
    }
    
}
