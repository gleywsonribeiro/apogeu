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
import javax.persistence.Temporal;

/**
 *
 * @author gleyw
 */
@Entity
public class Patrimonio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_compra", nullable = false)
    private Date dataCompra;
    
    @Column(nullable = false, length = 100)
    private String produto;
    @Column(nullable = false, length = 100)
    private String marca;
    @Column(nullable = false, length = 100)
    private String modelo;
    @Column(nullable = false, length = 50)
    private String cor;
    @Column(name = "ano_aquisicao") //data da aquisicao
    private int anoAquisicao;
    @Column(name = "estado_uso", columnDefinition = "text")
    private String estadoUso;
    
    @ManyToOne
//    @JoinColumn(nullable = false)
    private Fornecedor fornecedor;
    
    @Column(nullable = false)
    private double valor;
    
    @Column(nullable = false)
    private int quantidade;
    
    @Column(name = "nr_nota", nullable = false, length = 50)
    private String numeroNota;
    
    @ManyToOne
//    @JoinColumn(nullable = false)
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

    public CentroDeCusto getCentroDeCusto() {
        return centroDeCusto;
    }

    public void setCentroDeCusto(CentroDeCusto centroDeCusto) {
        this.centroDeCusto = centroDeCusto;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAnoAquisicao() {
        return anoAquisicao;
    }

    public void setAnoAquisicao(int anoAquisicao) {
        this.anoAquisicao = anoAquisicao;
    }

    public String getEstadoUso() {
        return estadoUso;
    }

    public void setEstadoUso(String estadoUso) {
        this.estadoUso = estadoUso;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
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
        if (!(object instanceof Patrimonio)) {
            return false;
        }
        Patrimonio other = (Patrimonio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Patrimonio[ id=" + id + " ]";
    }
    
}
