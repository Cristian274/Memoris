  <%@page import="ModeloVO.UsuarioVO"%>
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
      if (usuario==null) {
              request.getRequestDispatcher("login.jsp").forward(request, response);
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
          Men�
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
            <span>Receta M�dica</span>
          </a>
          <div id="collapse8" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
              <h6 class="collapse-header">Gestiones:</h6>
              <a class="collapse-item" href="creceta.jsp">Crear</a>
              <a class="collapse-item" href="rreceta.jsp">Consultar</a>
            </div>
          </div>
        </li>

        <!--�Reporte-->


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
            <span>Receta M�dica</span>
          </a>
          <div id="collapse8" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
              <h6 class="collapse-header">Gestiones:</h6>
              
              <a class="collapse-item" href="rreceta.jsp">Consultar</a>
            </div>
          </div>
        </li>

        <!--�Reporte-->


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
            <span>Receta M�dica</span>
          </a>
          <div id="collapse8" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
              <h6 class="collapse-header">Gestiones:</h6>
              
              <a class="collapse-item" href="rreceta.jsp">Consultar</a>
            </div>
          </div>
        </li>

        <!--�Reporte-->


           <li class="nav-item">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse9" aria-expanded="true" aria-controls="collapse9">
            <i class="fas fa-file"></i>
            <span>Reporte</span>
          </a>
          <div id="collapse9" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
              <h6 class="collapse-header">Gestiones:</h6>
              <a class="collapse-item" href="pdf.jsp">Consultar</a>
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
                    Cerrar Sesi�n
                  </a>
                </div>
              </li>

            </ul>

          </nav>
          <!-- End of Topbar -->

          <!-- Begin Page Content -->

          
          <div class="container-fluid">
            <div class="row" style="margin-top:50px;">
            <div class="col-xl-3 col-md-6 mb-2">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 mb-0 font-weight-bold text-gray-800">Adulto mayor</div><hr>
                      <a  style="color: white;" href=""><div class="text-xs font-weight-bold text-primary text-uppercase mb-1">Crear</div></a>
                      <a style="color: white;" href=""><div class="text-xs font-weight-bold text-primary text-uppercase mb-1">Consultar</div></a>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-wheelchair fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-xl-3 col-md-6 mb-2">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 mb-0 font-weight-bold text-gray-800">Familiar</div><hr>
                      <a  style="color: white;" href=""><div class="text-xs font-weight-bold text-secondary text-uppercase mb-1">Crear</div></a>
                      <a style="color: white;" href=""><div class="text-xs font-weight-bold text-secondary text-uppercase mb-1">Consultar</div></a>
                    </div>
                      <div class="col-auto">
                      <i class="fas fa-male fa-2x text-gray-300"></i>
                      <i class="fas fa-female fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-md-6 mb-2">
              <div class="card border-left-three shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 mb-0 font-weight-bold text-gray-800">Cuidador</div><hr>
                      <a  style="color: white;" href=""><div class="text-xs font-weight-bold text-three text-uppercase mb-1">Crear</div></a>
                      <a style="color: white;" href=""><div class="text-xs font-weight-bold text-three text-uppercase mb-1">Consultar</div></a>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-user-md fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            </div>

            <div class="row" style="margin-top:50px;">
            <div class="col-xl-3 col-md-6 mb-2">
              <div class="card border-left-four shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 mb-0 font-weight-bold text-gray-800">Alarma</div><hr>
                      <a  style="color: white;" href=""><div class="text-xs font-weight-bold text-four text-uppercase mb-1">Crear</div></a>
                      <a style="color: white;" href=""><div class="text-xs font-weight-bold text-four text-uppercase mb-1">Consultar</div></a>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-clock fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-xl-3 col-md-6 mb-2">
              <div class="card border-left-five shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 mb-0 font-weight-bold text-gray-800">Enfermedad</div><hr>
                      <a  style="color: white;" href=""><div class="text-xs font-weight-bold text-five text-uppercase mb-1">Crear</div></a>
                      <a style="color: white;" href=""><div class="text-xs font-weight-bold text-five text-uppercase mb-1">Consultar</div></a>
                    </div>
                      <div class="col-auto">
                      <i class="fas fa-bug fa-2x text-gray-300"></i>
                      
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-md-6 mb-2">
              <div class="card border-left-six shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 mb-0 font-weight-bold text-gray-800">Medicamento</div><hr>
                      <a  style="color: white;" href=""><div class="text-xs font-weight-bold text-six text-uppercase mb-1">Crear</div></a>
                      <a style="color: white;" href=""><div class="text-xs font-weight-bold text-six text-uppercase mb-1">Consultar</div></a>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-medkit fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            </div>

            <div class="row" style="margin-top:50px;">
            <div class="col-xl-3 col-md-6 mb-2">
              <div class="card border-left-seven shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 mb-0 font-weight-bold text-gray-800">Receta m�dica</div><hr>
                      <a  style="color: white;" href=""><div class="text-xs font-weight-bold text-seven text-uppercase mb-1">Crear</div></a>
                      <a style="color: white;" href=""><div class="text-xs font-weight-bold text-seven text-uppercase mb-1">Consultar</div></a>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-clipboard fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-xl-3 col-md-6 mb-2">
              <div class="card border-left-eight shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 mb-0 font-weight-bold text-gray-800">Reporte</div><hr>
                      <a  style="color: white;" href=""><div class="text-xs font-weight-bold text-eight text-uppercase mb-1">Crear</div></a>
                      <a style="color: white;" href=""><div class="text-xs font-weight-bold text-eight text-uppercase mb-1">Consultar</div></a>
                    </div>
                      <div class="col-auto">
                      <i class="fas fa-file fa-2x text-gray-300"></i>
                      
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-md-6 mb-2">
              <div class="card border-left-nine shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 mb-0 font-weight-bold text-gray-800">Usuario</div><hr>
                      <a  style="color: white;" href=""><div class="text-xs font-weight-bold text-nine text-uppercase mb-1">Crear</div></a>
                      <a style="color: white;" href=""><div class="text-xs font-weight-bold text-nine text-uppercase mb-1">Consultar</div></a>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-address-card fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            </div>
            




            
      </div>
      <!-- End of Content Wrapper -->

    </div>
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
          <div class="modal-body">�Seguro que deseas salir?</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            <form method="post" action="Cerrar">
            <a class="btn btn-primary" href="login.jsp">Cerrar Sesi�n</a>
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
