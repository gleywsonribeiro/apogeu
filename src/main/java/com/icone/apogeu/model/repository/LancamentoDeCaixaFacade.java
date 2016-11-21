/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model.repository;

import com.icone.apogeu.model.LancamentoDeCaixa;
import com.icone.apogeu.model.Templo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author raque
 */
@Stateless
public class LancamentoDeCaixaFacade extends AbstractFacade<LancamentoDeCaixa> {

    @PersistenceContext(unitName = "agenda")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LancamentoDeCaixaFacade() {
        super(LancamentoDeCaixa.class);
    }
    
    public List<LancamentoDeCaixa> getLancamentosPorTemplo(Templo templo) {
        TypedQuery<LancamentoDeCaixa> query = getEntityManager().createNamedQuery("lancamentoPorTemplo", LancamentoDeCaixa.class);
        query.setParameter("templo", templo);
        
        return query.getResultList();
    }
    
}
