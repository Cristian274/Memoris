/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import ModeloDAO.ReporteDAO;
import ModeloVO.ReporteVO;
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
@WebServlet(name = "ReporteControlador", urlPatterns = {"/Reporte"})
public class ReporteControlador extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        String Id_Reporte = request.getParameter("IDR");
        String Fecha_Reporte = request.getParameter("FechaR");
        String Observaciones = request.getParameter("ObservacionR");
        String Id_Adultomayor = request.getParameter("IDAMR");
        
        ReporteVO repVO = new ReporteVO(Id_Reporte, Fecha_Reporte, Observaciones, Id_Adultomayor);
        
        
        ReporteDAO RepDAO = new ReporteDAO(repVO);

        switch (opcion) {
            case 1: // Agregar registro 
                if (RepDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "El reporte  se envió correctamente");
                } else {
                    request.setAttribute("mensajeError", "El reporte no se pudo enviar");
                }
                request.getRequestDispatcher("creporte.jsp").forward(request, response);
                break;
           
            case 2: // Consultar por identificacion
               ReporteVO repvo = RepDAO.consultariden(Id_Reporte);
                if (repvo != null) {

                    request.setAttribute("volleno",repvo);
                    request.getRequestDispatcher("rreporte.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El reporte NO existe");
                    request.getRequestDispatcher("rreporte.jsp").forward(request, response);

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
