/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Contato;
import com.icone.apogeu.model.Endereco;
import com.icone.apogeu.model.Templo;
import com.icone.apogeu.model.repository.TemploFacade;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;

/**
 *
 * @author gleywson
 */
@Named(value = "temploController")
@ConversationScoped
public class TemploController implements Serializable {
    @Inject
    private Conversation conversation;
    
    @Inject
    private TemploFacade repositorio;
    private Templo templo;
    private List<Templo> templos;
    
    public TemploController() {
        inicializar();
    }

    public String salvar() {
        if(templo.getId() == null) {
            repositorio.create(templo);
        } else {
            repositorio.edit(templo);
        }
        inicializar();
        endConvertation();
        return "pesquisaTemplo";
//        JsfUtil.redirect("/faces/telas/secretaria/templo/pesquisaTemplo.xhtml");
    }
    
    public void remover() {
        repositorio.remove(templo);
        inicializar();
    }
    
    public String novo() {
        inicializar();
        return "cadastroTemplo";
    }
    
    private void inicializar() {
        templo = new Templo();
        templo.setContato(new Contato());
        templo.setEndereco(new Endereco());
        templos = null;
    }
    
    public Templo getTemplo() {
        return templo;
    }

    public void setTemplo(Templo templo) {
        this.templo = templo;
    }

    public List<Templo> getTemplos() {
        if(templos == null) {
            templos = repositorio.findAll();
        }
        return templos;
    }
    
    public void beginConversation() {
        if(conversation.isTransient()) {
            conversation.setTimeout(1800000L);
            conversation.begin();
        }
    }
    
    public void endConvertation() {
        if(!conversation.isTransient()){
            conversation.end();
        }
    }
}
