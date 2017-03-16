/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.PosicionSeguimiento;
import com.futbolWeb.backend.persistens.facades.PosicionSeguimientoFacadeLocal;
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
@Named(value = "posicionSeguimientoManagedBean")
@RequestScoped
public class PosicionSeguimientoManagedBean implements Serializable, InterfaceController<PosicionSeguimiento> {

    private PosicionSeguimiento posicionseguimiento;
    @EJB
    private PosicionSeguimientoFacadeLocal psfl;
    
    
    public PosicionSeguimientoManagedBean() {
    }

    public PosicionSeguimiento getPosicionseguimiento() {
        return posicionseguimiento;
    }

    public void setPosicionseguimiento(PosicionSeguimiento posicionseguimiento) {
        this.posicionseguimiento = posicionseguimiento;
    }
    
    @PostConstruct
    public void init(){
        posicionseguimiento = new PosicionSeguimiento();
    }
    
    
    public void registrarPosicionSeguimiento(){
        psfl.create(posicionseguimiento);
    }
    
    public void modificarPosicionSeguimiento(){
        psfl.edit(posicionseguimiento);
    }
    
    public void eliminarPosicionSeguimiento(PosicionSeguimiento ps){
        psfl.remove(posicionseguimiento);
    }
    
    public String actualizarPosicionSeguimiento(PosicionSeguimiento posseg){
        posicionseguimiento = posseg;
        return "";
    }
    
    public List<PosicionSeguimiento> listarPosicionSeguimiento(){
        return psfl.findAll();
    }

    @Override
    public PosicionSeguimiento getObjectByKey(Integer key) {
        return psfl.find(key);
    }
    
}
