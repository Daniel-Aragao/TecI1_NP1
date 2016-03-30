package web.servelets.encaminhamento;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Encaminhamento")
public class Encaminhamento extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pWriter = response.getWriter();

		RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/topo.html");
		dispatcher.include(request, response);

		pWriter.println("<div class=\"container-fluid\">");
		pWriter.println("<div class=\"form-group input-group col-lg-12\">");
		pWriter.println("	<select required id='ObjetoId' class=\"form-control \" required name=\"ObjetoId\">");
		pWriter.println("		<option value=\"\">Descrição do objeto...</option>");
		pWriter.println("	</select>");
		pWriter.println("</div><br><br>");

		pWriter.println("<div class=\"form-group input-group col-lg-12\">");
		pWriter.println("	<select required id='PostoId' class=\"form-control \" required name=\"PostoId\">");
		pWriter.println("		<option value=\"\">Selecione o Posto...</option>");
		pWriter.println("	</select>");
		pWriter.println("</div><br><br>");

		pWriter.println("<div class=\"form-group input-group\"");
		pWriter.println(
				"<label for=\"DescricaoMovimentacaoPostoAtualInput\">Descrição da movimentação do posto de origem:</label>");
		pWriter.println(
				"<textarea disabled rows=\"4\" cols=\"150\" id=\"DescricaoMovimentacaoPostoAtualInput\" name=\"DescricaoMovimentacaoAtualPosto\" class=\"form-control\" required></textarea></div>");

		pWriter.println("<div class=\"form-group input-group col-lg-12\"><br>");
		
		pWriter.println("<div class=\"form-group\" id=\"cadastrarObjetoBtn\">");
		pWriter.println(
				"<button id=\"confirmButton\" class=\"btn btn-primary\" type=\"submit\" value=\"Submit\">Encaminhar Objeto</button>");
		pWriter.println("</div>");
		
		pWriter.println("</div>");

		dispatcher = request.getRequestDispatcher("Paginas/rodape.html");
		dispatcher.include(request, response);

		pWriter.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
