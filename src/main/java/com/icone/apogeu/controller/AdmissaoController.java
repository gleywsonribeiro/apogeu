/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Admissao;
import com.icone.apogeu.model.repository.AdmissaoFacade;
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
@Named(value = "admissaoController")
@ViewScoped
public class AdmissaoController implements Serializable {
    private Admissao admissao;
    private List<Admissao> admissoes;
    @Inject
    private AdmissaoFacade repositorio;
    
    public AdmissaoController() {
        admissao = new Admissao();
    }

    public void salvar() {
        if(admissao.getId() == null) {
            repositorio.create(admissao);
        } else{
            repositorio.edit(admissao);
        }
        admissao = new Admissao();
        admissoes = null;
        JsfUtil.addMessage("Salvo com sucesso!");
    }
    
    public void remover() {
        repositorio.remove(admissao);
        admissoes = null;
        JsfUtil.addMessage("Excluído com sucesso!");
    }
    
    public Admissao getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Admissao admissao) {
        this.admissao = admissao;
    }

    public List<Admissao> getAdmissoes() {
        if(admissoes == null) {
            admissoes = repositorio.findAll();
        }
        return admissoes;
    }
    
}
