/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gleyw
 */
@Named(value = "produtosBean")
@SessionScoped
public class ProdutosBean implements Serializable {
    private List<String> produtos;
    private String produtoSelecionado;
    
    public ProdutosBean() {
        produtos = new ArrayList<String>();
        produtos.add("Arroz");
        produtos.add("Feijão");
        produtos.add("Queijo");
        produtos.add("notebook");
        
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public String getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(String produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }
    
    public void excluirProduto() {
        produtos.remove(produtoSelecionado);
    }
}
