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
public enum EstadoCivil {
    CASADO("Casado"), 
    DIVORCIADO("Divorciado"), 
    SOLTEIRO("Solteiro"), 
    VIUVO("Viúvo"),
    UNIAO_ESTAVEL("União Estável");
    
    private final String descricao;

    private EstadoCivil(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
