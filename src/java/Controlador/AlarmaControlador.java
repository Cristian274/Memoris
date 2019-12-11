package Controlador;

import ModeloDAO.AlarmaDAO;
import ModeloVO.AlarmaVO;
import Controlador.Email;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* @author Dayanna */
@WebServlet(name = "AlarmaControlador", urlPatterns = {"/Alarma"})
public class AlarmaControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        String Id_Alarm = request.getParameter("IDA");
        String Via_Adminis_Alarm = request.getParameter("ViaM");
        String Dosis_Medica_Alarm = request.getParameter("DosisM");
        String Cantidad_Alarm = request.getParameter("CantidadM");
        String Fecha_Inicio_Alarm = request.getParameter("FechaIA");
        String Fecha_Final_Alarm = request.getParameter("FechaFA");
        String Id_Cuidador = request.getParameter("IDC");
        String Frecuencia_Medica_Alarm = request.getParameter("FrecuenciaA");
        String Id_Medicamento = request.getParameter("IDM");
        
        Email email = new Email();

        String de = request.getParameter("de"); //Correo software
        String clave = request.getParameter("clave"); //Clave Correo software
        String para = request.getParameter("para"); //Correo
        String mensaje = request.getParameter("mensaje"); //Mensaje Body
        String asunto = request.getParameter("asunto"); // Asunto

        boolean resultado = email.enviarCorreo(de, clave, para, mensaje, asunto);
        
        AlarmaVO alaVO = new AlarmaVO (Id_Alarm,Via_Adminis_Alarm,Cantidad_Alarm, Dosis_Medica_Alarm, Frecuencia_Medica_Alarm, Fecha_Inicio_Alarm, Fecha_Final_Alarm, Id_Cuidador, Id_Medicamento);
        AlarmaDAO alaDAO = new AlarmaDAO (alaVO);
        
        
        switch(opcion)
        {
            case 1: // agregar 
                if (alaDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito","La alarma se registró con éxito");
                }
                else
                {
                    request.setAttribute("mesajeError", "La alarma no se registró correctamente");
                }
                request.getRequestDispatcher("calarma.jsp").forward(request, response);
            break;
            
            case 2: // modificar 
                 if (alaDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito","La alarma se registró con éxito");
                     request.getRequestDispatcher("ralarma.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("mesajeError", "La alarma no se registró correctamente");
                }
                request.getRequestDispatcher("ralarma.jsp").forward(request, response);
            break;
            
       /*     case 3: // consulta 
                AlarmaVO alarmavo = alaDAO.consultarId(Id_Alarm);
                
                if (alarmavo !=  null) {
                    
                    request.setAttribute("volleno", alarmavo);
                    request.getRequestDispatcher("ualarma.jsp").forward(request, response);
                
                }
                else {
                  request.setAttribute("mensajeError", "La alarma NO existe");
                    request.getRequestDispatcher("ralarma.jsp").forward(request, response);
      
                       
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
