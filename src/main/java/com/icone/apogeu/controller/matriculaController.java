/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Classe;
import com.icone.apogeu.model.Membro;
import com.icone.apogeu.model.Templo;
import com.icone.apogeu.model.repository.ClasseFacade;
import com.icone.apogeu.model.repository.MembroFacade;
import com.icone.apogeu.model.repository.TemploFacade;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author raque
 */
@Named(value = "matriculaController")
@ViewScoped
public class matriculaController implements Serializable{
    @Inject
    private TemploFacade temploRepository;
    @Inject
    private MembroFacade membroRepository;
    @Inject
    private ClasseFacade classeRepository;
    
    
    private List<Templo> templos;
    private List<Membro> membros;
//    private List<Classe> 
    
    private Templo templo;
    private Classe classe;
    private Membro membro;

    public matriculaController() {
        templo = new Templo();
        classe = new Classe();
        membro = new Membro();
    }
    
    
    
    public void matricular() {
        templos = null;
    }

    public List<Templo> getTemplos() {
        if(templos == null) {
            templos = temploRepository.findAll();
        }
        return templos;
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public Templo getTemplo() {
        return templo;
    }

    public void setTemplo(Templo templo) {
        this.templo = templo;
    } 

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }
}
