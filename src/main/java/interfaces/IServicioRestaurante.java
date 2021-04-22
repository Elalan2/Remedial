/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dtos.DtoDetalleReciboRestaurante;
import dtos.DtoMenu;
import java.util.List;

/**
 *
 * @author Adry
 */
public interface IServicioRestaurante {
    
    public List<DtoMenu> read() throws Exception;
    public DtoMenu readOrde(int idMenu) throws Exception;
    public List<DtoMenu> readOrden(int idMenu) throws Exception;
    public boolean pedir(DtoDetalleReciboRestaurante dto)throws Exception;
    public boolean create(DtoMenu dto) throws Exception;
    public boolean update(DtoMenu dto) throws Exception;
    
    public boolean terimnarorden(int idmenu, int cantidad, float subtotal) throws Exception;
    
}
