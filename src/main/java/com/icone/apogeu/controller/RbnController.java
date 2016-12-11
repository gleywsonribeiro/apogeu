/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Membro;
import com.icone.apogeu.model.Rbn;
import com.icone.apogeu.model.repository.MembroFacade;
import com.icone.apogeu.model.repository.RbnFacade;
import com.icone.apogeu.util.jsf.JsfUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author gleywson
 */
@Named(value = "rbnController")
@SessionScoped
public class RbnController implements Serializable{

    @Inject
    private RbnFacade repositorio;
    private Rbn rbn;
    private List<Rbn> rbns;
    private List<Rbn> rbnsPendentes;
    
    @Inject
    private MembroFacade membroRepository;

    public RbnController() {
        inicializar();
    }
    
    private void inicializar() {
        rbn = new Rbn();
        rbn.setDataLancamento(new Date());
        rbns = null;
        rbnsPendentes = null;
    }
    
    public void salvar() {
        if(rbn.getId() == null) {
            repositorio.create(rbn);
        } else {
            repositorio.edit(rbn);
        }
        inicializar();
        JsfUtil.addMessage("Confirmado com sucesso!");
    }
    
    public void confirmarPagamento() {
        rbn.setDataPagamento(new Date());
        salvar();
    }
    
    public void cancelarLancamento() {
        repositorio.remove(rbn);
        inicializar();
        JsfUtil.addMessage("Cancelado com sucesso!");
    }
    
    public List<Membro> completarMembros(String nome) {
        return membroRepository.getMembrosPorNome(nome);
    }

    public List<Rbn> getRbnsPendentes() {
        if(rbnsPendentes == null) {
            rbnsPendentes = repositorio.getPendentes();
        }
        return rbnsPendentes;
    }

    public Rbn getRbn() {
        return rbn;
    }

    public void setRbn(Rbn rbn) {
        this.rbn = rbn;
    }

    public List<Rbn> getRbns() {
        if(rbns == null) {
            rbns = repositorio.findAll();
        }
        return rbns;
    }

    
}
