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
@NamedQuery(name = "lancamentoPorTemplo", query = "SELECT l FROM lancamento_caixa AS l WHERE l.templo = :templo")
@Entity(name = "lancamento_caixa")
public class LancamentoDeCaixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_lancamento", nullable = false)
    private Date dataLancamento;
    
    @Column(name = "vl_entrada", nullable = false)
    private double valorEntrada;
    
    @Column(name = "vl_saida", nullable = false)
    private double valorSaida;
    
    @Column(nullable = false, length = 100)
    private String descricao;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Templo templo;
    
    @ManyToOne
    //@JoinColumn(nullable = false)
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

    public CentroDeCusto getCentroDeCusto() {
        return centroDeCusto;
    }

    public void setCentroDeCusto(CentroDeCusto centroDeCusto) {
        this.centroDeCusto = centroDeCusto;
    }

    public double getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(double valorSaida) {
        this.valorSaida = valorSaida;
    }

    
    
    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!(object instanceof LancamentoDeCaixa)) {
            return false;
        }
        LancamentoDeCaixa other = (LancamentoDeCaixa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ControleDeCaixa[ id=" + id + " ]";
    }
    
}
