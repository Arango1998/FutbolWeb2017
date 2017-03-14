/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.Seguimiento;
import com.futbolWeb.backend.persistens.facades.SeguimientoFacadeLocal;
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
@Named(value = "seguimientoManagedBean")
@RequestScoped
public class SeguimientoManagedBean implements Serializable, InterfaceController<Seguimiento>{
    
    private Seguimiento seguimiento;
    @EJB
    private SeguimientoFacadeLocal seguimientofl;
    
    public SeguimientoManagedBean() {
    }

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }
    
    
    @PostConstruct
    public void init(){
        seguimiento = new Seguimiento();
    }
    
    
    public void registrarSeguimiento(){
        seguimientofl.create(seguimiento);
    }
    
    
    public List<Seguimiento> listarSeguimiento(){
        return seguimientofl.findAll();
    }

    @Override
    public Seguimiento getObjectByKey(Integer key) {
        return seguimientofl.find(key);
    }
    
    
    
    
    
}
