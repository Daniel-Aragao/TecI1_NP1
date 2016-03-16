package servlets.cadastro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RepositorioPosto_e_Localizacao;
import entitys.Entity;
import entitys.Objeto;

/**
 * Servlet implementation class CadastrarObjetos
 */
@WebServlet("/CadastrarObjetos")
public class CadastrarObjetos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pWriter = response.getWriter();

		RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/topo.html");
		dispatcher.include(request, response);

		dispatcher = request.getRequestDispatcher("Paginas/Cadastros/CadastrarObjetos.html");
		dispatcher.include(request, response);

		// RepositorioPosto_e_Localizacao localizacoesRep = new
		// RepositorioPosto_e_Localizacao();

		pWriter.println("<div class=\"form-group\">");
		pWriter.println("<label for=\"RuaInput\">Informações da movimentação: </label>");
		pWriter.println("</div>");

		pWriter.println("<div class=\"form-group col-lg-3\">");
		pWriter.println("	<select class=\"form-control\" name=\"Remetente\">");
		pWriter.println("		<option>Remetente</option>");
		pWriter.println("	</select>");
		pWriter.println("</div>");

		pWriter.println("<div class=\"form-group col-lg-3\">");
		pWriter.println("	<select class=\"form-control\" name=\"Destinatario\">");
		pWriter.println("		<option>Destinatário</option>");
		pWriter.println("	</select>");
		pWriter.println("</div>");

		pWriter.println("<div class=\"form-group col-lg-3\">");
		pWriter.println("	<select class=\"form-control\" name=\"Posto\">");
		pWriter.println("		<option>Posto</option>");
		pWriter.println("	</select>");
		pWriter.println("</div>");

		pWriter.println("</div>");

		dispatcher = request.getRequestDispatcher("Paginas/Cadastros/CadastrarObjetoContinuacao.html");
		dispatcher.include(request, response);

		pWriter.println("<div class=\"form-group col-lg-2\">");
		pWriter.println("<label class=\"valorLabel\">Valor: </label>");
		pWriter.println("</div>");
		pWriter.println("<div class=\"form-group col-lg-2\">");
		pWriter.println(
				"<input id=\"ValorOutput\" type=\"text\" name=\"ValorObjeto\" class=\"form-control\" placeholder=\"R$00,00\">");
		pWriter.println("</div>");
		pWriter.println("<div class=\"form-group col-lg-2\">");
		pWriter.println(
				"<input id=\"ValorOutput\" type=\"text\" name=\"ValorObjeto\" class=\"form-control\" placeholder=\"Insert a button here\">");
		pWriter.println("</div>");

		pWriter.println("</form>");
		pWriter.println("</div>");

		dispatcher = request.getRequestDispatcher("Paginas/rodape.html");
		dispatcher.include(request, response);

		pWriter.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Objeto o = new Objeto();

	}
}
