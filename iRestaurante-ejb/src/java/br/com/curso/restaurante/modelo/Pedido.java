/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.restaurante.modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author nonato
 */
@Entity
public class Pedido {
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "ped", sequenceName = "ped_id_seq")
    @GeneratedValue(generator = "ped", strategy = GenerationType.SEQUENCE)
    private Long Id;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPedido;
    @Column
    private BigDecimal total;
    
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private ItemPedido itemPedido;
    
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private Mesa mesa;
    
    @OneToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private Garcom garcom;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public Garcom getGarcom() {
        return garcom;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
}
