/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.Contato;
import com.icone.apogeu.model.Endereco;
import com.icone.apogeu.model.Escolaridade;
import com.icone.apogeu.model.EstadoCivil;
import com.icone.apogeu.model.InfoEmpresa;
import com.icone.apogeu.model.Membro;
import com.icone.apogeu.model.Sexo;
import com.icone.apogeu.model.repository.MembroFacade;
import com.icone.apogeu.service.NegocioException;
import com.icone.apogeu.util.jsf.JsfUtil;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.transaction.RollbackException;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author raque
 */
@Named(value = "membroController")
@SessionScoped
public class MembroController implements Serializable {

    @Inject
    private MembroFacade repositorio;
    private Membro membro;
    private List<Membro> membros;

    public MembroController() {
        inicializaMembro();
    }

    private void inicializaMembro() {
        membro = new Membro();
        membro.setDataCadastro(new Date());
        membro.setEmpresa(new InfoEmpresa());
        membro.setContato(new Contato());
        membro.setEndereco(new Endereco());
        membros = null;
    }

    public void salvar() {
        if (membro.getId() == null) {
            repositorio.create(membro);
            JsfUtil.addMessage("Cadastro realizado com sucesso!");
        } else {
            repositorio.edit(membro);
            JsfUtil.addMessage("Cadastro alterado com sucesso!");
        }
        inicializaMembro();
        //FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/telas/secretaria");
//        JsfUtil.redirect("/faces/telas/secretaria/membro/pesquisaMembros.xhtml");
    }

    public String novoMembro() {
        inicializaMembro();
        return "cadastroMembro?faces-redirect=true";
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public List<Membro> getMembros() {
        if (membros == null) {
            membros = repositorio.findAll();
        }
        return membros;
    }

    public void remover() {
        try {
            repositorio.remove(membro);
            membros = null;
            JsfUtil.addMessage("Membro removido com sucesso.");
            inicializaMembro();
        } catch (EJBException e) {
            throw new NegocioException("Não é possível remover registro!");
        }
    }

    //Enumerações
    public EstadoCivil[] getEstadosCivis() {
        return EstadoCivil.values();
    }

    public Escolaridade[] getEscolaridades() {
        return Escolaridade.values();
    }

    public Sexo[] getSexos() {
        return Sexo.values();
    }
}
