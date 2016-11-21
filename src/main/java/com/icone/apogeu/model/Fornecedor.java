/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author gleyw
 */
@Entity
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Embedded
    private Endereco endereco;
    
    @Embedded
    private Contato contato;
    
    @Column(nullable = false, length = 20)
    private String cnpj;
    
    @Column(length = 20)
    private String inscricao;
    
    @Column(columnDefinition = "text")
    private String atividades;
    
    //informacoes adicionais
    @Column(name = "prazo_entrega") //em dias
    private int prazoEntrega;
    
    @Column(name = "cond_pagemento", length = 30)
    @Enumerated(EnumType.STRING)
    private TipoPagamento condicoesPagamento;
    
    private double desconto;
    
    @Column(name = "assist_tecnica")
    private String assistenciaTecnica;
    
    @Column(columnDefinition = "text")
    private String observacao;
    
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public int getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(int prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    public TipoPagamento getCondicoesPagamento() {
        return condicoesPagamento;
    }

    public void setCondicoesPagamento(TipoPagamento condicoesPagamento) {
        this.condicoesPagamento = condicoesPagamento;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getAssistenciaTecnica() {
        return assistenciaTecnica;
    }

    public void setAssistenciaTecnica(String assistenciaTecnica) {
        this.assistenciaTecnica = assistenciaTecnica;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Fornecedor[ id=" + id + " ]";
    }
    
}
