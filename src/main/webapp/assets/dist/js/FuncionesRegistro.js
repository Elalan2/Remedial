/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function coincidirContras(){
    var txtPass = document.getElementById("txtPass");
    var txtRepetirPass = document.getElementById("txtRepetirPass");
    var avisoContraseña = document.getElementById("avisoContraseña");
    
    if(txtPass.value.length == 0 || txtRepetirPass.value.length == 0){
        avisoContraseña.innerHTML = "Las contraseñas no pueden estan vacias";
    }else if(txtPass.value != txtRepetirPass.value){
        avisoContraseña.innerHTML = "Las contraseñas no coinciden";
    }else{
        avisoContraseña.innerHTML = "";
    }
    
}
