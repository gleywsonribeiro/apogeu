/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Integracao;
import com.icone.apogeu.model.repository.IntegracaoFacade;
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
@Named(value = "integracaoController")
@ViewScoped
public class IntegracaoController implements Serializable {
    private Integracao integracao;
    private List<Integracao> integracoes;
    @Inject
    private IntegracaoFacade repositorio;
    
    public IntegracaoController() {
        integracao = new Integracao();
    }
    
    public void salvar() {
        if(integracao.getId() == null) {
            repositorio.create(integracao);
        } else {
            repositorio.edit(integracao);
        }
        integracao = new Integracao();
        integracoes = null;
        JsfUtil.addMessage("Salvo com sucesso!");
    }

    public void remover() {
        repositorio.remove(integracao);
        integracoes = null;
        JsfUtil.addMessage("Excluído com sucesso!");
    }
    
    public Integracao getIntegracao() {
        return integracao;
    }

    public void setIntegracao(Integracao integracao) {
        this.integracao = integracao;
    }

    public List<Integracao> getIntegracoes() {
        if(integracoes == null) {
            integracoes = repositorio.findAll();
        }
        return integracoes;
    }
    
    
}
