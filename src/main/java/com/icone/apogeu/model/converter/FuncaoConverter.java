/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model.converter;

import com.icone.apogeu.model.Funcao;
import com.icone.apogeu.model.repository.FuncaoFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gleywson
 */
//@FacesConverter(value = "funcaoConverter")
@Named(value = "funcaoConverter")
public class FuncaoConverter implements Converter{

    @Inject
    private FuncaoFacade repositorio;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Funcao funcao = null;
        if(value != null) {
            Long id = new Long(value);
            funcao = repositorio.find(id);
        }
        return funcao;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if(value != null) {
            return ((Funcao)value).getId().toString();
        } else {
            return "";
        }
        
    }
    
}
