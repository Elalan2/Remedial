/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 // Loading
//var Loading=(loadingDelayHidden=0)=>{let loading=null;const myLoadingDelayHidden=loadingDelayHidden;let imgs=[];let lenImgs=0;let counterImgsLoading=0;function incrementCounterImgs(){counterImgsLoading+=1;if(counterImgsLoading===lenImgs){hideLoading()}}function hideLoading(){if(loading!==null){loading.classList.remove('show');setTimeout(function(){loading.remove()},myLoadingDelayHidden)}}function init(){document.addEventListener('DOMContentLoaded',function(){loading=document.querySelector('.loading');imgs=Array.from(document.images);lenImgs=imgs.length;if(imgs.length===0){hideLoading()}else{imgs.forEach(function(img){img.addEventListener('load',incrementCounterImgs,false)})}})}return{'init':init}}
//Loading(1000).init();
$(document).ready(function(){
    var intervalo = setInterval( function() {
	$('#loading').removeClass('loading');
    }, 2000 );
    
    var tablaCompras = $('#dataTable').DataTable({
        responsive: true,
        "language": {
                "lengthMenu": "Mostrar _MENU_ registros",
                "zeroRecords": "No se encontraron resultados",
                "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                "infoFiltered": "(filtrado de un total de _MAX_ registros)",
                "sSearch": "Buscar:",
                "oPaginate": {
                        "sFirst": "Primero",
                        "sLast":"Último",
                        "sNext":"Siguiente",
                        "sPrevious": "Anterior"
                 },
                "sProcessing":"Procesando...",
        },
    });
    
    var columnas = [
		"Nombre",
		"Costo",
		"Fecha de compra"
	];
    $.ajax({
       'url' : base_url + 'obtener_compras',
       'type' : 'post',
       'success' : function(obj){
           var Tcon = "";
           $('#tabla-compras').html('');
           $.each(obj['compras'],function(i,elemento){
              var nuevaFila = tablaCompras.row.add([
                    elemento.nombre,
                    elemento.costo,
                    elemento.fecha
                 ]).draw().node();
                 $('td', nuevaFila).each(function(index,td){
                    $(td).attr('data-label',columnas[index]);
                });
           });
       }
    });
    $.ajax({
        'url' : base_url + 'obtener_productos',
        'type' : 'post',
        'success' : function(obj){
            var Tcont = "";
            $('#contenedor-productos').html('');
            $.each(obj['productos'],function(i,elemento){
                Tcont += 
                '<div class="col-lg-4" align="text">'+
                '<svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>' + 
                '<h2>'+elemento.nombre+'</h2>' + 
                '<p>'+elemento.categoria+'</p>' + 
                '<p>'+elemento.costo+'</p>' +
                '<button onclick="comprar_producto('+elemento.id_producto+')" class="btn btn-success"><p>Comprar &raquo;</a></p></button>' + 
                '</div>';
            });
            $('#contenedor-productos').html(Tcont);
        }
    });
    
    $('#form_tarjeta').on('submit',function(e){
        e.preventDefault();
        $.ajax({
           'url' : base_url + 'comprar',
           'type' : 'post',
           'data' : {id_producto : $('#id_producto').val()},
           'success' : function(obj){
               console.log(obj['resultado']);
               if(obj['resultado'] == true){
                   swal.fire({
                   icon : 'success',
                   title : 'Se ha realizado la compra',
                     }).then((result) => {
                        if(result.value){
                            location.reload();
                        }
                    })
               }else{
                   swal.fire({
                   icon : 'error',
                   title : 'No se ha pudo realizar la compra',
                     }).then((result) => {
                        if(result.value){
                            location.reload();
                        }
                    })
               }
              
           }
        });
        
    });
});

function comprar_producto(id_producto){
    $('#resumen_producto').html('');
    $('#resumen_costo').html('');
    $('#resument_total').html('');
    $.ajax({
       'url' : base_url + 'obtener_producto',
       'type' : 'post',
       'data' : {id_producto : id_producto},
       'success' : function(obj){
           $('#resumen_producto').append(obj['producto']['nombre']);
           $('#resumen_costo').append(obj['producto']['costo']);
           $('#resumen_total').append(obj['producto']['costo']);
           $('#id_producto').val(obj['producto']['id_producto']);
       }
    });
    $('#modal_pago').modal('show');
}