/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.List;

/**
 *
 * @author Craft
 */
public class DtoListaListas {
    
    private List<DtoMenuVO> listas;

    public List<DtoMenuVO> getListas() {
        return listas;
    }

    public void setListas(List<DtoMenuVO> listas) {
        this.listas = listas;
    }

 public DtoListaListas(List<DtoMenuVO> li){
     
     this.listas=li;
 }


    
    
}
