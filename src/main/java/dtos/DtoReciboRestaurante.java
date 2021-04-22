/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import org.apache.log4j.helpers.DateTimeDateFormat;

/**
 *
 * @author Adry
 */
public class DtoReciboRestaurante {
    int idReciboR;
    int idCuarto;
    DateTimeDateFormat Fecha;

    public void setIdReciboR(int idReciboR) {
        this.idReciboR = idReciboR;
    }

    public void setIdCuarto(int idCuarto) {
        this.idCuarto = idCuarto;
    }

    public void setFecha(DateTimeDateFormat Fecha) {
        this.Fecha = Fecha;
    }

    public int getIdReciboR() {
        return idReciboR;
    }

    public int getIdCuarto() {
        return idCuarto;
    }

    public DateTimeDateFormat getFecha() {
        return Fecha;
    }
}
