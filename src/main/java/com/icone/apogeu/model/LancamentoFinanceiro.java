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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author gleyw
 */
@NamedQuery(name = "lancamentoFinanceiroPorTemplo", query = "SELECT l FROM lancamento_financeiro AS l WHERE l.templo = :templo")
@Entity(name = "lancamento_financeiro")
public class LancamentoFinanceiro implements Serializable {
    //interessante trocar o nome da classe paa oferta
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_lancamento", nullable = false)
    private Date dataLancamento;
    
    @Column(name = "vl_oferta")
    private double valorOferta;
    
    @Column(name = "vl_dizimo")
    private double valorDizimo;
    
    @Column(name = "vl_boas_novas")
    private double valorBoasnovas;
    
    @Column(name = "vl_outros")
    private double outrosValores;
    
    @Column(columnDefinition = "text")
    private String observacao;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Templo templo;
    
    @ManyToOne
//    @JoinColumn(nullable = false)
    private CentroDeCusto centroDeCusto;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Templo getTemplo() {
        return templo;
    }

    public void setTemplo(Templo templo) {
        this.templo = templo;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getValorOferta() {
        return valorOferta;
    }

    public void setValorOferta(double valorOferta) {
        this.valorOferta = valorOferta;
    }

    public CentroDeCusto getCentroDeCusto() {
        return centroDeCusto;
    }

    public void setCentroDeCusto(CentroDeCusto centroDeCusto) {
        this.centroDeCusto = centroDeCusto;
    }

    
    public double getValorDizimo() {
        return valorDizimo;
    }

    public void setValorDizimo(double valorDizimo) {
        this.valorDizimo = valorDizimo;
    }

    public double getValorBoasnovas() {
        return valorBoasnovas;
    }

    public void setValorBoasnovas(double valorBoasnovas) {
        this.valorBoasnovas = valorBoasnovas;
    }

    public double getOutrosValores() {
        return outrosValores;
    }

    public void setOutrosValores(double outrosValores) {
        this.outrosValores = outrosValores;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public double getTotal() {
        return (valorBoasnovas + valorDizimo + valorOferta + outrosValores);
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
        if (!(object instanceof LancamentoFinanceiro)) {
            return false;
        }
        LancamentoFinanceiro other = (LancamentoFinanceiro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ControleFinanceiro[ id=" + id + " ]";
    }
    
}
