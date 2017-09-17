/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Controllers.FuncionarioController;
import com.sun.java.swing.plaf.windows.resources.windows;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author maths
 */
public class LoginADMServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            response.sendRedirect("adm/inicio.jsp");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            FuncionarioController funcionarioController = new FuncionarioController();

            if (funcionarioController.isUsuarioValido(usuario, senha)) {
                response.sendRedirect("adm/inicio.jsp");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Acesso inválido!</title>");
                out.println("<link href=\"css/style.css\" rel='stylesheet' type='text/css' />");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>A conta/senha não é válida!</p><br>");
                out.println("<input type=\"button\" value=\"Voltar\" onclick=\"window.location.replace('adm/loginADM.jsp');\">");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
