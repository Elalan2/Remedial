<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="helper.AppHelper"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Iniciar Sesión</title>
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
  <%
      response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
      response.setHeader("Pragma", "no-cache");
      response.setDateHeader("Expires", 0);
  %>
</head>
<body class="hold-transition login-page">
<div class="login-box">
 
  <div class="login-logo">
    <a href="#"><b>Login Holiday At </b>UTEQ</a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">Iniciar Sesión</p>

    <form class="user" id="form-login" action="<%= AppHelper.baseUrl() %>login" name="form1" method="POST">
      <div class="form-group has-feedback">
          <input type="text" name="txtUsu" id="txtUsu" value="" class="form-control"  placeholder="Nombre usuario">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
          <input type="password" name="txtPass" id="txtPass" value="" class="form-control" placeholder="******">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> Recuérdame
            </label>
          </div>
        </div>
          
        <!-- /.col -->
        <div class="col-xs-4">
          <input class="btn btn-outline-primary btn-block" type="button" value="Iniciar sesión" id="btniniciar"/>
        </div>
        <!-- /.col -->
      </div>
    </form>
      
      <div class="social-auth-links text-center">
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-info"></i> Mensaje: 
        ${msje}</a>
    </div>
    
    <!-- /.social-auth-links -->

    <a href="<%= AppHelper.baseUrl() %>recuperar">Olvide mi contraseña</a><br>
    <a href="<%= AppHelper.baseUrl() %>registroC" class="text-center">Registrar un nuevo usuario</a>

  </div>
 </form>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<script src="<%= AppHelper.baseUrl() %>assets/dist/js/validacion_login.js" type="text/javascript"></script>

<!-- jQuery 3 -->
<script src="<%= AppHelper.baseUrl() %>assets/dist/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<%= AppHelper.baseUrl() %>assets/dist/js/bootstrap.min.js">
<script src="<%= AppHelper.baseUrl() %>assets/dist/js/bootstrap.bundle.min.js"></script>
<!-- iCheck -->
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

