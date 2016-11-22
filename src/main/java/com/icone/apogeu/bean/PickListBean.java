/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.DualListModel;

/**
 *
 * @author gleyw
 */
@Named(value = "pickListBean")
@ViewScoped
public class PickListBean implements Serializable{
    private DualListModel<String> pessoas;

    public PickListBean() {
        List<String> origem = new ArrayList<String>();
        List<String> destino = new ArrayList<String>();
        
        origem.add("Gleywson");
        origem.add("William");
        origem.add("Vandisney");
        origem.add("Paulo");
        origem.add("Fábio");
        origem.add("Gerson");
        origem.add("Daniel");
        origem.add("Renato");
        origem.add("Reinaldo");
        origem.add("João");
        
        pessoas = new DualListModel<String>(origem, destino);
    }
    
    

    public DualListModel<String> getPessoas() {
        return pessoas;
    }

    public void setPessoas(DualListModel<String> pessoas) {
        this.pessoas = pessoas;
    }
    
    
}
