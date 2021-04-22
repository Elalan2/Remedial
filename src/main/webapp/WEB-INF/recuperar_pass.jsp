<%@page import="helper.AppHelper"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="<%= AppHelper.baseUrl() %>js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script>var base_url = "<%= AppHelper.baseUrl() %>"</script>
    
    <title>Ferrétaro - Recuperar</title>

    <!-- Custom fonts for this template-->
    <link href="<%= AppHelper.baseUrl() %>vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    
    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <link href="css/micss.css" rel="stylesheet">
    <style>
        #overlay {
            background: #ffffff;
            color: #666666;
            position: fixed;
            height: 100%;
            width: 100%;
            margin: 0;
            padding: 0;
            z-index: 5000;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            text-align: center;
            opacity: .80;
        }
        .overlay-out-box {
            width: 50%;
            height: 50%;
            overflow: auto;
            margin: auto;
            position: absolute;
            top: 0;
            left: 0;
            bottom: 0;
            right: 0;
        }
        .overlay-in-box {
            position: relative;
            top: 50%;
            -webkit-transform: translateY(-50%);
            -ms-transform: translateY(-50%);
            transform: translateY(-50%);
        }

        .spinner {
            margin: 0 auto;
            height: 64px;
            width: 64px;
            animation: rotate 0.8s infinite linear;
            border: 5px solid firebrick;
            border-right-color: transparent;
            border-radius: 50%;
        }
        @keyframes rotate {
            0% {
                transform: rotate(0deg);
            }
            100% {
                transform: rotate(360deg);
            }
        }
    </style>

</head>

<body class="bg-gradient-primary">
    <div id="overlay" style="display:none;">
        <div class="overlay-out-box">
            <div class="overlay-in-box">
                <div class="spinner"></div>
                <br/>
                Cargando...
            </div>
        </div>
    </div>

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Recuperación de contraseña</h1>
                                    </div>
                                    <form class="user" id="form-recuperar">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user"
                                                id="mail" aria-describedby="emailHelp"
                                                placeholder="Ingresa tu correo" name="mail">
                                        </div>
                                        <input class="btn btn-primary btn-user btn-block" type="submit" value="Recuperar contraseña"/>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="<%= AppHelper.baseUrl() %>login">Volver al login</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="<%= AppHelper.baseUrl() %>vendor/jquery/jquery.min.js"></script>
    <script src="<%= AppHelper.baseUrl() %>vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="<%= AppHelper.baseUrl() %>vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="<%= AppHelper.baseUrl() %>js/sb-admin-2.min.js"></script>
    
    <!-- Validaciones -->
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
    <script src="<%= AppHelper.baseUrl() %>js/recuperar_validacion.js"></script>
</body>

</html>