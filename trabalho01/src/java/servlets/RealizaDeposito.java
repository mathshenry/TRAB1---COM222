/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Controllers.TransacaoController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maths
 */
public class RealizaDeposito extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long conta = Long.valueOf(request.getParameter("conta"));
        Double valor = Double.valueOf(request.getParameter("valor"));
        
        TransacaoController transacaoController = new TransacaoController();
        try (PrintWriter out = response.getWriter()) {
            if(transacaoController.realizaDeposito(conta, valor)){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Depósito realizado com sucesso!</title>");
                out.println("<link href=\"css/style.css\" rel='stylesheet' type='text/css' />");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>O Depósito foi realizado com sucesso!<br>");
                out.println("<input type=\"button\" value=\"Voltar\" onclick=\"window.location.replace('adm/inicio.jsp');\">");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Erro ao fazer Depósito!</title>");
                out.println("<link href=\"css/style.css\" rel='stylesheet' type='text/css' />");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>Algo ocorreu de errado no Depósito, tente novamente!</p>");
                out.println("<input type=\"button\" value=\"Voltar\" onclick=\"window.location.replace('adm/inicio.jsp');\">");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
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
