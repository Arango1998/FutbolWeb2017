/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.utilities.converters;

/**
 *
 * @author Cristian Suesca
 */


public interface InterfaceController<T>{
    
    T getObjectByKey(Integer key);
    
}