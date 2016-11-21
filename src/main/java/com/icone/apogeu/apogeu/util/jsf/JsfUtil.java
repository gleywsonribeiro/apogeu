/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.apogeu.util.jsf;

import java.io.IOException;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author gleywson
 */
public class JsfUtil {
    public static void redirect(String page) {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            String contextPath = externalContext.getRequestContextPath();

            externalContext.redirect(contextPath + page);
            facesContext.responseComplete();
        } catch (IOException ex) {
            throw new FacesException(ex);
        }
    }
    public static void addMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
    }
    
    public static void addErrorMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
    }
}
