/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model.converter;

import com.icone.apogeu.model.Integracao;
import com.icone.apogeu.model.repository.IntegracaoFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gleywson
 */
@Named(value = "grupoIntegracaoConverter")
public class GrupoIntegracaoConverter implements Converter{

    @Inject
    private IntegracaoFacade repositorio;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Integracao grupoIntegracao = null;
        if(value != null) {
            Long id = new Long(value);
            grupoIntegracao = repositorio.find(id);
        }
        return grupoIntegracao;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if(value != null) {
            return ((Integracao)value).getId().toString();
        } else {
            return "";
        }
    }
    
}
