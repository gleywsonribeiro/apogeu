/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller.relatorio;

import com.icone.apogeu.model.Membro;
import com.icone.apogeu.model.repository.MembroFacade;
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
 * @author raque
 */
@Named(value = "relatorioMembros")
@RequestScoped
public class RelatorioMembros {

    @Inject
    private FacesContext facesContext;

    @Inject
    private HttpServletResponse response;
    
    private MembroFacade repositorio;
    
    public void emitir() {
        Map<String, Object> parametros = new HashMap<String, Object>();

        ExecutorRelatorio executor = new ExecutorRelatorio("/relatorios/membros.jasper", this.response, parametros, "Membros por Templos.pdf");

        List<Membro> membros = repositorio.findAll();
        
        JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(membros);
        
        try {
            executor.execute(source);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioMembros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (executor.isRelatorioGerado()) {
            facesContext.responseComplete();
        } else {
            JsfUtil.addFatalMessage("relatorios", "A execução do relatório não retornou dados.");
        }
    }
}
