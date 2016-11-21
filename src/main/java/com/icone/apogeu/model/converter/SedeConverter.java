/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model.converter;

import com.icone.apogeu.model.Sede;
import com.icone.apogeu.model.repository.SedeFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gleywson
 */
@Named(value = "sedeConverter")
public class SedeConverter implements Converter{
    @Inject
    private SedeFacade repositorio;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Sede sede = null;
        if(value != null) {
            Long id = new Long(value);
            sede = repositorio.find(id);
        }
        return sede;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if(value != null) {
            return ((Sede)value).getId().toString();
        }
        return "";
    }
    
}
