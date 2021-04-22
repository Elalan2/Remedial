/*
$(document).ready(function(){
        
        $('#form-login').validate({
            rules:{
                txtUsu:{required: true, txtUsu:true, minlength: 4, maxlength: 30}
            },
            messages:{
                txtUsu:{required: 'El campo es Necesario', txtUsu:'El formato es incorrecto', minlength:'El minimo permitido es de 4 caracteres', maxlength:'el maximo es de 30 caracteres'}
            }
        });
   
});
*/
document.getElementById('btniniciar').addEventListener("click", function(){
   
        var usuario = document.getElementById('txtUsu').value;
        var password = document.getElementById('txtPass').value;
        
        var bandera = false;
        
        if(usuario.length>0 && password.length>0){
            bandera = true;
        }
        if(bandera){
            document.getElementById('form-login').submit();
        }else{
            alert('Porfavor rellene todos los campos');
        }
    });

