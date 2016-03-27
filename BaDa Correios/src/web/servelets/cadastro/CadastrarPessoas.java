package web.servelets.cadastro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RepositorioEstado;
import domain.entitys.Estado;
import domain.entitys.Pessoa;

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
		
		RepositorioEstado estadoRep = new RepositorioEstado();
//		Repositorio<Estado> cidadeRep = new Repositorio<Estado>();
		
		ArrayList<Estado> estados = estadoRep.getAll();
		
		pWriter.println("<div class=\"form-group input-group col-lg-6\">");
		pWriter.println("	<select class=\"form-control\" name=\"Estado\">");
		pWriter.println("		<option>Selecione o estado...</option>");
		for(Estado elemento : estados){
			pWriter.println("	<option>"+elemento.getNome()+"</option>");
		}			
		pWriter.println("	</select>");
		pWriter.println("</div>");
       
		pWriter.println("<div class=\"form-group input-group col-lg-6\">");
		pWriter.println("	<select class=\"form-control\" name=\"Cidade\">");
		pWriter.println("		<option>Selecione a cidade...</option>");
					
		pWriter.println("	</select>");
		pWriter.println("</div>");
		pWriter.println("</div>");
		pWriter.println("</form>");
		pWriter.println("</div>");
		
		pWriter.println("<div class=\"form-group col-lg-6\" id=\"cadastrarObjetoBtn\">");
		pWriter.println(
				"<button type=\"submit\" value=\"Submit\">Cadastrar</button>");
		pWriter.println("</div>");
		
		dispatcher = request.getRequestDispatcher("Paginas/rodape.html");
		dispatcher.include(request, response);
		
		pWriter.close();

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pessoa p = new Pessoa();
		
	}

}
