/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model.converter;

import com.icone.apogeu.model.Membro;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

/**
 *
 * @author raque
 */
@Named(value = "converterPickMembro")
public class ConverterPickMembro implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Object object = null;
        if (component instanceof PickList) {
            Object dualList = ((PickList) component).getValue();
            DualListModel model = (DualListModel) dualList;
            for (Object obj : model.getSource()) {
                String id = "" + ((Membro) obj).getId();
                if (value.equals(id)) {
                    object = obj;
                    break;
                }
            }
            if (object == null) {
                for (Object obj : model.getTarget()) {
                    String id = "" + ((Membro) obj).getId();
                    if (value.equals(id)) {
                        object = obj;
                        break;
                    }
                }
            }
        }
        
        return object;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String id = "";
        
        if(value instanceof Membro) {
            id = ""+((Membro)value).getId();
        }
        return id;
    }

}
