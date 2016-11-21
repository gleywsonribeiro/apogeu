/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model.converter;

import com.icone.apogeu.model.Templo;
import com.icone.apogeu.model.repository.TemploFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gleyw
 */
@Named(value = "temploConverter")
public class TemploConverter implements Converter{
    @Inject
    TemploFacade repositorio;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
         Templo templo = null;
        if(value != null) {
            Long id = new Long(value);
            templo = repositorio.find(id);
        }
        return templo;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if(value != null) {
            return ((Templo)value).getId().toString();
        } else {
            return "";
        }
    }

    
}
