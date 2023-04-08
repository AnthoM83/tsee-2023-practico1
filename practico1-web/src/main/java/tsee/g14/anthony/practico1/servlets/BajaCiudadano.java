package tsee.g14.anthony.practico1.servlets;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import tsee.g14.anthony.practico1.commons.excepciones.EntidadNoExisteException;

/**
 *
 * @author Anthony Mallada
 */
@WebServlet(name = "BajaCiudadano", urlPatterns = {"/BajaCiudadano"})
public class BajaCiudadano extends HttpServlet {
    
    @EJB(lookup = "ejb:practico1/practico1-ejb/GestorCiudadanosBean!tsee.g14.anthony.practico1.ejb.servicios.GestorCiudadanosRemote")
    tsee.g14.anthony.practico1.ejb.servicios.GestorCiudadanosRemote gestorCiudadanos;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BajaCiudadano</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BajaCiudadano at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            gestorCiudadanos.bajaCiudadano(request.getParameter("cedula"));
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/commons/success.jsp");
            rd.forward(request, response);
        } catch (EntidadNoExisteException ex) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/errores/ciudadano-no-existe.jsp");
            rd.forward(request, response);
        }
    }

 @Override
    public String getServletInfo() {
        return "Short description";
    }

}
