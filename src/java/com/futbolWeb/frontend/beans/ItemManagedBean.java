/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.Item;
import com.futbolWeb.backend.persistens.facades.ItemFacadeLocal;
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
@Named(value = "itemManagedBean")
@RequestScoped
public class ItemManagedBean implements Serializable, InterfaceController<Item> {

    private Item item;
    @EJB
    private ItemFacadeLocal itemfl;
    
    
    public ItemManagedBean() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    
    @PostConstruct
    public void init(){
        item = new Item();
    }
    
    public void registrarItem(){
        itemfl.create(item);
    }
    
    public void modificarItem(){
        itemfl.edit(item);
    }
    
    public void eliminarItem(Item it){
        itemfl.remove(item);
    }
    
    public String actualizarItem(Item ite){
        item = ite;
        return "";
    }
    
    
    public List<Item> listarItem(){
        return itemfl.findAll();
    }

    @Override
    public Item getObjectByKey(Integer key) {
        return itemfl.find(key);
    }
    
    
    
}
