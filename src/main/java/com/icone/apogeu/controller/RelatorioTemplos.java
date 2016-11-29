/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gleyw
 */
@Named(value = "relatorioTemplos")
@RequestScoped
public class RelatorioTemplos {

    @Inject
    private FacesContext facesContext;
    
    @Inject
    private HttpServletResponse response;
    
    @PersistenceContext(unitName = "agenda")
    private EntityManager manager;
    
    public RelatorioTemplos() {
        
    }
    
    
    public void emitir() {
        
    }
}
