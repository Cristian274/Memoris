package Controlador;	
import ModeloDAO.AdultoMayorDAO;
import ModeloDAO.ReporteDAO;
import ModeloVO.AdultoMayorVO;
import ModeloVO.ReporteVO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian Florez
 */
@WebServlet(name = "pdf", urlPatterns = {"/pdf"})
public class pdf extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();

        try {

            try {
                Document documento = new Document();
                PdfWriter.getInstance(documento, out);

                documento.open();

                Paragraph par1 = new Paragraph();
                Font fontitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.RED);
                par1.add(new Phrase("Reporte Adulto mayor", fontitulo));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));
                documento.add(par1);

                
              
                AdultoMayorVO adulVO = new AdultoMayorVO();
                AdultoMayorDAO adulDAO = new AdultoMayorDAO();
                String id = (request.getParameter("txtid"));
                ArrayList<AdultoMayorVO> listaAdulto = adulDAO.listaradultoidentificacion(id);

                for (int i = 0; i < listaAdulto.size(); i++) {

                    adulVO = listaAdulto.get(i);
                    Paragraph par2 = new Paragraph();
                Font fondescrip = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
                par2.add(new Phrase("Aqui podra encontrar el seguimiento que se le ha dado a su familiar identificado CC: "+adulVO.getIdAdult()+". Nombre: "+adulVO.getNombres_Adult()+". Apellido: "+adulVO.getApellidos_Adult()+"." , fondescrip));
                par2.setAlignment(Element.ALIGN_JUSTIFIED);
                par2.add(new Phrase(Chunk.NEWLINE));
                par2.add(new Phrase(Chunk.NEWLINE));
                documento.add(par2);
                    

                }
                
                ReporteVO repVO = new ReporteVO();
                ReporteDAO repDAO = new ReporteDAO();
                ArrayList<ReporteVO> listaReporte = repDAO.listarreporteidentificacion(id);

                for (int i = 0; i < listaReporte.size(); i++) {

                    repVO = listaReporte.get(i);
                    Paragraph par2 = new Paragraph();
                Font fondescrip = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
                par2.add(new Phrase("El comportamiento del adulto ha sido descrito en el siguiente texto: "
                        + ""+repVO.getComportamiento()+". El cual ha sido registrado en: "+repVO.getFecha_Reporte()+"." , fondescrip));
                par2.setAlignment(Element.ALIGN_JUSTIFIED);
                par2.add(new Phrase(Chunk.NEWLINE));
                par2.add(new Phrase(Chunk.NEWLINE));
                documento.add(par2);
                    

                }
                




                Paragraph par3 = new Paragraph();
                Font fondescrip = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
                par3.add(new Phrase("Si encuentra incosistencias en la generación del comportamiento del adulto correspondiente por favor comunicarse con la parte administrativa del centro geriatrico", fondescrip));
                par3.setAlignment(Element.ALIGN_JUSTIFIED);
                par3.add(new Phrase(Chunk.NEWLINE));
                par3.add(new Phrase(Chunk.NEWLINE));
                documento.add(par3);
          
                documento.close();

            } catch (Exception e) {
                e.getMessage();
            }

        } finally {
            out.close();
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
