$(document).ready(function(){
    $('#form-recuperar').on('submit',function(e){
        e.preventDefault();
        $('#overlay').fadeIn();
        $.ajax({
            'url' : base_url + 'enviar_recuperacion',
            'type' : 'post',
            'data' : {mail : $('#mail').val()},
            'success' : function(obj){
                console.log(obj['resultado']);
                if(obj['resultado']){
                    $('#overlay').fadeOut();
                    Swal.fire(
                        'Correo enviado',
                        'Revisa tu correo para ver tu contraseña',
                        'success'
                      );
                }else{
                    $('#overlay').fadeOut();
                    Swal.fire(
                        
                        'No se pudo enviar el correo',
                        'Error: ' + obj['error'],
                        'error'
                      );
                }
            }
        });
    });
});


