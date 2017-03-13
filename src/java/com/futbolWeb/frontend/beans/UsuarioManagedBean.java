/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.Usuario;
import com.futbolWeb.backend.persistens.facades.UsuarioFacade;
import com.futbolWeb.frontend.utilities.converters.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "usuarioManagedBean")
@RequestScoped
public class UsuarioManagedBean implements Serializable, InterfaceController<Usuario>{
private Usuario usuario;
@EJB
private UsuarioFacade uf;
    @Inject
    private EstadoUsuarioManagedBean estadoUsuarioManagedBean;
    @Inject
    private RolManagedBean rolManagedBean;
    public UsuarioManagedBean() {
    }
    @PostConstruct
    public void init(){
    
         usuario = new Usuario();
    
    }

    @Override
    public Usuario getObjectByKey(Integer key) {
    return uf.find(uf);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoUsuarioManagedBean getEstadoUsuarioManagedBean() {
        return estadoUsuarioManagedBean;
    }

    public RolManagedBean getRolManagedBean() {
        return rolManagedBean;
    }

   
    
    public List<Usuario> listUsers() {

        return uf.findAll();
    }
    
    
     public void crearUsuario() {
        try {
            uf.create(usuario);
        } catch (Exception e) {
        }

    }
    
}
