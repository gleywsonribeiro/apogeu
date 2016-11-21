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
public enum Escolaridade {
    SUPERIOR("Superior"),
    FUNDAMENTAL("Fundamental"),
    MEDIO("Médio"),
    POS_GRADUACAO("Pós-graduação"),
    MESTRADO("Mestrado"),
    DOUTORADO("Doutorado"),
    TECNICO("Técnico");
    
    private final String descricao;

    private Escolaridade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
