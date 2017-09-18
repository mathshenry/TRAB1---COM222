/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Controllers.ContaController;
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
public class RealizaTransferencia extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long conta = Long.valueOf(request.getParameter("conta"));
        long contaCredito = Long.valueOf(request.getParameter("contaCredito"));
        Double valor = Double.valueOf(request.getParameter("valor"));
        String senha = request.getParameter("senha");
        
        TransacaoController transacaoController = new TransacaoController();
        ContaController contaController= new ContaController();
        try (PrintWriter out = response.getWriter()) {
            if(transacaoController.realizaTransferencia(conta, contaCredito, valor) && contaController.isSenhaValida(conta, senha)){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Transferência realizada com sucesso!</title>");
                out.println("<link href=\"css/style.css\" rel='stylesheet' type='text/css' />");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>A Transferência foi realizada com sucesso!<br>");
                out.println("<input type=\"button\" value=\"Voltar\" onclick=\"window.location.replace('adm/inicio.jsp');\">");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Erro ao fazer Transferência!</title>");
                out.println("<link href=\"css/style.css\" rel='stylesheet' type='text/css' />");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>Algo ocorreu de errado na Transferência, tente novamente!</p>");
                out.println("<input type=\"button\" value=\"Voltar\" onclick=\"window.location.replace('adm/inicio.jsp');\">");
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
