/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.controller;

import com.icone.apogeu.model.LancamentoDeCaixa;
import com.icone.apogeu.model.Templo;
import com.icone.apogeu.model.repository.LancamentoDeCaixaFacade;
import com.icone.apogeu.model.repository.TemploFacade;
import com.icone.apogeu.util.jsf.JsfUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author gleyw
 */
@Named(value = "lancamentoCaixaController")
@ViewScoped
public class LancamentoDeCaixaController implements Serializable{
    @Inject
    private LancamentoDeCaixaFacade lancamentoRepository;
    private LancamentoDeCaixa lancamento;
    private List<LancamentoDeCaixa> lancamentos;
    
    @Inject
    private TemploFacade temploRepository;
    private Templo templo;
    private List<Templo> templos;

    public LancamentoDeCaixaController() {
        inicializa();
    }
    
    private void inicializa() {
        templo = new Templo();
        lancamento = new LancamentoDeCaixa();
        templos = null;
        lancamentos = new ArrayList<LancamentoDeCaixa>();
    }
    
    public void salvar() {
        lancamento.setTemplo(templo);
        if(lancamento.getId() == null) {
            lancamentoRepository.create(lancamento);
        } else {
            lancamentoRepository.edit(lancamento);
        }
        lancamento = new LancamentoDeCaixa();
        lancamentos = null;
        JsfUtil.addMessage("Lançamento realizado com sucesso!");
    }
    
    public LancamentoDeCaixa getLancamento() {
        return lancamento;
    }

    public void setLancamento(LancamentoDeCaixa lancamento) {
        this.lancamento = lancamento;
    }

    public Templo getTemplo() {
        return templo;
    }

    public void setTemplo(Templo templo) {
        this.templo = templo;
    }

    
    
    public List<Templo> getTemplos() {
        if(templos == null) {
            templos = temploRepository.findAll();
        }
        return templos;
    }
    
    public List<LancamentoDeCaixa> getLancamentos() {
        return lancamentos;
    }
   
    public void atualizaLista() {
        lancamentos = lancamentoRepository.getLancamentosPorTemplo(templo);
    }
    
    
}
