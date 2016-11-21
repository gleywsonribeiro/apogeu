/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author gleyw
 */
@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_emissao", nullable = false)
    private Calendar dataEmissao;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_entrega")
    private Calendar dataEntrega;
    
    @Column(name = "cond_pagamento", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private TipoPagamento condicaoPagamento;
    
    private boolean devolucao;
    
    @Column(nullable = false)
    private double total;
    
    @Column(name = "vl_desconto")
    private double valorDesconto;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Fornecedor fornecedor;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Calendar getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Calendar dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Calendar getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Calendar dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public TipoPagamento getCondicaoPagamento() {
        return condicaoPagamento;
    }

    public void setCondicaoPagamento(TipoPagamento condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }

    public boolean isDevolucao() {
        return devolucao;
    }

    public void setDevolucao(boolean devolucao) {
        this.devolucao = devolucao;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pedido[ id=" + id + " ]";
    }
    
}
