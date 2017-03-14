/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.Valoracion;
import com.futbolWeb.backend.persistens.facades.ValoracionFacadeLocal;
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
@Named(value = "valoracionManagedBean")
@RequestScoped
public class ValoracionManagedBean implements Serializable, InterfaceController<Valoracion> {

    private Valoracion valoracion;
    @EJB
    private ValoracionFacadeLocal valoracionfl;
    
    
    public ValoracionManagedBean() {
    }

    
    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }
    
    @PostConstruct
    public void init (){
        valoracion = new Valoracion();
    }
    
    public void registrarValoracion(){
        valoracionfl.create(valoracion);
    }
    
    public List<Valoracion> listarValoracion(){
        return valoracionfl.findAll();
    }

    @Override
    public Valoracion getObjectByKey(Integer key) {
        return valoracionfl.find(key);
    }
    
    
    
}
