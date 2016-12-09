/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Templo;
import com.icone.apogeu.model.repository.TemploFacade;
import com.icone.apogeu.util.jsf.JsfUtil;
import com.icone.apogeu.util.report.ExecutorRelatorio;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author gleyw
 */
@Named(value = "relatorioTemplos")
@RequestScoped
public class RelatorioTemplos {

    @Inject
    private FacesContext facesContext;

    @Inject
    private HttpServletResponse response;

    @Inject
    TemploFacade repository;

    public void emitir() {
        Map<String, Object> parametros = new HashMap<String, Object>();

        ExecutorRelatorio executor = new ExecutorRelatorio("/relatorios/templos.jasper", this.response, parametros, "Templos.pdf");

        List<Templo> templos = repository.findAll();
        
        JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(templos);
        
        try {
            executor.execute(source);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioTemplos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (executor.isRelatorioGerado()) {
            facesContext.responseComplete();
        } else {
            JsfUtil.addErrorMessage("A execução do relatório não retornou dados.");
        }

    }
}
