/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.bean;

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
@Named(value = "sedeBean")
@SessionScoped
public class SedeBean implements Serializable {

    private List<Integer> sedes;
    
    @PostConstruct
    public void init() {
        sedes = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            sedes.add(i);
        }
    }

    public List<Integer> getSedes() {
        return sedes;
    }
    
    
}
