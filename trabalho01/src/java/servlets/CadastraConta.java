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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maths
 */
public class CadastraConta extends HttpServlet {

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
        ContaController contaController = new ContaController();
        String correntista1 = request.getParameter("correntista1");
        String correntista2 = request.getParameter("correntista2");
        String correntista3 = request.getParameter("correntista3");
        Double saldo = Double.valueOf(request.getParameter("saldo"));
        Double limite = Double.valueOf(request.getParameter("limite"));
        String senha = request.getParameter("senha");
        long codigo;
        try (PrintWriter out = response.getWriter()) {
            codigo = contaController.cadastraConta(correntista1, correntista2, correntista3, saldo, limite, senha);
            /* TODO output your page here. You may use following sample code. */
            if (codigo != -1) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Conta Cadastrada com sucesso!</title>");
                out.println("<link href=\"css/style.css\" rel='stylesheet' type='text/css' />");
                out.println("</head>");
                out.println("<body>");
                out.println("Conta cadastrada com sucesso! <br> O número da conta é: <b>" + codigo+ "</b><br>");
                out.println("<input type=\"button\" value=\"Voltar\" onclick=\"window.location.replace('adm/inicio.jsp');\">");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Erro ao cadastrar conta!</title>");
                out.println("<link href=\"css/style.css\" rel='stylesheet' type='text/css' />");
                out.println("</head>");
                out.println("<body>");
                out.println("<p>Algo ocorreu de errado no cadastro, tente novamente!</p>");
                out.println("<input type=\"button\" value=\"Voltar\" onclick=\"window.location.replace('adm/inicio.jsp');\">");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
