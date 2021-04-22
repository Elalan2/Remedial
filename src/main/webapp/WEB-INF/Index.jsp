<%-- 
    Document   : Index
    Created on : 16/04/2021, 07:36:25 PM
    Author     : alann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
        <nav class="menu" id="menu">
            <ul>
                <li><a href="#" onclick="cargarLogin()">Iniciar Sesión</a></li>
                <li><a href="#" onclick="cargarRegistro()">Registrar usuario</a></li>
            </ul>
        </nav>
        
        <section class="contenidoDinamico" id="contenidoDinamico">
            
            
        </section>
    </body>
    <script src="assets/dist/js/funcionesIndex.js" type="text/javascript"></script>
<script src="assets/dist/js/FuncionesRegistro.js" type="text/javascript"></script>
<script src="assets/dist/js/validacion_login.js" type="text/javascript"></script>
</html>
