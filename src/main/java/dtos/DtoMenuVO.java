/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Craft
 */
public class DtoMenuVO {
   private int idMenu;
   private String elemento;
   private String tamaño;
   private float precio;
   private int idRestaurante;
   private int cantidad;

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public DtoMenuVO(DtoMenu dto,int cantidad) {
        super();
        this.idMenu=dto.getIdMenu();
        this.elemento=dto.getElemento();
        this.tamaño=dto.getTamaño();
        this.precio=dto.getPrecio();
        this.cantidad=cantidad;
    }
   
   
}
