/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model.converter;

import com.icone.apogeu.model.Admissao;
import com.icone.apogeu.model.repository.AdmissaoFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gleywson
 */
@Named(value = "admissaoConverter")
public class AdmissaoConverter implements Converter {

    @Inject
    private AdmissaoFacade repositorio;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Admissao admissao = null;
        if(value != null) {
            Long id = new Long(value);
            admissao = repositorio.find(id);
        }
        return admissao;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if(value != null) {
            return ((Admissao)value).getId().toString();
        } else {
            return "";
        }
    }

}
