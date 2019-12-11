/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.MedicamentoDAO;
import ModeloVO.MedicamentoVO;
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
@WebServlet(name = "MedicamentoControlador", urlPatterns = {"/Medicamento"})
public class MedicamentoControlador extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        String Id_Med = request.getParameter("IDM");
        String  Nomb_Med = request.getParameter("NombreM");
        String  Cant_Med = request.getParameter("CantidadM");
        String   Composi_Med = request.getParameter("CompoM");
        String   Contraindi_Med = request.getParameter("ContraM");
        String   Dosis_Med = request.getParameter("DosisM");
        String   Fecha_Venci_Med = request.getParameter("FechaM");
        String   Nom_Lab_Med = request.getParameter("NombreLM");
        String   Via_Med = request.getParameter("ViaM");
        
        MedicamentoVO medVO = new MedicamentoVO(Id_Med, Nomb_Med, Fecha_Venci_Med, Composi_Med,Via_Med,Cant_Med,Dosis_Med,Nom_Lab_Med,Contraindi_Med);
        MedicamentoDAO medDAO = new MedicamentoDAO(medVO);

        switch (opcion) {
            case 1: // Agregar registro 
                if (medDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "La enfermedad se registró correctamente");
                } else {
                    request.setAttribute("mensajeError", "La enfermedad no pudo ser registrada");
                }
                request.getRequestDispatcher("cmedicamento.jsp").forward(request, response);
                break;
            case 2: // actualizar registro
                if (medDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "La enfermedad se actualizó correctamente");

                } else {
                    request.setAttribute("mensajeError", "La enfermedad  no pudo ser actualizado");

                }
                request.getRequestDispatcher("rmedicamento.jsp").forward(request, response);
                break;
          /*  case 3: // Consultar por identificacion
               MedicamentoVO enfvo =medDAO.consultariden(Id_Med);
                if (enfvo != null) {

                    request.setAttribute("volleno",enfvo);
                    request.getRequestDispatcher("umedicamento.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El medicamento NO existe");
                    request.getRequestDispatcher("cmedicamento.jsp").forward(request, response);

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
