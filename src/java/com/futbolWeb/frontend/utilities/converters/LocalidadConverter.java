/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.utilities.converters;

import com.futbolWeb.backend.persistence.entities.Localidad;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author camila
 */
@FacesConverter(forClass = Localidad.class)
public class LocalidadConverter extends AbstractConverter {

    public LocalidadConverter() {
        this.nameManagedBean = "localidadManagedBean";
    }

}
