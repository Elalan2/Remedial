/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alann
 */
public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String cotraseña;
    private String correo;
    private boolean estado;
    private int tipoUsu;
    
    public Usuario(){
    }
    
    public Usuario(int idUsuario,String nombreUsuario,String cotraseña,String correo,int tipoUsu,boolean estado){
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.cotraseña = cotraseña;
        this.correo = correo;
        this.estado = estado;
        this.tipoUsu = tipoUsu;
    }
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCotraseña() {
        return cotraseña;
    }

    public void setCotraseña(String cotraseña) {
        this.cotraseña = cotraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getTipoUsu() {
        return tipoUsu;
    }

    public void setTipoUsu(int tipoUsu) {
        this.tipoUsu = tipoUsu;
    }

    
    
    
    
}
