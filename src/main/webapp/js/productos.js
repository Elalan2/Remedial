$(document).ready(function(){
    var intervalo = setInterval( function() {
	$('#loading').removeClass('loading');
    }, 2000 );
    
//    $('#dataTable').dataTable( {
//        paging: false,
//        searching: false
//    } );
//    
    var tablaProductos = $('#dataTable').DataTable({
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
		"ID producto",
		"Nombre",
		"Costo",
		"Categoría",
		"Acción"
	];
        
        
    $.ajax({
        'url' : base_url + 'obtener_productos',
        'type' : 'post',
        'success' : function(obj){
            $.each(obj['productos'], function(i,elemento){
                var nuevaFila = tablaProductos.row.add([
                    elemento.id_producto,
                    elemento.nombre,
                    elemento.costo,
                    elemento.categoria,
                    '<button type="button" class="btn btn-primary" onclick="editar_producto('+elemento.id_producto+')"><i class="fa fa-edit"></i></button>' +
                    '<button type="button" class="btn btn-danger" onclick="eliminar_producto('+elemento.id_producto+')"><i class="fa fa-trash"></i></button>'
                 ]).draw().node();
                 $('td', nuevaFila).each(function(index,td){
                    $(td).attr('data-label',columnas[index]);
                });
            });
        }
    });
    
    $('#form-agregar').on('submit',function(e){
        e.preventDefault();
        $.ajax({
            'url' : base_url + 'agregar_producto',
            'type' : 'post',
            'data' : {
                id_producto : $('#id_producto').val(),
                nombre_producto : $('#nombre_producto').val(),
                costo : $('#costo').val(),
                categoria : $('#categoria').val(),
            },
            'success' : function(obj){
                console.log(obj['resultado']);
                if(obj['resultado'] == true){
                    swal.fire({
                        icon : 'success',
                        title : 'Se ha agregado el producto',
                        showCancelButton: true,
                        confirmButtonText: 'Aceptar',
                        cancelButtonText: 'Cancelar',
                    }).then((result) => {
                        if(result.value){
                            location.reload();
                        }
                    })
                }
            }
        });
    });
    
    $('#form-modificar').on('submit',function(e){
        
        e.preventDefault();
        $.ajax({
            'url' : base_url + 'editar_producto',
            'type' : 'post',
            'data' : {
                id_producto_modificar : $('#id_producto_modificar').val(),
                nombre_producto_modificar : $('#nombre_producto_modificar').val(),
                costo_modificar : $('#costo_modificar').val(),
                categoria_modificar : $('#categoria_modificar').val(),
            },
            'success' : function(obj){
                console.log(obj['resultado']);
                if(obj['resultado'] == true){
                    swal.fire({
                        icon : 'success',
                        title : 'Se ha actualizado el producto',
                        showCancelButton: true,
                        confirmButtonText: 'Aceptar',
                        cancelButtonText: 'Cancelar',
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

function eliminar_producto(id_producto){
    Swal.fire({
        icon: 'warning',
        title: '¿Está seguro de eliminar el producto?',
        showCancelButton: true,
        confirmButtonText: 'Aceptar',
        cancelButtonText: 'Cancelar',
    }).then((result) => {
        if(result.value) {
            $.ajax({
                'url' : base_url + 'eliminar_producto',
                'type' : 'post',
                'data' : {
                    'id_producto' : id_producto
                },
                'success' : function(obj){
                    console.log(obj);
                    if(obj['resultado']){
                        Swal.fire({
                            icon: 'success',
                            title: '¡Se ha eliminado con exito!',
                        }).then((result) => {
                            location.reload();
                        });
                    }
                    else{
                        Swal.fire({
                            icon: 'error',
                            title: 'No se pudo eliminar.',
                        });
                    }
                }
            });
        }
    });
}

function editar_producto(id_producto){
    $.ajax({
        'url' : base_url + 'obtener_producto',
        'type' : 'post',
        'data' : {'id_producto' : id_producto},
        'success' : function(obj){
            $('#id_producto_modificar').val(obj['producto']['id_producto']);
            $('#nombre_producto_modificar').val(obj['producto']['nombre']);
            $('#costo_modificar').val(obj['producto']['costo']);
            $('#categoria_modificar').val(obj['producto']['categoria']);
        }
    });
    $("#modal-modificar").modal("show");
}