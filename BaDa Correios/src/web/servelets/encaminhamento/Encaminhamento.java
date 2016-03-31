package web.servelets.encaminhamento;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RepositorioMovimentacao;
import DAO.RepositorioObjeto;
import DAO.RepositorioPosto;
import domain.entitys.Movimentacao;
import domain.entitys.Objeto;
import domain.entitys.Posto;

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
		
		RepositorioObjeto repObjeto = new RepositorioObjeto();
		RepositorioPosto repPosto = new RepositorioPosto();
		
		ArrayList<Objeto> objetos = repObjeto.getAll();
		ArrayList<Posto> postos = repPosto.getAll();

		
		pWriter.println("<form action=\"Encaminhamento\" method=\"POST\">  ");
		
		pWriter.println("<div class=\"container-fluid\">");
		pWriter.println("<div class=\"form-group input-group col-lg-12\">");
		pWriter.println("	<select required id='ObjetoId' class=\"form-control \" required name=\"ObjetoId\">");
		pWriter.println("		<option value=\"\">Descrição do objeto...</option>");
		for(Objeto objeto : objetos){
			pWriter.println("		<option value=\""+objeto.getNumero()+"\">"+objeto.getDescricao()+"</option>");
		}
		pWriter.println("	</select>");
		pWriter.println("</div><br><br>");

		pWriter.println("<div class=\"form-group input-group col-lg-12\">");
		pWriter.println("	<select required id='PostoId' class=\"form-control \" required name=\"PostoId\">");
		pWriter.println("		<option value=\"\">Selecione o Posto...</option>");
		for(Posto posto : postos){
			pWriter.println("		<option value=\""+posto.getId()+"\">"+posto.getNome()+"</option>");
		}
		pWriter.println("	</select>");
		pWriter.println("</div><br><br>");

		pWriter.println("<div class=\"form-group input-group\"");
		pWriter.println(
				"<label for=\"DescricaoMovimentacaoPostoAtualInput\">Descrição da movimentação do posto de origem:</label>");
		pWriter.println(
				"<textarea rows=\"4\" cols=\"150\" id=\"DescricaoMovimentacaoPostoAtualInput\" name=\"DescricaoMovimentacaoAtualPosto\" class=\"form-control\" required></textarea></div>");

		pWriter.println("<div class=\"form-group input-group col-lg-12\"><br>");
		
		pWriter.println("<div class=\"form-group\" id=\"cadastrarObjetoBtn\">");
		pWriter.println(
				"<button id=\"confirmButton\" class=\"btn btn-primary\" type=\"submit\" value=\"Submit\">Encaminhar Objeto</button>");
		pWriter.println("</div>");
		
		pWriter.println("</div>");

		pWriter.println("</form>");
		dispatcher = request.getRequestDispatcher("Paginas/rodape.html");
		dispatcher.include(request, response);

		pWriter.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pWriter = response.getWriter();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/topo.html");
		dispatcher.include(request, response);
		
		
		try{
			String ObjetoId = request.getParameter("ObjetoId");
			int PostoId = Integer.parseInt(request.getParameter("PostoId"));
			String DescricaoMovimentacaoAtualPosto = request.getParameter("DescricaoMovimentacaoAtualPosto");
			
			Movimentacao movimentacao = new Movimentacao(DescricaoMovimentacaoAtualPosto, ObjetoId,PostoId);
			if(new RepositorioMovimentacao().adicionar(movimentacao)){
				sucess(pWriter);
			}else{
				fail(pWriter);
			}
			
		}catch(NumberFormatException e){
			fail(pWriter);
		}
		
		
		dispatcher = request.getRequestDispatcher("Paginas/rodape.html");
		dispatcher.include(request, response);
		
		pWriter.close();
		
	}
	public void sucess(PrintWriter pWriter){
		pWriter.println("<h2>");
		pWriter.println("Encaminhado!");
		pWriter.println("</h2>");
	}
	public void fail(PrintWriter pWriter){
		pWriter.println("<h2>");
		pWriter.println("Erro ao encaminhar");
		pWriter.println("</h2>");		
	}
}
