/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.EstadoUsuario;
import com.futbolWeb.backend.persistens.facades.EstadoUsuarioFacade;

import com.futbolWeb.frontend.utilities.converters.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "estadoUsuarioManagedBean")
@RequestScoped
public class EstadoUsuarioManagedBean implements Serializable, InterfaceController<EstadoUsuario> {

    private EstadoUsuario estadoUsuario;
    @EJB
    private EstadoUsuarioFacade ef;
    public EstadoUsuarioManagedBean() {
    }
    @PostConstruct
    public void init(){
    estadoUsuario = new EstadoUsuario();
    
    }

    @Override
    public EstadoUsuario getObjectByKey(Integer key) {
    return ef.find(ef);
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
    
    
    public List<EstadoUsuario> listar(){
    return ef.findAll();
    }
    
    public void crearEstado(){
    ef.create(estadoUsuario);
    }
    
}
