/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.Localidad;
import com.futbolWeb.backend.persistens.facades.LocalidadFacadeLocal;
import com.futbolWeb.frontend.utilities.converters.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author camila
 */
@Named(value = "localidadManagedBean")
@RequestScoped
public class LocalidadManagedBean implements Serializable, InterfaceController<Localidad> {

    private Localidad localidad;
    @EJB
    private LocalidadFacadeLocal localidadfl;

    public LocalidadManagedBean() {
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    @PostConstruct
    public void init() {

        localidad = new Localidad();

    }

    public List<Localidad> listarLocalidad() {

        return localidadfl.findAll();
    }

    public void registrarLocalidad() {

        localidadfl.create(localidad);

    }

    @Override
    public Localidad getObjectByKey(Integer key) {
        return localidadfl.find(key);
    }
}
