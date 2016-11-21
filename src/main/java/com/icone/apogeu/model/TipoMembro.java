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
public enum TipoMembro {
    A("A"), B("B"), C("C"), D("D");

    private final String descricao;

    private TipoMembro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
