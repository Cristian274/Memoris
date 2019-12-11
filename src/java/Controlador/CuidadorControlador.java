/*
 create table VEHICULO
(
   VEHPLACA             varchar(10) not null,
   DATID                int,
   CATID                int,
   VEHMODELO            int,
   VEHMARCA             varchar(50),
   VEHESTADO            varchar(30),
   VEHPRECIO            int,
   primary key (VEHPLACA)

    actualizar vehiculo
    preguntar placa <%=vehVO.getplaca%> y un button 
    <%vehiculoVO vehVO = {getat"volleno"}%>
    <%=vehVO.getplaca%> asi con todos los inputs 
       
    otro boton actualizar hidden 2 
    
    reeutilizar     
    <%arraylist dao.listar%>
    ELIMINAR executeUpdate("DELETE FROM persona WHERE id='"+codigo+"'");
);
 */
package Controlador;

import ModeloDAO.CuidadorDAO;
import ModeloVO.CuidadorVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CuidadorControlador", urlPatterns = {"/Cuidador"})
public class CuidadorControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        //VehPlaca,DatiD,CatiD,VehModelo,VehMarca, VehEstado,VehPrecio;
        String Id_Usu = request.getParameter("IDU");
        String Id_Cuid = request.getParameter("IDC");
        String Nomb_Cuid = request.getParameter("NombreC");
        String Apel_Cuid = request.getParameter("ApellidoC"); 
        String Email_Cuid = request.getParameter("CorreoC");
        String Telefono_Cuid = request.getParameter("TelefonoC");
        String Foto_Cuid = request.getParameter("FotoC");
        CuidadorVO cuidVO = new CuidadorVO(Id_Cuid, Nomb_Cuid, Apel_Cuid, Telefono_Cuid, Email_Cuid, Foto_Cuid,Id_Usu);
        CuidadorDAO cuidDAO = new CuidadorDAO(cuidVO);

        switch (opcion) {
            case 1: // Agregar registro 
                if (cuidDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "El cuidador se registró correctamente");
                } else {
                    request.setAttribute("mensajeError", "El cuidador no pudo ser registrado");
                }
                request.getRequestDispatcher("ccuidador.jsp").forward(request, response);
                break;
            case 2: // actualizar registro
                if (cuidDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El cuidador se actualizó correctamente");

                } else {
                    request.setAttribute("mensajeError", "El cuidador no pudo ser actualizado");

                }
                request.getRequestDispatcher("rcuidador.jsp").forward(request, response);
                break;
           /* case 3: // Consultar por identificacion
                CuidadorVO cuidvo = CuidadorDAO.consultariden(Id_Cuid);
                if (cuidvo != null) {

                    request.setAttribute("volleno",cuidvo);
                    request.getRequestDispatcher("ucuidador.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El cuidador NO existe");
                    request.getRequestDispatcher("rcuidador.jsp").forward(request, response);

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
