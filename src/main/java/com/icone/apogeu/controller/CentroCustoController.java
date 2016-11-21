/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.CentroDeCusto;
import com.icone.apogeu.model.repository.CentroDeCustoFacade;
import com.icone.apogeu.util.jsf.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author gleyw
 */
@Named(value = "setorController")
@ViewScoped
public class CentroCustoController implements Serializable{

    @Inject
    private CentroDeCustoFacade repositorio;
    private CentroDeCusto setor;
    private List<CentroDeCusto> setores;

    public CentroCustoController() {
        setor = new CentroDeCusto();
    }

    public CentroDeCusto getSetor() {
        return setor;
    }

    public void setSetor(CentroDeCusto setor) {
        this.setor = setor;
    }

    public List<CentroDeCusto> getSetores() {
        if (setores == null) {
            setores = repositorio.findAll();
        }
        return setores;
    }
    
    public void salvar() {
        if(setor.getId() == null) {
            repositorio.create(setor);
        } else {
            repositorio.edit(setor);
        }
        setor = new CentroDeCusto();
        setores = null;
        JsfUtil.addMessage("Adicionado com sucesso!");
    }
    
    public void remover() {
        repositorio.remove(setor);
        setores = null;
        JsfUtil.addMessage("Excluído com sucesso!");
    }

}
