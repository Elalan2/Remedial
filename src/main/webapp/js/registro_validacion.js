/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
        
    var intervalo = setInterval( function() {
	$('#loading').removeClass('loading');
    }, 2000 );
    
    $('#form_registro').validate({
        rules:{
            mail:{required: true, email:true, minlength: 8, maxlength: 80},
            nombre:{required: true, text:true, minlength: 8, maxlength: 80},
            apellido:{required: true, text:true, minlength: 8, maxlength: 80},
            pass:{required: true, password:true, minlength: 8, maxlength: 80},
            pass2:{required: true, password:true, minlength: 8, maxlength: 80}

        },
        messages:{
            mail:{required: 'El campo es requerido', email:'el formato de email es incorrcto', minlength:'El minimo permitido son 8 caracteres', maxlength:'el maximo permitido son 80 caracteres'},
            nombre:{required: 'El campo es requerido', text:'el formato del nombre es incorrcto', minlength:'El minimo permitido son 8 caracteres', maxlength:'el maximo permitido son 80 caracteres'},
            apellido:{required: 'El campo es requerido', text:'el formato del apellido es incorrcto', minlength:'El minimo permitido son 8 caracteres', maxlength:'el maximo permitido son 80 caracteres'},
            pass:{required: 'El campo es requerido', password:'el formato de la contraseña es incorrecto', minlength:'El minimo permitido son 8 caracteres', maxlength:'el maximo permitido son 80 caracteres'},
            pass2:{required: 'El campo es requerido', password:'Repetir contraseña', minlength:'El minimo permitido son 8 caracteres', maxlength:'el maximo permitido son 80 caracteres'}

        }
    });
    //http://localhost:8080/evaluacion_1_web-master/login
   
});

