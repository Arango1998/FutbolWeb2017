/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.Desempenio;
import com.futbolWeb.backend.persistens.facades.DesempenioFacadeLocal;
import com.futbolWeb.frontend.utilities.converters.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Iesua
 */
@Named(value = "desempenioManagedBean")
@RequestScoped
public class DesempenioManagedBean implements Serializable, InterfaceController<Desempenio> {

    private Desempenio desempenio;
    @EJB
    private DesempenioFacadeLocal desempeniofl;
    
    
    public DesempenioManagedBean() {
    }

    public Desempenio getDesempenio() {
        return desempenio;
    }

    public void setDesempenio(Desempenio desempenio) {
        this.desempenio = desempenio;
    }
    
    
    @PostConstruct
    public void init(){
        desempenio = new Desempenio();
    }
    
    
    public void registrarDesempenio(){
        desempeniofl.create(desempenio);
    }
    
    public void modificarDesempenio(){
        desempeniofl.edit(desempenio);
    }
    
    public void eliminarDesempenio(Desempenio d){
        desempeniofl.remove(desempenio);
    }
    
    public String actualizarDesempanio(Desempenio des){
        desempenio = des;
        return "";
    }
    
    public List<Desempenio> listarDesempenio(){
        return desempeniofl.findAll();
    }

    @Override
    public Desempenio getObjectByKey(Integer key) {
        return desempeniofl.find(key);
    }
    
}
