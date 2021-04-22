<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="helper.AppHelper"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Registro de usuario</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="<%= AppHelper.baseUrl() %>assets/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%= AppHelper.baseUrl() %>assets/dist/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="<%= AppHelper.baseUrl() %>assets/dist/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%= AppHelper.baseUrl() %>assets/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="<%= AppHelper.baseUrl() %>plugins/iCheck/square/blue.css">

  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

</head>
<body class="hold-transition login-page">
<div class="login-box">
 
  <div class="login-logo">
    <a href="#"><b>Registro de usuario Holiday At </b>UTEQ</a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">Iniciar Sesión</p>

    <form class="user" id="formularioRegistro" action="<%= AppHelper.baseUrl() %>registroC" method="POST">
      
      <div class="form-group has-feedback">
          <input type="mail" name="txtCorreo" class="mail" id="txtCorreo" placeholder="Correo">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
        
      <div class="form-group has-feedback">
          <input type="text" name="txtUsu" class="txt" id="txtUsu" placeholder="Nombre de usuario">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
        
      <div class="form-group has-feedback">
          <input type="text" name="txtNombre" class="txt" id="txtNombre" placeholder="Nombre">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      
      <div class="form-group has-feedback">
          <input type="text" name="txtApellido" class="txt" id="txtApellido" placeholder="Apellidos">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
        
      <div class="form-group has-feedback">
          <input type="number" name="numberEdad"  class="number" id="numberEdad" placeholder="Edad">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
        
      <div class="form-group has-feedback">
          <input type="tel" name="telTelefono" class="tel" id="telTelefono" placeholder="Telefono">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
        
      <div class="form-group has-feedback">
          <input type="text" name="txtRFC" class="txt" id="txtRFC" placeholder="RFC">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
        
      <div class="form-group has-feedback">
          <input type="text" name="txtEstado" class="txt" id="txtEstado" placeholder="Estado">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
        
      <div class="form-group has-feedback">
          <input type="text" name="txtPais" class="txt" id="txtPais" placeholder="Pais">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
        
      <div class="form-group has-feedback">
          <input type="number" name="numberTarjetaC"  class="number" id="numberTarjetaC" placeholder="Tarjeta de credito">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
        
        <div class="form-group has-feedback">
          <select name="tipoTarjeta">
   <option value="#">Master Card</option> 
   <option value="#">Visa</option> 
   <option value="#">American express</option>
          </select>
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
        
      <div class="form-group has-feedback">
          <input type="password" name="txtPass" id="txtPass" value="" class="form-control" placeholder="Contraseña" onkeyup="coincidirContras()">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
        
      <div class="form-group has-feedback">
          <input type="password" name="txtRepetirPass" id="txtRepetirPass"  class="form-control" placeholder="Repetir contraseña" onkeyup="coincidirContras()">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
        
        
      <label class="fa fa-info" id="avisoContraseña"></label>
    
      <div class="social-auth-links text-center">
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-info"></i> Mensaje: 
        ${msje}</a>
    </div>
      <div class="row">
        
        <!-- /.col -->
        <div class="col-xs-4">
          <input type="submit" name="verificar" value="Verificar" class="btn btn-primary btn-block"/>
        </div>
        <!-- /.col -->
      </div>
    </form>

    
    <!-- /.social-auth-links -->

    <a href="<%= AppHelper.baseUrl() %>login">Login</a><br>

  </div>
 </form>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="<%= AppHelper.baseUrl() %>assets/dist/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<%= AppHelper.baseUrl() %>assets/dist/js/bootstrap.min.js">
<script src="<%= AppHelper.baseUrl() %>assets/dist/js/bootstrap.bundle.min.js"></script>
<!-- iCheck -->
<script src="<%= AppHelper.baseUrl() %>assets/dist/js/FuncionesRegistro.js" type="text/javascript"></script>
<script src="<%= AppHelper.baseUrl() %>plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' /* optional */
    });
  });
</script>
</body>
</html>