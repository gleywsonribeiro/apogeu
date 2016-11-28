/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Classe;
import com.icone.apogeu.model.Contato;
import com.icone.apogeu.model.Endereco;
import com.icone.apogeu.model.Membro;
import com.icone.apogeu.model.Templo;
import com.icone.apogeu.model.repository.ClasseFacade;
import com.icone.apogeu.model.repository.MembroFacade;
import com.icone.apogeu.model.repository.TemploFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.model.DualListModel;

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
    
    private List<Membro> membrosDisponiveis;
    private List<Membro> membrosSelecionados;
    
    private Templo templo;
    private Classe classe;
    private List<Templo> templos;
    
    private DualListModel<Membro> membros;
    
    public matriculaController() {
        templo = new Templo();
        classe = new Classe();
        membros = new DualListModel<Membro>(membrosDisponiveis, membrosSelecionados);
    }
    
    public List<Templo> getTemplos() {
        if(templos == null) {
            templos = temploRepository.findAll();
        }
        return templos;
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

    public DualListModel<Membro> getMembros() {
        if(membros == null) {
            membros = new DualListModel<Membro>(getMembrosDisponiveis(), new ArrayList<Membro>());
        }
        return membros;
    }

    public void setMembros(DualListModel<Membro> membros) {
        this.membros = membros;
    }

    public List<Membro> getMembrosDisponiveis() {
        if(membrosDisponiveis == null) {
            membrosDisponiveis = membroRepository.getMembrosDisponiveisParaEbd(templo);
        }
        return membrosDisponiveis;
    }

    public List<Membro> getMembrosSelecionados() {
        return membrosSelecionados;
    }
    
    
    
}
