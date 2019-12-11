<%-- 
    Document   : Resultado
    Created on : 10/12/2019, 09:45:41 PM
    Author     : Cristian Florez
--%>


<%@page import="Controlador.Email"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <%

            Email email = new Email();

            String de = request.getParameter("de");
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            String para = request.getParameter("para");
            String mensaje = request.getParameter("mensaje");
            String asunto = request.getParameter("asunto");
            
            
            /*
            
            String[] direcciones = ("correo n1", "correo n2", "correo n3", "correo n...");
            boolean resultado = email.enviarCorreo(de, clave, direcciones, mensaje, asunto);
            
            */

            boolean resultado = email.enviarCorreo(de, clave, para, mensaje, asunto);

            if (resultado) {
                out.print("Correo recuperación correctamente enviado" + "\n\n" + "<a href='login.jsp'>Volver</a>");
            } else {
                out.print("Correo recuperación no enviado"+"\n\n"+"<a href='login.jsp'>Volver</a>");
}

                    %>
    </body>
</html>
