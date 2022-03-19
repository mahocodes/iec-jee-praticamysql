package controller;

import domain.ProdutoService;
import model.Produto;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static java.lang.Long.valueOf;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

@WebServlet("/listar-produto")
public class ListarProduto extends HttpServlet {
    @EJB
    private ProdutoService service;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            listaProduto(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listaProduto(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String codigoCategoria = request.getParameter("codigo_categoria");
        String nomeProduto = request.getParameter("nome_produto");

        List<Produto> listaProduto;

        if (isEmpty(codigoCategoria) && !isBlank(nomeProduto)) {
            throw new RuntimeException("Informe a categoria!");
        } else if (!isEmpty(codigoCategoria) && !isBlank(nomeProduto)) {
            listaProduto = service.listByNomeAndCategoria(nomeProduto, valueOf(codigoCategoria));
        } else {
            listaProduto = service.listByCategoria(valueOf(codigoCategoria));
        }

        request.setAttribute("listaProduto", listaProduto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listar_produto.jsp");
        dispatcher.forward(request, response);
    }
}