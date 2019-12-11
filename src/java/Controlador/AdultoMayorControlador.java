package Controlador;


import ModeloDAO.AdultoMayorDAO;
import ModeloVO.AdultoMayorVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* @author Dayanna */
@WebServlet(name = "AdultoMayorControlador", urlPatterns = {"/AdultoMayor"})
public class AdultoMayorControlador extends HttpServlet {

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

        String IdAdult = request.getParameter("IDAM");
        String Nombres_Adult = request.getParameter("NombreAM");
        String Apellidos_Adult = request.getParameter("ApellidoAM");
        String Genero_Adult = request.getParameter("GeneroAM");
        String Fecha_Adult = request.getParameter("FechaAM");
        String Foto_Adult = request.getParameter("FotoF");

        AdultoMayorVO adulVO = new AdultoMayorVO(IdAdult, Nombres_Adult, Apellidos_Adult, Genero_Adult, Fecha_Adult, Foto_Adult);
         AdultoMayorDAO adulDAO = new AdultoMayorDAO(adulVO);

        switch (opcion) {
            case 1: // agregar
                if (adulDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El adulto se registró con éxito");
                } else {
                    request.setAttribute("mesajeError", "El adulto no se registró correctamente");
                }
                request.getRequestDispatcher("cadulto.jsp").forward(request, response);
                break;

            case 2: // modificar
                if (adulDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El adulto se Actualizó con éxito");
                } else {
                    request.setAttribute("mesajeError", "El adulto no se Actualizó");
                }
                request.getRequestDispatcher("radulto.jsp").forward(request, response);
                break;

         /*   case 3: // consulta
                AdultoMayorVO adultomayorvo = adulDAO.consultarIda(IdAdult);

                if (adultomayorvo != null) {
                    request.setAttribute("volleno", adultomayorvo);
                    request.getRequestDispatcher("uadulto.jsp").forward(request, response);

                } else {
                    request.setAttribute("mensajeError", "El adulto NO existe");
                    request.getRequestDispatcher("radulto.jsp").forward(request, response);

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
