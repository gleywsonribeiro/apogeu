/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author gleyw
 */
@NamedQueries({
    @NamedQuery(name = "ContaPendentePorTemplo", query = "SELECT conta FROM conta_pagar AS conta WHERE conta.dataPagamento IS NULL AND CONTA.templo = :templo"),
    @NamedQuery(name = "ContaPorTemplo", query = "SELECT conta FROM conta_pagar AS conta WHERE conta.templo = :templo")
})
@Entity(name = "conta_pagar")
public class ContaPagar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_vencimento", nullable = false)
    private Date vencimento;

    @Column(name = "nr_documento", length = 50, nullable = false)
    private String numeroDocumento;

    @Column(name = "tp_pagamento", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @Column(nullable = false)
    private double valor;

    private Status status;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_pagamento")
    private Date dataPagamento;

    @ManyToOne
//    @JoinColumn(nullable = false)
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Templo templo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date dataContaPagar) {
        this.vencimento = dataContaPagar;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public double getValor() {
        return valor;
    }

    public Templo getTemplo() {
        return templo;
    }

    public void setTemplo(Templo templo) {
        this.templo = templo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Status getSituacao() {
        return status;
    }

    public void setSituacao(Status situacao) {
        this.status = situacao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
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
        if (!(object instanceof ContaPagar)) {
            return false;
        }
        ContaPagar other = (ContaPagar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ContaPagar[ id=" + id + " ]";
    }

}
