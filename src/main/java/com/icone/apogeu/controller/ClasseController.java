/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Classe;
import com.icone.apogeu.model.repository.ClasseFacade;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author gleyw
 */
@Named(value = "classeController")
@ViewScoped
public class ClasseController implements Serializable{

    private Classe classe;
    private ClasseFacade repositorio;
    
    
}
