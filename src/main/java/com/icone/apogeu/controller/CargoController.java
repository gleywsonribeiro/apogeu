/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Cargo;
import com.icone.apogeu.model.repository.CargoFacade;
import com.icone.apogeu.util.jsf.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author gleywson
 */
@Named(value = "cargoController")
@ViewScoped
public class CargoController implements Serializable{

    private Cargo cargo;
    private List<Cargo> cargos;
    @Inject
    private CargoFacade repositorio;


    public CargoController() {
        cargo = new Cargo();
    }
    
    
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Cargo> getCargos() {
        if (cargos == null) {
            cargos = repositorio.findAll();
        }
        return cargos;
    }
    
    public void salvar(){
        if(cargo.getId() == null) {
            repositorio.create(cargo);
        } else {
            repositorio.edit(cargo);
        }
        cargo = new Cargo();
        cargos = null;
        JsfUtil.addMessage("Salvo com sucesso!");
    }
    
    public void remover() {
        repositorio.remove(cargo);
        cargos = null;
        JsfUtil.addMessage("Excluído com sucesso!");
    }
    
}
