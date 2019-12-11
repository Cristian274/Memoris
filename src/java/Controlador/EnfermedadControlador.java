/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.EnfermedadDAO;
import ModeloVO.EnfermedadVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian Florez
 */
@WebServlet(name = "EnfermedadControlador", urlPatterns = {"/Enfermedad"})
public class EnfermedadControlador extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        String Id_Enf = request.getParameter("IDE");
        String Nomb_Enf = request.getParameter("NombreE");
        String Sint_Enf = request.getParameter("SintomaE");
        String Trat_Enf = request.getParameter("TratamientoE"); 
        EnfermedadVO enfVO = new EnfermedadVO(Id_Enf, Nomb_Enf, Sint_Enf, Trat_Enf);
        EnfermedadDAO enfDAO = new EnfermedadDAO(enfVO);

        switch (opcion) {
            case 1: // Agregar registro 
                if (enfDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "La enfermedad se registró correctamente");
                } else {
                    request.setAttribute("mensajeError", "La enfermedad no pudo ser registrada");
                }
                request.getRequestDispatcher("cenfermedad.jsp").forward(request, response);
                break;
            case 2: // actualizar registro
                if (enfDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "La enfermedad se actualizó correctamente");

                } else {
                    request.setAttribute("mensajeError", "La enfermedad  no pudo ser actualizado");

                }
                request.getRequestDispatcher("renfermedad.jsp").forward(request, response);
                break;
          /*  case 3: // Consultar por identificacion
               EnfermedadVO enfvo = enfDAO.consultariden(Id_Enf);
                if (enfvo != null) {

                    request.setAttribute("volleno",enfvo);
                    request.getRequestDispatcher("uenfermedad.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "La enfermad  NO existe");
                    request.getRequestDispatcher("cenfermedad.jsp").forward(request, response);

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
