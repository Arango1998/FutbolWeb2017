/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.utilities.converters;

import com.futbolWeb.backend.persistence.entities.Barrio;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Barrio.class)
public class BarrioController extends AbstractConverter {

    public BarrioController() {

        this.nameManagedBean = "barrioManagedBean";
    }

}
