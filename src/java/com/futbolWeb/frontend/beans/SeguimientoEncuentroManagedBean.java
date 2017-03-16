/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.SeguimientoEncuentro;
import com.futbolWeb.backend.persistens.facades.SeguimientoEncuentroFacadeLocal;
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
@Named(value = "seguimientoEncuentroManagedBean")
@RequestScoped
public class SeguimientoEncuentroManagedBean implements Serializable, InterfaceController<SeguimientoEncuentro> {

    private SeguimientoEncuentro seguimientoencuentro;
    @EJB
    private SeguimientoEncuentroFacadeLocal sefl;
    
    
    public SeguimientoEncuentroManagedBean() {
    }
    

    public SeguimientoEncuentroFacadeLocal getSefl() {
        return sefl;
    }

    public void setSefl(SeguimientoEncuentroFacadeLocal sefl) {
        this.sefl = sefl;
    }
    
   @PostConstruct
   public void init(){
       seguimientoencuentro = new SeguimientoEncuentro();
   }
   
   public void registrarSeguimientoEncuentro(){
       sefl.create(seguimientoencuentro);
   }
   
   public void modificarSeguimientoEncuentro(){
       sefl.edit(seguimientoencuentro);
   }
   
   public void eliminarSeguimientoEncuentro(SeguimientoEncuentro segen){
       sefl.remove(seguimientoencuentro);
   }
   
   public String actualizarSegumientoEncuentro (SeguimientoEncuentro segenc){
       seguimientoencuentro = segenc;
       return "";
   }
   
   public List<SeguimientoEncuentro> listarSeguimientoEncuentro(){
       return sefl.findAll();
   }
    
    

    @Override
    public SeguimientoEncuentro getObjectByKey(Integer key) {
        return sefl.find(key);
    }
    
    
    
}
