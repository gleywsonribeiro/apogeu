/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.bean;


import com.icone.apogeu.model.Membro;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author gleyw
 */
@Named(value = "membroBean")
@SessionScoped
public class MembroBean implements Serializable {

    private List<Integer> membros;
    private boolean falecido;
    private Membro membro;
    
    @PostConstruct
    public void init() {
        membros = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            membros.add(i);
        }
    }

    public MembroBean() {
        membro = new Membro();
    }

    
    
    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    
    
    public List<Integer> getMembros() {
        return membros;
    }

    public boolean isFalecido() {
        return falecido;
    }

    public void setFalecido(boolean falecido) {
        this.falecido = falecido;
    }
    
    
    
    public void salvar() {
        
    }
}
