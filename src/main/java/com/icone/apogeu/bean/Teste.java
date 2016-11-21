/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icone.apogeu.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gleyw
 */
@Named(value = "teste")
@SessionScoped
public class Teste implements Serializable {

    public Date getDataAtual() {
        return new Date();
    }

    public void atualizar() {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
