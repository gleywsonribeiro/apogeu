/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model.converter;

import com.icone.apogeu.model.Situacao;
import com.icone.apogeu.model.repository.SituacaoFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gleywson
 */
@Named(value = "situacaoConverter")
public class SituacaoConverter implements Converter{
    
    @Inject
    private SituacaoFacade repositorio;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Situacao situacao = null;
        if(value != null) {
            Long id = new Long(value);
            situacao = repositorio.find(id);
        }
        return situacao;
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if(value != null) {
            return ((Situacao)value).getId().toString();
        } else {
            return "";
        }
    }
    
}
