/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Controllers.ContaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xonas
 */
public class ConsultaExtratoCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cookie[] cookies = request.getCookies();
        long conta = -1;

        for (Cookie c : cookies) {
            if (c.getName().equals("conta")) {
                conta = Long.valueOf(c.getValue());
            }
        }
        
        if (conta == -1) {
            response.sendRedirect("index.jsp");
        }

        ContaController contaController = new ContaController();
        try (PrintWriter out = response.getWriter()) {
            if (contaController.isContaValida(conta)) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Consulta realizado com sucesso!</title>");
                out.println("<link href=\"css/style.css\" rel='stylesheet' type='text/css' />");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>Consulta realizada com sucesso!<br>Seu extrato é:<br><br>" + contaController.getExtrato(conta));
                out.println("<input type=\"button\" value=\"Voltar\" onclick=\"window.location.replace('cliente/inicio.jsp');\">");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Erro ao fazer consulta!</title>");
                out.println("<link href=\"css/style.css\" rel='stylesheet' type='text/css' />");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>Algo ocorreu de errado na consulta, tente novamente!</p>");
                out.println("<input type=\"button\" value=\"Voltar\" onclick=\"window.location.replace('cliente/inicio.jsp');\">");
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
