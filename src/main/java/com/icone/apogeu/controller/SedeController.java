/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Contato;
import com.icone.apogeu.model.Endereco;
import com.icone.apogeu.model.Sede;
import com.icone.apogeu.model.repository.SedeFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author gleywson
 */
@Named(value = "sedeController")
@SessionScoped
public class SedeController implements Serializable{

    @Inject
    private SedeFacade repositorio;
    private Sede sede;
    private List<Sede> sedes;
    
    public SedeController() {
        inicializar();
    }
    
    public String salvar() {
        if(sede.getId() == null) {
            repositorio.create(sede);
        } else {
            repositorio.edit(sede);
        }
        inicializar();
        return "pesquisaSede?faces-redirect=true";
        //JsfUtil.redirect("/faces/telas/secretaria/sede/pesquisaSede.xhtml");
    }
    
    private void inicializar() {
        sede = new Sede();
        sede.setEndereco(new Endereco());
        sede.setContato(new Contato());
        sedes = null;
    }
    
    public void remover() {
        repositorio.remove(sede);
        inicializar();
    }
    
    public String novo() {
        inicializar();
        return "cadastroSede";
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public List<Sede> getSedes() {
        if(sedes == null) {
            sedes = repositorio.findAll();
        }
        return sedes;
    }
    
    
    
}
