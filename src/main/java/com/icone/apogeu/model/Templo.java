/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author gleyw
 */
@Entity
public class Templo implements Serializable {

    @OneToMany(mappedBy = "templo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CentroDeCusto> setores;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;

    @OneToOne
//    @JoinColumn(nullable = false)
    private Membro responsavel;
    
    @Embedded
    private Endereco endereco;
    
    @Embedded
    private Contato contato;
    
    @Column(nullable = false, length = 30)
    private String cnpj;
    
    @OneToMany(mappedBy = "templo", cascade = CascadeType.ALL)
    private List<LancamentoDeCaixa> lancamentosDeCaixa;
    
    @OneToMany(mappedBy = "templo", cascade = CascadeType.ALL)
    private List<LancamentoFinanceiro> lancamentosFinanceiros;
    
    @ManyToOne
//    @JoinColumn(nullable = false)
    private Sede sede;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Membro getResponsavel() {
        return responsavel;
    }

    public List<LancamentoDeCaixa> getLancamentosDeCaixa() {
        return lancamentosDeCaixa;
    }

    public void setLancamentosDeCaixa(List<LancamentoDeCaixa> LancamentoDeCaixa) {
        this.lancamentosDeCaixa = LancamentoDeCaixa;
    }

    public void setResponsavel(Membro responsavel) {
        this.responsavel = responsavel;
    }

    public List<LancamentoFinanceiro> getLancamentosFinanceiros() {
        return lancamentosFinanceiros;
    }

    public void setLancamentosFinanceiros(List<LancamentoFinanceiro> lancamentosFinanceiros) {
        this.lancamentosFinanceiros = lancamentosFinanceiros;
    }

    public List<CentroDeCusto> getSetores() {
        return setores;
    }

    public void setSetores(List<CentroDeCusto> setores) {
        this.setores = setores;
    }
    
    public Contato getContato() {
        return contato;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
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
        if (!(object instanceof Templo)) {
            return false;
        }
        Templo other = (Templo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Templo[ id=" + id + " ]";
    }
    
}
