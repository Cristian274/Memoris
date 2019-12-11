<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <%
            HttpSession miSesion = (HttpSession) request.getSession();
            UsuarioVO usuVO = (UsuarioVO) miSesion.getAttribute("usuario");
            String usuario = "";
            usuario = miSesion.getAttribute("usuario").toString();
            if (usuario == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }


        %>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Recuperar contraseña</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <link rel="icon"  href="img/m2.ico"/>

    </head>

    <body class="bg-gradient-primary">

        <div class="container">


            <!-- Outer Row -->
            <div class="row justify-content-center">

                <div class="col-xl-5 col-lg-12 col-md-9">

                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <!-- Nested Row within Card Body -->
                            <form  name="form1" method="post" action="Resultado.jsp" >
                                <div class="row">


                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-2">¿Olvidó su contraseña?</h1>
                                            <p class="mb-4">Lo entendemos, estas cosas pasan. Digite su correo electronico</p>
                                        </div>
                                        <form class="user">
                                            <input type="email" class="form-control form-control-user" id="para" name="para" placeholder="Correo electronico">
                                            

                                            <div class="form-group">

                                                
                                                <input type="hidden" name="de" value="proyectoadherenciaSena@gmail.com">
                                                <input type="hidden" name="clave" value="123456sena">
                                                <input type="hidden" name="asunto" value="Recuperacion Contraseña">
                                                <input type="hidden" name="mensaje" value="Cordial saludo, segun la solicitud de recuperacion de contraseña, hemos podido obtener su contraseña, la cual es: <%=usuVO.getCont_Usu()%>, recuerde que esta se usa para iniciar sesion.">
                                            </div>
                                           

                                            <button class="btn btn-primary btn-user btn-block">
                                                <span>

                                                    ENVIAR CORREO

                                                </span>
                                            </button>
                                        </form>

                                        <hr>
                                        <div class="text-center">
                                            <a class="small" href="login.jsp">Ya tienes una cuenta? Inicia sesión!</a>


                                        </div>
                                    </div>
                                </div>
                        </div>

                    </div>

                </div>

            </div>

            <!-- Bootstrap core JavaScript-->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="js/sb-admin-2.min.js"></script>

    </body>

</html>

