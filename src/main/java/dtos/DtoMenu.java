
package dtos;

/**
 *
 * @author Adry
 */
public class DtoMenu {
   int idMenu;
   String elemento;
   String tamaño;
   float precio;
   int idRestaurante;
   

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public String getElemento() {
        return elemento;
    }

    public String getTamaño() {
        return tamaño;
    }

    public float getPrecio() {
        return precio;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }
    
}
