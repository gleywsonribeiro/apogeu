/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.model.repository;

import com.icone.apogeu.model.Membro;
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
public class MembroFacade extends AbstractFacade<Membro> {

    @PersistenceContext(unitName = "agenda")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MembroFacade() {
        super(Membro.class);
    }
    
    public List<Membro> getMembrosDisponiveisParaEbd(Templo templo) {
        TypedQuery<Membro> query = getEntityManager().createNamedQuery("Membros.Disponiveis", Membro.class);
        query.setParameter("templo", templo);
        
        return query.getResultList();
    }
    
    public List<Membro> getMembrosPorNome(String nome) { //from Membro upper(nome) like :nome
        return getEntityManager().createQuery("SELECT m FROM Membro AS m WHERE UPPER(m.nome) LIKE :nome", Membro.class)
                .setParameter("nome","%" + nome.toUpperCase() + "%").getResultList();
    }
}
