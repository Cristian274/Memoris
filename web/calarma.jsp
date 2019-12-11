
<%@page import="ModeloDAO.AlarmaDAO"%>
<%@page import="ModeloVO.AlarmaVO"%>
<%@page import="java.util.Calendar"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page import="ModeloDAO.CuidadorDAO"%>
<%@page import="ModeloVO.CuidadorVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.MedicamentoDAO"%>
<%@page import="ModeloVO.MedicamentoVO"%>
<%@page import="java.util.Random"%>
<%@page import ="java.security.SecureRandom"%>


<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Memoris</title>
        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link rel="icon"  href="img/m2.ico"/>

        <%
            HttpSession miSesion = (HttpSession) request.getSession();
            UsuarioVO usuVO = (UsuarioVO) miSesion.getAttribute("usuario");
            String usuario = "";
            usuario = miSesion.getAttribute("usuario").toString();
            if (usuario == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else if (usuVO.getRol().equals("2") || usuVO.getRol().equals("3")) {
                request.getRequestDispatcher("menu.jsp").forward(request, response);
            }

        %>

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class=""></i>
                    </div>
                    <div class="sidebar-brand-text mx-3"><img src="img/logo2.svg "style="width: 105%; height: 105px;"></div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">



                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Menú
                </div>

                <!-- Nav Item - Pages Collapse Menu -->
                <%if (usuVO.getRol().equals("1")) {%>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-wheelchair"></i>
                        <span>Adulto Mayor</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>
                            <a class="collapse-item" href="cadulto.jsp">Crear</a>
                            <a class="collapse-item" href="radulto.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!--ALARMA-->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
                        <i class="fas fa-clock"></i>
                        <span>Alarma</span>
                    </a>
                    <div id="collapseThree" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>
                            <a class="collapse-item" href="calarma.jsp">Crear</a>
                            <a class="collapse-item" href="ralarma.jsp">Consultar</a>
                        </div>
                    </div>
                </li>
                <!--Cuidador-->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" aria-controls="collapseFour">
                        <i class="fas fa-user-md"></i>
                        <span>Cuidador</span>
                    </a>
                    <div id="collapseFour" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>
                            <a class="collapse-item" href="ccuidador.jsp">Crear</a>
                            <a class="collapse-item" href="rcuidador.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!-- Enfermedad -->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseFive" aria-expanded="true" aria-controls="collapseFive">
                        <i class="fas fa-bug"></i>
                        <span>Enfermedad</span>
                    </a>
                    <div id="collapseFive" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>
                            <a class="collapse-item" href="cenfermedad.jsp">Crear</a>
                            <a class="collapse-item" href="renfermedad.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!--Medicamento-->


                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsesix" aria-expanded="true" aria-controls="collapsesix">
                        <i class="fas fa-medkit"></i>
                        <span>Medicamento</span>
                    </a>
                    <div id="collapsesix" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>
                            <a class="collapse-item" href="cmedicamento.jsp">Crear</a>
                            <a class="collapse-item" href="rmedicamento.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!--Familiar-->


                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseSeven" aria-expanded="true" aria-controls="collapseSeven">
                        <i class="fas fa-female"></i>
                        <i class="fas fa-male"></i>
                        <span>Familiar</span>
                    </a>
                    <div id="collapseSeven" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>
                            <a class="collapse-item" href="cfamiliar.jsp">Crear</a>
                            <a class="collapse-item" href="rfamiliar.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!--RECETA-->



                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse8" aria-expanded="true" aria-controls="collapse8">
                        <i class="fas fa-clipboard"></i>
                        <span>Receta Médica</span>
                    </a>
                    <div id="collapse8" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>
                            <a class="collapse-item" href="creceta.jsp">Crear</a>
                            <a class="collapse-item" href="rreceta.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!--´Reporte-->


                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse9" aria-expanded="true" aria-controls="collapse9">
                        <i class="fas fa-file"></i>
                        <span>Reporte</span>
                    </a>
                    <div id="collapse9" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>
                            <a class="collapse-item" href="creporte.jsp">Crear</a>
                            <a class="collapse-item" href="rreporte.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!--usuario-->


                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse10" aria-expanded="true" aria-controls="collapse10">
                        <i class="fas fa-address-card"></i>
                        <span>Usuario</span>
                    </a>
                    <div id="collapse10" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>
                            <a class="collapse-item" href="cusuario.jsp">Crear</a>
                            <a class="collapse-item" href="rusuario.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <%}%>
                <%if (usuVO.getRol().equals("2")) {%>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-wheelchair"></i>
                        <span>Adulto Mayor</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>

                            <a class="collapse-item" href="radulto.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!--ALARMA-->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
                        <i class="fas fa-clock"></i>
                        <span>Alarma</span>
                    </a>
                    <div id="collapseThree" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>
                            <a class="collapse-item" href="calarma.jsp">Crear</a>
                            <a class="collapse-item" href="ralarma.jsp">Consultar</a>
                        </div>
                    </div>
                </li>
                <!--Cuidador-->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseFour" aria-expanded="true" aria-controls="collapseFour">
                        <i class="fas fa-user-md"></i>
                        <span>Cuidador</span>
                    </a>
                    <div id="collapseFour" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>

                            <a class="collapse-item" href="rcuidador.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!-- Enfermedad -->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseFive" aria-expanded="true" aria-controls="collapseFive">
                        <i class="fas fa-bug"></i>
                        <span>Enfermedad</span>
                    </a>
                    <div id="collapseFive" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>

                            <a class="collapse-item" href="renfermedad.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!--Medicamento-->


                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsesix" aria-expanded="true" aria-controls="collapsesix">
                        <i class="fas fa-medkit"></i>
                        <span>Medicamento</span>
                    </a>
                    <div id="collapsesix" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>

                            <a class="collapse-item" href="rmedicamento.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!--Familiar-->


                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseSeven" aria-expanded="true" aria-controls="collapseSeven">
                        <i class="fas fa-female"></i>
                        <i class="fas fa-male"></i>
                        <span>Familiar</span>
                    </a>
                    <div id="collapseSeven" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>

                            <a class="collapse-item" href="rfamiliar.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!--RECETA-->



                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse8" aria-expanded="true" aria-controls="collapse8">
                        <i class="fas fa-clipboard"></i>
                        <span>Receta Médica</span>
                    </a>
                    <div id="collapse8" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>

                            <a class="collapse-item" href="rreceta.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!--´Reporte-->


                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse9" aria-expanded="true" aria-controls="collapse9">
                        <i class="fas fa-file"></i>
                        <span>Reporte</span>
                    </a>
                    <div id="collapse9" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>
                            <a class="collapse-item" href="creporte.jsp">Crear</a>
                            <a class="collapse-item" href="rreporte.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!--usuario-->




                <%}%>
                <%if (usuVO.getRol().equals("3")) {%>


                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-wheelchair"></i>
                        <span>Adulto Mayor</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>
                            <a class="collapse-item" href="cadulto.jsp">Crear</a>
                            <a class="collapse-item" href="radulto.jsp">Consultar</a>
                        </div>
                    </div>
                </li>




                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse8" aria-expanded="true" aria-controls="collapse8">
                        <i class="fas fa-clipboard"></i>
                        <span>Receta Médica</span>
                    </a>
                    <div id="collapse8" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>

                            <a class="collapse-item" href="rreceta.jsp">Consultar</a>
                        </div>
                    </div>
                </li>

                <!--´Reporte-->


                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse9" aria-expanded="true" aria-controls="collapse9">
                        <i class="fas fa-file"></i>
                        <span>Reporte</span>
                    </a>
                    <div id="collapse9" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones:</h6>
                            <a class="collapse-item" href="creporte.jsp">Crear</a>
                            <a class="collapse-item" href="rreporte.jsp">Consultar</a>
                        </div>
                    </div>
                </li>
                <%}%>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Search -->


                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>

                            <!-- Nav Item - Alerts -->


                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=usuVO.getNombrecomple()%> </span>
                                    <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">

                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Cerrar Sesión
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <div class="card shadow mb-4">
                            <div class="card-header py-3">

                                <h6 class="m-0 font-weight-bold text-primary">Crear Alarma</h6>
                            </div>
                            <div class="card-body">



                                <form name="form1" method="post" action="Alarma">






                                    <%int num = (int) (Math.random() * 9999 + 1111);%>
                                    <input  type="hidden" name="IDA" value="<%=num%>">

                                    <div class="form-group row">

                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="IDM">Id medicamento</label>
                                            <select required class="form-control form-control-user" name="IDM" required>
                                                <option value="">seleccione.....</option>
                                                <% MedicamentoVO medVO = new MedicamentoVO();
                                                    MedicamentoDAO medDAO = new MedicamentoDAO();
                                                    ArrayList<MedicamentoVO> listarMedicamento = medDAO.listarmedicamento();
                                                    for (int j = 0; j < listarMedicamento.size(); j++) {

                                                        medVO = listarMedicamento.get(j);%>
                                                <option value="<%= medVO.getId_Med()%>"><%= medVO.getId_Med() + "-" + medVO.getNomb_Med()%></option>
                                                <% }
                                                %>


                                            </select>
                                        </div>
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="ObservacionR"><%=usuVO.getNom_usu()%></label>
                                            <select required class="form-control form-control-user" name="IDC" required>
                                                <option value="">seleccione.....</option>
                                                <% CuidadorVO cuiVO = new CuidadorVO();
                                                    CuidadorDAO cuiDAO = new CuidadorDAO();
                                                    ArrayList<CuidadorVO> listarid = cuiDAO.listarCuidador();
                                                    for (int k = 0; k < listarid.size(); k++) {

                                                        cuiVO = listarid.get(k);%>
                                                <option value="<%= cuiVO.getId_Cuid()%>"><%= cuiVO.getId_Cuid() + "-" + cuiVO.getNomb_Cuid() + " " + cuiVO.getApel_Cuid()%></option>
                                                <% }
                                                %>


                                            </select>
                                        </div>
                                    </div>


                                    <div class="form-group row">

                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="ViaM">Via</label>
                                            <select class="form-control form-control-user"name="ViaM" required>
                                                <option value="">Seleccione...</option>
                                                <option value="Oral">Oral</option>
                                                <option value="Inyección">Inyección</option>

                                            </select>
                                        </div> 
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="IDAMR">Cantidad </label>
                                            <input type="text" class="form-control form-control-user" name="CantidadM" placeholder="Cantidad" pattern="[0-9]{1,4}" required title="Solo se acepta números, cantidad min/max de carácteres:1/4:">
                                        </div>
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="DosisM">Dosis</label>
                                            <select class="form-control form-control-user" name="DosisM" required>
                                                <option value="">Seleccione...</option>
                                                <option value="mg">mg</option>
                                                <option value="g">g</option>
                                                <option value="ml">ml</option>

                                            </select>
                                        </div> 
                                    </div>

                                    <%    Calendar c1 = Calendar.getInstance();

                                        String dia = Integer.toString(c1.get(Calendar.DATE));
                                        String mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
                                        String año = Integer.toString(c1.get(Calendar.YEAR));
                                    %>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="FechaIA">Fecha inicio </label>
                                            <input type="date" class="form-control form-control-user" value="<%=año + "-" + mes + "-" + dia%> "name="FechaIA" required>
                                        </div>
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="FechaFA">Fecha final</label>
                                            <input type="date" class="form-control form-control-user" name="FechaFA" required>
                                        </div> 
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="FrecuenciaA">Frecuencia</label>
                                            <select class="form-control form-control-user" name="FrecuenciaA" required>
                                                <option value="">Seleccione...</option>
                                                <option value="1">Cada 1 Hora</option>
                                                <option value="2">Cada 2 Horas</option>
                                                <option value="3">Cada 3 Horas</option>
                                                <option value="4">Cada 4 Hora</option>
                                                <option value="5">Cada 5 Horas</option>
                                                <option value="6">Cada 6 Horas</option>
                                                <option value="7">Cada 7 Hora</option>
                                                <option value="8">Cada 8 Horas</option>
                                                <option value="9">Cada 9 Horas</option>
                                                <option value="10">Cada 10 Hora</option>
                                                <option value="11">Cada 11 Horas</option>
                                                <option value="12">Cada 12 Horas</option>
                                                <option value="13">Cada 13 Hora</option>
                                                <option value="14">Cada 14 Horas</option>
                                                <option value="15">Cada 15 Horas</option>
                                                <option value="16">Cada 16 Hora</option>
                                                <option value="17">Cada 17 Horas</option>
                                                <option value="18">Cada 18 Horas</option>
                                                <option value="19">Cada 19 Hora</option>
                                                <option value="20">Cada 20 Horas</option>
                                                <option value="21">Cada 21 Horas</option>
                                                <option value="22">Cada 22 Hora</option>
                                                <option value="23">Cada 23 Horas</option>
                                                <option value="24">Cada 24 Horas</option>

                                            </select>
                                        </div>
                                    </div>

                                    <button class="btn btn-primary"> Añadir</button>

                                    <input type="hidden" value="<%=usuVO.getNom_usu()%>" name="para">
                                    <input type="hidden" value="proyectoadherenciaSena@gmail.com" name="de">
                                    <input type="hidden" value="123456sena" name="clave">
                                    <input type="hidden" value="Cordial saludo aprendiz, aqui se envia el recordatorio para que tenga en cuenta la fecha de la toma del medicamento acabado de registrar" name="mensaje">
                                    <input type="hidden" value="MEMORIS Recordatorio" name="asunto">
                                    <input type="Hidden" value="1" name="opcion">

                                    </div>


                                    </div>
                                    <label class="alert-primary">
                                        <% if (request.getAttribute("mensajeExito") != null) {%>   
                                        <div class="alert alert-success">
                                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                            <strong>¡Éxito!</strong> La alarma ha sido añadida en el sistema
                                        </div>
                                        <%}%>  
                                    </label><br>
                                    <label class="alert-danger">
                                        <% if (request.getAttribute("mensajeError") != null) {%>   
                                        <div class="alert alert-danger">
                                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                            <strong>¡Error!</strong> No se ha podido añadir la alarma
                                        </div>    
                                        <%}%>  
                                    </label>



                            </div>
                            <!-- End of Content Wrapper -->

                        </div>
                        </form>
                        <!-- End of Page Wrapper -->

                        <!-- Scroll to Top Button-->
                        <a class="scroll-to-top rounded" href="#page-top">
                            <i class="fas fa-angle-up"></i>
                        </a>

                        <!-- Logout Modal-->

                        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel"></h5>
                                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">X</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">¿Seguro que deseas salir?</div>
                                    <div class="modal-footer">
                                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                                        <form method="post" action="Cerrar">
                                            <a class="btn btn-primary" href="login.jsp">Cerrar Sesión</a>
                                        </form>
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

                        <!-- Page level plugins -->
                        <script src="vendor/datatables/jquery.dataTables.min.js"></script>
                        <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

                        <!-- Page level custom scripts -->
                        <script src="js/demo/datatables-demo.js"></script>

                        </body>

                        </html>











