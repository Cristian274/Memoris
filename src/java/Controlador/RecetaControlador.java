/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.RecetaDAO;
import ModeloVO.RecetaVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "RecetaControlador", urlPatterns = {"/Receta"})
public class RecetaControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String Id_Rec = request.getParameter("IDR");
        String Fecha_Rec = request.getParameter("FechaR");
        String nommed_recmed = request.getParameter("MedicamentoR");
        String cantidad_h_recmed = request.getParameter("CantidadMR");
        String dosis_recmed = request.getParameter("DosisMR");
        String viaadmin_recmed = request.getParameter("ViaMR");
        String Id_enf = request.getParameter("IDER");
        String Id_Adult = request.getParameter("IDAMR");

        RecetaVO receVO = new RecetaVO(Id_Rec, nommed_recmed, viaadmin_recmed, dosis_recmed, Fecha_Rec, cantidad_h_recmed, Id_enf, Id_Adult);
        RecetaDAO receDAO = new RecetaDAO(receVO);

        switch (opcion) {
            case 1: // Agregar registro 
                if (receDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "La enfermedad se registró correctamente");
                } else {
                    request.setAttribute("mensajeError", "La enfermedad no pudo ser registrada");
                }
                request.getRequestDispatcher("creceta.jsp").forward(request, response);
                break;
            case 2: // actualizar registro
                if (receDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "La enfermedad se actualizó correctamente");

                } else {
                    request.setAttribute("mensajeError", "La enfermedad  no pudo ser actualizado");

                }
                request.getRequestDispatcher("rreceta.jsp").forward(request, response);
                break;
            case 3: // Consultar por identificacion
                RecetaVO enfvo = receDAO.consultariden(Id_Rec);
                if (enfvo != null) {

                    request.setAttribute("volleno", enfvo);
                    request.getRequestDispatcher("ureceta.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "La enfermad  NO existe");
                    request.getRequestDispatcher("creceta.jsp").forward(request, response);

                }
                break;

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
