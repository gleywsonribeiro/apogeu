/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Situacao;
import com.icone.apogeu.model.repository.SituacaoFacade;
import com.icone.apogeu.util.jsf.JsfUtil;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author gleywson
 */
@Named(value = "situacaoController")
@ViewScoped
public class SituacaoController implements Serializable {

    private Situacao situacao;
    private List<Situacao> situacoes;
    @Inject
    private SituacaoFacade repositorio;

    public SituacaoController() {
        situacao = new Situacao();
    }

    public void salvar() {
        if (situacao.getId() == null) {
            repositorio.create(situacao);
        } else {
            repositorio.edit(situacao);
        }
        situacao = new Situacao();
        situacoes = null;
        JsfUtil.addMessage("Salvo com sucesso!");
    }
    
    public void remover() {
        repositorio.remove(situacao);
        situacoes = null;
        JsfUtil.addMessage("Excluído com sucesso!");
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public List<Situacao> getSituacoes() {
        if (situacoes == null) {
            situacoes = repositorio.findAll();
        }
        return situacoes;
    }

}
