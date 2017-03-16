/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.Jugador;
import com.futbolWeb.backend.persistens.facades.JugadorFacadeLocal;
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
@Named(value = "jugadorManagedBean")
@RequestScoped
public class JugadorManagedBean  implements Serializable, InterfaceController<Jugador>{

    private Jugador jugador;
    @EJB
    private JugadorFacadeLocal jugadorfl;
    
    public JugadorManagedBean() {
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    
    @PostConstruct
    public void init(){
        jugador = new Jugador();
    }
    
    public void registrarJugador(){
        jugadorfl.create(jugador);
    }
    
    public void modificarJugador(){
        jugadorfl.edit(jugador);
    }
    
    public void eliminarJugador(Jugador j){
        jugadorfl.remove(jugador);
    }
    
    public String actualizarJugador(Jugador jug){
        jugador = jug;
        return "";
    }
    
    public List<Jugador> listarJugador(){
        return jugadorfl.findAll();
    }
    

    @Override
    public Jugador getObjectByKey(Integer key) {
        return jugadorfl.find(key);
    }
    
    
    
}
