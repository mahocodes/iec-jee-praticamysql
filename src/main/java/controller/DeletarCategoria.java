package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import domain.CategoriaService;

@WebServlet(urlPatterns = "/delete")
public class DeletarCategoria extends HttpServlet {

	@EJB
	private CategoriaService service;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Long codigo = Long.parseLong(request.getParameter("id"));

            service.delete(codigo);

            response.sendRedirect(request.getContextPath() + "/index.jsp");			
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
}
