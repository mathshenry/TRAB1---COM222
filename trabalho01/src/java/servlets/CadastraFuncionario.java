/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Controllers.FuncionarioController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class CadastraFuncionario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int codigo = 0;

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String funcao = request.getParameter("funcao");
        String senha = request.getParameter("senha");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            FuncionarioController fc = new FuncionarioController();
            codigo = fc.cadastraFuncionario(nome, email, senha, funcao);
            /* TODO output your page here. You may use following sample code. */
            if (codigo != -1) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Funcionário Cadastrado com sucesso!</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h3><center> O " + nome + " foi cadastrado com sucesso!"
                        + " Seu numero de acesso é: <b>" + codigo + "</b><center></h3>");
                out.println("<input type=\"button\" value=\"Acesso para Funcionários\" onclick=\"window.location.replace('LoginADMServlet');\">");
                out.println("</body>");
                out.println("</html>");
            }else{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Erro ao cadastrar funcionário!</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("Algo ocorreu de errado no cadastro, tente novamente!");
                out.println("<input type=\"button\" value=\"Voltar\" onclick=\"window.location.replace('LoginADMServlet');\">");
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
