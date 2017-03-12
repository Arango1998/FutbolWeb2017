/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.Categoria;
import com.futbolWeb.backend.persistens.facades.CategoriaFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "categoriaManagedBean")
@RequestScoped
public class CategoriaManagedBean implements Serializable{
    
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
    
    @PostConstruct
    public void init(){
    categoria = new Categoria();
    }
    
    public void registrarCategoria(){
        try {
            categoriaEJB.create(categoria);
        } catch (Exception e) {
        }
    }

   
    public CategoriaManagedBean() {
        
        
    }
    
}
