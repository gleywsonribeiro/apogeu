/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.LancamentoFinanceiro;
import com.icone.apogeu.model.Templo;
import com.icone.apogeu.model.repository.LancamentoFinanceiroFacade;
import com.icone.apogeu.model.repository.TemploFacade;
import com.icone.apogeu.util.jsf.JsfUtil;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author gleyw
 */
@Named(value = "lancamentoFinanceiroController")
//@ConversationScoped
@SessionScoped
public class LancamentoFinanceiroController implements Serializable {

    //private @Inject Conversation conversation;
    
    @Inject
    private TemploFacade temploRepository;
    private List<Templo> templos;
    private Templo templo;

    @Inject
    private LancamentoFinanceiroFacade lancamentoReporitory;
    private List<LancamentoFinanceiro> lancamentos;
    private LancamentoFinanceiro lancamento;

    public LancamentoFinanceiroController() {
        inicializa();
    }
    
    private void inicializa() {
        this.lancamento = new LancamentoFinanceiro();
        this.templo = new Templo();
        this.templos = null;
        this.lancamentos = null;
    }

    public List<Templo> getTemplos() {
        if (templos == null) {
            templos = temploRepository.findAll();
        }
        return templos;
    }

    public Templo getTemplo() {
        return templo;
    }

    public void setTemplo(Templo templo) {
        this.templo = templo;
    }

    public LancamentoFinanceiro getLancamento() {
        return lancamento;
    }

    public void setLancamento(LancamentoFinanceiro lancamento) {
        this.lancamento = lancamento;
    }

    public void salvar() {
        lancamento.setTemplo(templo);
        if (lancamento.getId() == null) {
            lancamentoReporitory.create(lancamento);
        } else {
            lancamentoReporitory.edit(lancamento);
        }
        lancamento = new LancamentoFinanceiro();
        lancamentos = null;
        JsfUtil.addMessage("Lançamento realizado com sucesso!");
    }

    public List<LancamentoFinanceiro> getLancamentos() {
        if (lancamentos == null) {
            lancamentos = lancamentoReporitory.getLancamentosFinanceirosPorTemplo(templo);
        }
        return lancamentos;
    }

    public String sair() {
        inicializa();
        return "templos?faces-redirect=true";
        //JsfUtil.redirect("/faces/telas/tesouraria/financeiro/templos.xhtml");
    }
}
