/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.Barrio;
import com.futbolWeb.backend.persistens.facades.BarrioFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author camila
 */
@Named(value = "barrioManagedBean")
@RequestScoped
public class BarrioManagedBean {

    private Barrio barrio;
    @EJB
    private BarrioFacadeLocal barriofl;

    public BarrioManagedBean() {
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    @PostConstruct
    public void init() {

        barrio = new Barrio();
    }

    public List<Barrio> listarBarrio(){
    
        return barriofl.findAll();
    }
    public void registrarBarrio() {

        barriofl.create(barrio);
    }
}
