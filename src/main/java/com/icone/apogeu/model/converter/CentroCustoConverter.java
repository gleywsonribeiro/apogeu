/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model.converter;

import com.icone.apogeu.model.CentroDeCusto;
import com.icone.apogeu.model.Patrimonio;
import com.icone.apogeu.model.repository.CentroDeCustoFacade;
import com.icone.apogeu.model.repository.PatrimonioFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gleyw
 */
@Named("centroCustoConverter")
public class CentroCustoConverter implements Converter{

    @Inject
    private CentroDeCustoFacade repositorio;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        CentroDeCusto setor = null;
        if(value != null) {
            Long id = new Long(value);
            setor = repositorio.find(id);
        }
        return setor;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if(value != null) {
            return ((CentroDeCusto)value).getId().toString();
        } else {
            return "";
        }
    }
    
}
