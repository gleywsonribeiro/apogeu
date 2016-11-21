/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model;

/**
 *
 * @author raque
 */
public enum TipoPagamento {
    CREDITO("Crédito"),
    DEBITO("Débito"),
    CHEQUE("Cheque"),
    DINHEIRO("Dinheiro");
    
    private final String descricao;

    private TipoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
}
