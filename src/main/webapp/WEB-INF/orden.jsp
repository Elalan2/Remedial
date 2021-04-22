<%-- 
    Document   : orden
    Created on : 15/04/2021, 12:29:31 PM
    Author     : Craft
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orden</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Elemento</th>
                    <th>Tamaño</th>
                    <th>Precio</th>                 
                    <th>Cantidad</th>
                    <!--<th>Sutotal</th>-->
                </tr>
            </thead>
 <tbody>
                <c:forEach var="dto" items="${dato}">
                    <tr>
                       
                        <td>${dto.elemento}</td>
                        <td>${dto.tamaño}</td>
                        <td>${dto.precio}</td>
                        <td><input type="number" id="cantidad" name="cantidad"></td>
                <input type="hidden" value="${dto.idMenu}" id="idMenu">
                    </tr>
               
                </c:forEach>
            </tbody>
        </table>   
                       
                        <input type="button" value="Agregar Elementos" id="agregar" onclick="agregarF()" >
                        
   
                        
                        
                        

    </body>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>    <script>
                var $agregar=document.getElementById('agregar')

   function agregarF(){
  
            $.ajax({
              type: "POST",
              url: "agregarSesion",
              data: {
                  idMenu:$("#idMenu").val(),
                  cantidad:$("#cantidad").val()
              },
              success: function(data){
                  console.log(data)
                 window.location.href="Menu"
              }

            });

                }
                
            </script>
</html>
