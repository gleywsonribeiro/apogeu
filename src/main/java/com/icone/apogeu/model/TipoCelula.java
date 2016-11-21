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
public enum TipoCelula {
    ADOLESCENTE("Adolescente"),
    JOVEM("Jovem");
    
    private final String valor;

    private TipoCelula(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}