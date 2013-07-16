/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.modelo;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author nonato
 */
@Entity
public class ItemPedido {
    @Id
    @SequenceGenerator(name = "itemPed", allocationSize = 1, sequenceName = "itemPed_seq_id")
    @GeneratedValue(generator = "itemPed", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private BigDecimal valor;
    @Column
    private long quantidade;
    
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private ItemCardapio itemCardapio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public ItemCardapio getItemCardapio() {
        return itemCardapio;
    }

    public void setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 71 * hash + (this.valor != null ? this.valor.hashCode() : 0);
        hash = 71 * hash + (int) (this.quantidade ^ (this.quantidade >>> 32));
        hash = 71 * hash + (this.itemCardapio != null ? this.itemCardapio.hashCode() : 0);
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
        final ItemPedido other = (ItemPedido) obj;
        return true;
    }
    
}
