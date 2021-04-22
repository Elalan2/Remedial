<%-- 
    Document   : servicioRestaurante
    Created on : 10/04/2021, 12:56:06 AM
    Author     : Adry
--%>

<%@page import="dtos.DtoMenuVO"%>
<%@page import="dtos.DtoListaListas"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%   HttpSession sesion= request.getSession();
 %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicio Restaurante</title>

    </head>
    <body>
        <h1>Bienvenido</h1>
        <h2 allig="center">Menú</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Elemento</th>
                    <th>Tamaño</th>
                    <th>Precio</th>
                    <th>Pedir</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="dto" items="${datos}">
                    <tr>
                        <td>${dto.idMenu}</td>
                        <td>${dto.elemento}</td>
                        <td>${dto.tamaño}</td>
                        <td>${dto.precio}</td>
                        <td><input type="button" value="Ordenar" onclick="location.href='orden?idMenu=${dto.idMenu}'"/></td>
                        
                    </tr>
               
                </c:forEach>
            </tbody>
        </table>
        <br>
        
        <br>
        
        
        
        <c:if test="${listas ne null }" >
 
            
              <h2 allig="center">ORDEN</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Elemento</th>
                    <th>Tamaño</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="dto" items="${listas}">
                    <tr>
                        <td>${dto.idMenu}</td>
                        <td>${dto.elemento}</td>
                        <td>${dto.tamaño}</td>
                        <td>${dto.precio}</td>
                        <td>${dto.cantidad}</td>
                        
                    </tr>
               
                </c:forEach>
            </tbody>
        </table>
            
              <br>
        <input type="button" value="Terminar" onclick="guardar()">
        <br>
         
          
        
        </c:if>
        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>    

        <script>
          
                
                function guardar(){
                    
            $.ajax({
              type: "POST",
              url: "guardardatos",
              data: {
                  
              },
              success: function(data){
                  alert('Elementos guardados con exito');
                  window.location.reload();
              }

            });
                }
                
                
                
                
                
                
            </script>
    </body>
</html>
