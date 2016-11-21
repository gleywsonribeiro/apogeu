/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Funcao;
import com.icone.apogeu.model.repository.FuncaoFacade;
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
@Named(value = "funcaoController")
@ViewScoped
public class FuncaoController implements Serializable {
    
    private Funcao funcao;
    private List<Funcao> funcoes;
    @Inject
    private FuncaoFacade repositorio;
    
    public FuncaoController() {
        this.funcao = new Funcao();
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public List<Funcao> getFuncoes() {
        if(funcoes == null) {
            funcoes = repositorio.findAll();
        }
        return funcoes;
    }
    
    public void salvar() {
        if(funcao.getId() == null) {
            repositorio.create(funcao);
        }else {
            repositorio.edit(funcao);
        }
        funcao = new Funcao();
        funcoes = null;
        JsfUtil.addMessage("Salvo com sucesso!");
    }
    
    public void remover() {
        repositorio.remove(funcao);
        funcoes = null;
        JsfUtil.addMessage("Excluído com sucesso!");
    }
}
