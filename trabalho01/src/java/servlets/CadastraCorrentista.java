/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Controllers.CorrentistaController;
import Controllers.FuncionarioController;
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
public class CadastraCorrentista extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = 0;

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String cpf = request.getParameter("cpf");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            CorrentistaController correntistaController = new CorrentistaController();
            if (correntistaController.cadastraCorrentista(cpf, nome, endereco, email)) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Correntista Cadastrado com sucesso!</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h3><center> O " + nome + " foi cadastrado com sucesso!");
                out.println("<input type=\"button\" value=\"Voltar\" onclick=\"window.location.replace('LoginADMServlet');\">");
                out.println("</body>");
                out.println("</html>");
            }else{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Erro ao cadastrar Correntista!</title>");
                out.println("<link href=\"css/style.css\" rel='stylesheet' type='text/css' />");
                out.println("</head>");
                out.println("<body>");
                out.println("<h3><center> O " + nome + " não foi cadastrado!<br><br>");
                out.println("<input type=\"button\" value=\"Voltar\" onclick=\"window.location.replace('LoginADMServlet');\">");
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
