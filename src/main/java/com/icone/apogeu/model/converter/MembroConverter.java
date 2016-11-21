/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model.converter;

import com.icone.apogeu.model.Membro;
import com.icone.apogeu.model.repository.MembroFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gleywson
 */
@Named(value = "membroConverter")
//@FacesConverter(value = "membroConverter")
public class MembroConverter implements Converter{
    @Inject
    private MembroFacade repositorio;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Membro membro = null;
        if(value != null) {
            Long id = new Long(value);
            membro = repositorio.find(id);
        }
        return membro;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            return ((Membro)value).getId().toString();
        }
        return "";
    }
    
}
