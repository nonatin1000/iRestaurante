/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.modelo;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author nonato
 */
@Entity
public class ItemCardapio {
    @Id
    @SequenceGenerator(name = "itemCard", allocationSize = 1, sequenceName = "itemCard_seq_id")
    @GeneratedValue(generator = "itemCard", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String prato;
    @Column
    private String descricao;
    @Column
    private BigDecimal preco;
    
    @ManyToMany(mappedBy = "itemCardapios")
    private List<Cardapio> cardapios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrato() {
        return prato;
    }

    public void setPrato(String prato) {
        this.prato = prato;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Cardapio> getCardapios() {
        return cardapios;
    }

    public void setCardapios(List<Cardapio> cardapios) {
        this.cardapios = cardapios;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 31 * hash + (this.prato != null ? this.prato.hashCode() : 0);
        hash = 31 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 31 * hash + (this.cardapios != null ? this.cardapios.hashCode() : 0);
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
        final ItemCardapio other = (ItemCardapio) obj;
        return true;
    }
}
