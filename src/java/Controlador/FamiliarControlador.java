/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.FamiliarDAO;
import ModeloVO.FamiliarVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FamiliarControlador", urlPatterns = {"/Familiar"})
public class FamiliarControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String Id_Usu = request.getParameter("IDU");
        String Id_Fam = request.getParameter("IDF");
        String Nomb_Fam = request.getParameter("NombreF");
        String Apel_Fam = request.getParameter("ApellidoF");
        String Paren_Fam = request.getParameter("ParentescoF");
        String Email_Fam = request.getParameter("CorreoF");
        String Foto_Fam = request.getParameter("FotoF");
        String Id_Adult = request.getParameter("AdultoF");

        FamiliarVO famVO = new FamiliarVO(Id_Fam, Nomb_Fam, Apel_Fam, Paren_Fam, Email_Fam , Foto_Fam, Id_Adult, Id_Usu);
        FamiliarDAO famDAO = new FamiliarDAO(famVO);

        switch (opcion) {
            case 1: // Agregar registro 
                if (famDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "El familiar se registró correctamente");
                } else {
                    request.setAttribute("mensajeError", "El familiar no pudo ser registrado");
                }
                request.getRequestDispatcher("cfamiliar.jsp").forward(request, response);
                break;
            case 2: // actualizar registro
                if (famDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El familiar se actualizó correctamente");

                } else {
                    request.setAttribute("mensajeError", "El familiar no pudo ser actualizado");

                }
                request.getRequestDispatcher("rfamiliar.jsp").forward(request, response);
                break;
           /* case 3: // Consultar por identificacion
                FamiliarVO famvo = FamiliarDAO.consultariden(Id_Fam);
                if (famvo != null) {

                    request.setAttribute("volleno", famvo);
                    request.getRequestDispatcher("ufamiliar.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El familiar NO existe");
                    request.getRequestDispatcher("rfamiliar.jsp").forward(request, response);

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
