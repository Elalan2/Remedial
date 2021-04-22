/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Adry
 */
public class DtoDetalleReciboRestaurante {
    int idDetalle;
    int idReciboRestaurante;
    int idMenu;
    int cantidad;
    float subtotal;

    public void setIdDEtalle(int idDEtalle) {
        this.idDetalle = idDEtalle;
    }

    public void setIdReciboRestaurante(int idReciboRestaurante) {
        this.idReciboRestaurante = idReciboRestaurante;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public int getIdDEtalle() {
        return idDetalle;
    }

    public int getIdReciboRestaurante() {
        return idReciboRestaurante;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }
       
}
