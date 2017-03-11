/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.Torneo;
import com.futbolWeb.backend.persistens.facades.TorneoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author camila
 */
@Named(value = "torneoManagedBean")
@RequestScoped
public class TorneoManagedBean {

    private Torneo torneo;
    @EJB
    private TorneoFacadeLocal torneofl;

    public TorneoManagedBean() {
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    @PostConstruct
    public void init() {
        torneo = new Torneo();
    }
    
    public List<Torneo> listarTorneo(){
    
        return torneofl.findAll();
    }
    
    public void registrarTorneo(){
    
    torneofl.create(torneo);
    }
}
