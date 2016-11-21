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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author raque
 */
@Entity
public class Celula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cor;
    private TipoCelula tipoCelula;
    private String faixaEtaria;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_abertura")
    private Date dataAbertura;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dt_multiplicacao")
    private Date dataMultiplicacao;
    
    private boolean ativa;
    
    @OneToOne
    private Membro lider;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public TipoCelula getTipoCelula() {
        return tipoCelula;
    }

    public void setTipoCelula(TipoCelula tipoCelula) {
        this.tipoCelula = tipoCelula;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataMultiplicacao() {
        return dataMultiplicacao;
    }

    public void setDataMultiplicacao(Date dataMultiplicacao) {
        this.dataMultiplicacao = dataMultiplicacao;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Membro getLider() {
        return lider;
    }

    public void setLider(Membro lider) {
        this.lider = lider;
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
        if (!(object instanceof Celula)) {
            return false;
        }
        Celula other = (Celula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.icone.apogeu.model.Celula[ id=" + id + " ]";
    }
    
}
