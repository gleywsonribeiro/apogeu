/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Templo;
import com.icone.apogeu.model.repository.TemploFacade;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

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
    
    @PersistenceContext(unitName = "agenda")
    private EntityManager em;

    public void emitir() {
        try {
            List<Templo> templos = repository.findAll();
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            String arquivo = "/relatorios/templos.jasper2";
            InputStream relatorioStream = this.getClass().getResourceAsStream(arquivo);
            
            JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(templos);
            
            JasperPrint print = JasperFillManager.fillReport(relatorioStream, parametros, em.getc;)
            JRExporter exportador = new JRPdfExporter();
            exportador.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
            exportador.setParameter(JRExporterParameter.JASPER_PRINT, print);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\""
                    + arquivo + "\"");

            exportador.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(RelatorioTemplos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RelatorioTemplos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
