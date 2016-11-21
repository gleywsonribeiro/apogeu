/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model.converter;

import com.icone.apogeu.model.Cargo;
import com.icone.apogeu.model.repository.CargoFacade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gleywson
 */
@Named(value = "cargoConverter")
public class CargoConverter implements Converter{

    @Inject
    private CargoFacade repositorio;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Cargo cargo = null;
        if(value != null) {
            Long id = new Long(value);
            cargo = repositorio.find(id);
        }
        return cargo;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if(value != null) {
            return ((Cargo)value).getId().toString();
        } else {
            return "";
        }
    }
    
}
