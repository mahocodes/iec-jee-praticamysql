package controller;

import domain.ProdutoService;
import model.Produto;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet implementation class InserirProduto
 */
@WebServlet("/inserir")
public class InserirProduto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private ProdutoService service;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nome = request.getParameter("nome");

        Produto produto = new Produto();
        produto.setNome(nome);

        try {
            service.create(produto);

            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
            PrintWriter out = response.getWriter();
            out.print("<html>");
            out.print("<h2> Nao foi possivel inserir a produto!</h2>");
            out.print("<br");
            out.print("<a href = 'index.jsp'> Voltar </a>");
            out.print("</html>");
        }
    }

}
