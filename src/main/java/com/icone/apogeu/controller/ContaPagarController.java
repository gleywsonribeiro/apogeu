/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.ContaPagar;
import com.icone.apogeu.model.Templo;
import com.icone.apogeu.model.TipoPagamento;
import com.icone.apogeu.model.repository.ContaPagarFacade;
import com.icone.apogeu.model.repository.TemploFacade;
import com.icone.apogeu.util.jsf.JsfUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author gleyw
 */
@Named(value = "contaPagarController")
@SessionScoped
public class ContaPagarController implements Serializable {

    @Inject
    private ContaPagarFacade repositorio;
    private ContaPagar conta;
    private List<ContaPagar> contas;
    private List<ContaPagar> contasPendentes;

    @Inject
    private TemploFacade temploFacade;
    private Templo templo;
    private List<Templo> templos;

    public ContaPagarController() {
        inicializar();
    }

    private void inicializar() {
        conta = new ContaPagar();
        templo = new Templo();

        contas = null;
        contasPendentes = null;
        templos = null;
    }

    public ContaPagar getConta() {
        return conta;
    }

    public void setConta(ContaPagar conta) {
        this.conta = conta;
    }

    public List<ContaPagar> getContas() {
        if (contas == null) {
            contas = repositorio.getContasPorTemplo(templo);
        }
        return contas;
    }

    public List<ContaPagar> getContasPendentes() {
        if(contasPendentes == null) {
            contasPendentes = repositorio.getContasPendentes(templo);
        }
        return contasPendentes;
    }
    
    public TipoPagamento[] getFormasPagamento() {
        return TipoPagamento.values();
    }

    public Templo getTemplo() {
        return templo;
    }

    public void setTemplo(Templo templo) {
        this.templo = templo;
    }

    public List<Templo> getTemplos() {
        if (templos == null) {
            templos = temploFacade.findAll();
        }
        return templos;
    }

    public void salvar() {
        conta.setTemplo(templo);
        if (conta.getId() == null) {
            repositorio.create(conta);
        } else {
            repositorio.edit(conta);
        }
        conta = new ContaPagar();
        contas = null;
        contasPendentes = null;
        JsfUtil.addMessage("salvo com sucesso!");
    }

    public void pagar() {
        conta.setDataPagamento(new Date());
        salvar();
    }

    public String sair() {
        inicializar();
        return "templos?faces-redirect=true";
    }

}
