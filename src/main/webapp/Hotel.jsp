<%-- 
    Document   : Hotel
    Created on : 21/04/2021, 08:58:49 PM
    Author     : alann
--%>

<%@page import="helper.AppHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <title>HolidayUteq</title>
    <script src="https://kit.fontawesome.com/41bcea2ae3.js" crossorigin="anonymous"></script>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/carousel/">
    <!-- Bootstrap core CSS -->
<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/dist/css/buscador.css" rel="stylesheet">



    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      .imgRedonda {
    width:200px;
    height:200px;
    border-radius:150px;
}
      
    </style>
 
   
    <link href="recursos/carousel.css" rel="stylesheet">
  </head>
  <body>
    
<header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand">HolidayUteq</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="">Hoteles<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="">Reservaciones</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="">Ofertas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="">Restaurante</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="">¿Quienes somos?</a>
        </li>
     </ul>   
    </div>
     <div>
        <div>
            <ul class="navbar-nav mr-auto"> 
                 <li class="nav-item"><a href="<%= AppHelper.baseUrl() %>login"> <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Iniciar sesión</button></a></li>
            </ul>
         </div>
     </div>
  </nav>           
</header>
<main role="main">
      


   <!-- FOOTER -->
  <footer>
    <p class="float-right"><a href="index.html">Ir al inicio</a></p>
    <p align="center">2021 &copy; HolidayUteq, Inc. Todos los derechos reservados. </p>
  </footer>
</main>
    <script src="assets/dist/js/buscadorscript.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="assets/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
