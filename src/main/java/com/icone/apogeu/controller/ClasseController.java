/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Classe;
import com.icone.apogeu.model.repository.ClasseFacade;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author gleyw
 */
@Named(value = "classeController")
@ViewScoped
public class ClasseController implements Serializable{

    private Classe classe;
    private List<Classe> classes;
    
    @Inject
    private ClasseFacade repositorio;

    public ClasseController() {
        this.classe = new Classe();
    }
    
    public void salvar() {
        if(classe.getId() == null) {
            repositorio.create(classe);
        } else {
            repositorio.edit(classe);
        }
        classe = new Classe();
        classes = null;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public List<Classe> getClasses() {
        if(classes == null) {
            classes = repositorio.findAll();
        }
        return classes;
    }
    
    
    
    
    
    
}
