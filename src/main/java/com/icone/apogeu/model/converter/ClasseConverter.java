/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model.converter;

import com.icone.apogeu.model.Classe;
import com.icone.apogeu.model.repository.ClasseFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gleyw
 */
@Named(value = "classeConverter")
public class ClasseConverter implements Converter {
    
    @Inject
    private ClasseFacade repositorio;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Classe classe = null;
        if(value != null) {
            Long id = new Long(value);
            classe = repositorio.find(id);
        }
        return classe;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            return ((Classe)value).getId().toString();
        } else {
            return "";
        }
    }

}
