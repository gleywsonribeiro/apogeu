/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model.repository;

import com.icone.apogeu.model.ContaPagar;
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
public class ContaPagarFacade extends AbstractFacade<ContaPagar> {

    @PersistenceContext(unitName = "agenda")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContaPagarFacade() {
        super(ContaPagar.class);
    }
    
    public List<ContaPagar> getContasPorTemplo(Templo templo) {
        TypedQuery<ContaPagar> query = getEntityManager().createNamedQuery("ContaPorTemplo", ContaPagar.class);
        query.setParameter("templo", templo);
        
        return query.getResultList();
    }
    
    public List<ContaPagar> getContasPendentes(Templo templo) {
        TypedQuery<ContaPagar> query = getEntityManager().createNamedQuery("ContaPendentePorTemplo", ContaPagar.class);
        query.setParameter("templo", templo);
        
        return query.getResultList();
    }
}
