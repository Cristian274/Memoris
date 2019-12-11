package Controlador;

import ModeloDAO.UsuarioDAO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String Id_usu = request.getParameter("IDU");
        String Nom_usu = request.getParameter("nombre");
        String Cont_usu = request.getParameter("contra");
        String roles = request.getParameter("roles");
        String nombre_completo=request.getParameter("nocomple");
       

        UsuarioVO usuVO = new UsuarioVO(Id_usu, Nom_usu, Cont_usu, roles,nombre_completo);
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);

        switch (opcion) {
            case 1: // Agregar registro 
                if (usuDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "El usuario se registró correctamente");
                } else {
                    request.setAttribute("mensajeError", "El usuario no pudo ser registrado");
                }
                request.getRequestDispatcher("cusuario.jsp").forward(request, response);
                break;
                
            case 2: // actuualizar registro
                if (usuDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El usuario se actualizó correctamente");

                } else {
                    request.setAttribute("mensajeError", "El usuario no pudo ser actualizado");

                }
                request.getRequestDispatcher("rusuario.jsp").forward(request, response);
                break;
                
                case 3: // consulta
             
                 if (usuDAO.ConsulNo(Nom_usu)) {

                    ArrayList<UsuarioVO> lista = usuDAO.Sesion(Nom_usu);
                    if (lista == null) {
                        request.setAttribute("mensajeError", "<script>alert('Usuariono existe')</script>");
                        HttpSession miSesion = request.getSession(false);
                    } else {
                        UsuarioVO usuVO2 = lista.get(0);
                        
                        if (usuVO2.getRol()!=null) {
                            HttpSession miSesion = request.getSession();
                            miSesion.setAttribute("usuario", usuVO2);
                            
                            request.getRequestDispatcher("contraseña.jsp").forward(request, response);                           
                        }
                    }
                
                } else {
                    request.setAttribute("mensajeError", "<script>alert('Usuario no existe')</script>");
                }
                
                request.getRequestDispatcher("contraseña1.jsp").forward(request, response);
                break;
                
                case 4: // login
                 if (usuDAO.validarLogin(Nom_usu, Cont_usu)) {

                    ArrayList<UsuarioVO> lista = usuDAO.IniciarSesion(Nom_usu, Cont_usu);
                    if (lista == null) {
                        request.setAttribute("mensajeError", "<script>alert('Usuario y/o Contraseña incorrectos')</script>");
                        HttpSession miSesion = request.getSession(false);
                    } else {
                        UsuarioVO usuVO2 = lista.get(0);
                        
                        if (usuVO2.getRol()!=null) {
                            HttpSession miSesion = request.getSession();
                            miSesion.setAttribute("usuario", usuVO2);
                            
                            request.getRequestDispatcher("menu.jsp").forward(request, response);                           
                        }
                    }
                
                } else {
                    request.setAttribute("mensajeError", "<script>alert('Usuario y/o Contraseña incorrectos')</script>");
                }
                
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
           /*     case 5: // consulta
                UsuarioVO usvo = usuDAO.consultarlog(Nom_usu);

                if (usvo != null) {
                    request.setAttribute("volleno", usvo);
                    request.getRequestDispatcher("contraseña.jsp").forward(request, response);

                } else {
                    request.setAttribute("mensajeError", "El usuario NO existe:¡ "+Id_usu+"!");
                    request.getRequestDispatcher("contraseña1.jsp").forward(request, response);

                }
                break;*/

      
           
        
           

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

