<%-- 
    Document   : listaOrden
    Created on : 19/04/2021, 08:04:09 PM
    Author     : Adry
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi orden</title>
    </head>
    <body>
        <h1>Su orden es:</h1>
        <table border="1">
            <thead>
                <tr>
                   
                    <th>Elemento</th>
                    <th>Cantidad</th>
                    <th>Tamaño</th>
                    <th>Precio</th>
                    
                </tr>
            </thead>

            <tbody>
                <c:forEach var="orden" items="$listSesion1">
                   
                    <tr>
                        <td>${orden.elemento}</td>
                        <td>${orden.cantidad}</td>
                        <td>${orden.tamaño}</td>
                        <td>${orden.precio}</td>
                     
                    </tr>
                     
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
