/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Patrimonio;
import com.icone.apogeu.model.repository.PatrimonioFacade;
import com.icone.apogeu.util.jsf.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Gleywson
 */
@Named(value = "patrimonioController")
@SessionScoped
public class PatrimonioController implements Serializable {

    @Inject
    private PatrimonioFacade repositorio;
    
    private Patrimonio patrimonio;
    private List<Patrimonio> patrimonios;

    public PatrimonioController() {
        patrimonio = new Patrimonio();
    }

    public Patrimonio getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Patrimonio patrimonio) {
        this.patrimonio = patrimonio;
    }

    public List<Patrimonio> getPatrimonios() {
        if(patrimonios == null) {
            patrimonios = repositorio.findAll();
        }
        return patrimonios;
    }
    
    public String novo() {
        patrimonio = new Patrimonio();
        return "cadastro?faces-redirect=true";
    }
    
    public void salvar() {
        if(patrimonio.getId() == null) {
            repositorio.create(patrimonio);
        } else {
            repositorio.edit(patrimonio);
        }
        patrimonio = new Patrimonio();
        patrimonios = null;
        
        JsfUtil.addMessage("Salvo com sucesso!");
    }

    
    
    
    
    
    
}
