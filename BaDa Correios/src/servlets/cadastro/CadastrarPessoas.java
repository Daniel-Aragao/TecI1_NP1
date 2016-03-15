package servlets.cadastro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entitys.Pessoa;

/**
 * Servlet implementation class CadastrarPessoas
 */
@WebServlet("/CadastrarPessoas")
public class CadastrarPessoas extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pWriter = response.getWriter();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/topo.html");
		dispatcher.include(request, response);
		
		dispatcher = request.getRequestDispatcher("Paginas/Cadastros/CadastrarPessoas.html");
		dispatcher.include(request, response);
		
		
		
		dispatcher = request.getRequestDispatcher("Paginas/rodape.html");
		dispatcher.include(request, response);
		
		pWriter.close();

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pessoa p = new Pessoa();
		
	}

}
