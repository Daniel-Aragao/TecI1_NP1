package web.servelets.cadastro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RepositorioMovimentacao;
import DAO.RepositorioObjeto;
import DAO.RepositorioPessoa;
import DAO.RepositorioPosto;
import domain.entitys.Movimentacao;
import domain.entitys.Objeto;
import domain.entitys.Pessoa;
import domain.entitys.Posto;

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

		RepositorioPessoa repPessoa = new RepositorioPessoa();
		RepositorioPosto repPosto = new RepositorioPosto();
		
		pWriter.println("<div class=\"form-group\">");
		pWriter.println("<label for=\"RuaInput\">Informações da movimentação: </label>");
		pWriter.println("</div>");

		pWriter.println("<div class=\"form-group col-lg-3\">");
		pWriter.println("	<select required class=\"form-control selectBox\" name=\"Remetente\" >");
		pWriter.println("		<option value=\"\">Remetente</option>");			
		for(Pessoa p : repPessoa.getAll()){
			pWriter.println("		<option value='"+p.getId()+"'>"+p.getNome()+"</option>");
		}
		pWriter.println("	</select>");
		pWriter.println("</div>");

		pWriter.println("<div class=\"form-group col-lg-3\">");
		pWriter.println("	<select required class=\"form-control selectBox\" name=\"Destinatario\" >");
		pWriter.println("		<option value=\"\">Destinatário</option>");
		for(Pessoa p : repPessoa.getAll()){
			pWriter.println("		<option value='"+p.getId()+"'>"+p.getNome()+"</option>");
		}
		pWriter.println("	</select>");
		pWriter.println("</div>");

		pWriter.println("<div class=\"form-group col-lg-3\">");
		pWriter.println("	<select required class=\"form-control selectBox\" name=\"Posto\" >");
		pWriter.println("		<option value=\"\">Posto</option>");
		for(Posto p : repPosto.getAll()){
			pWriter.println("		<option value='"+p.getId()+"'>"+p.getNome()+"</option>");
		}
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
				"<input id=\"ValorOutput\" type=\"number\" name=\"ValorObjeto\" class=\"form-control\" onchange='mascara(this, '###.##')' readonly placeholder=\"R$00,00\">");
		pWriter.println("</div>");
		pWriter.println("<div class=\"form-group col-lg-1\">");
		pWriter.println(
				"<input type=\"button\" id=\"gerarValor\" class=\"btn btn-primary\" value=\"Gerar Valor\">");
		pWriter.println("</div>");

		
		pWriter.println("<div class=\"form-group col-lg-1\" id=\"cadastrarObjetoBtn\">");
		pWriter.println(
				"<button id=\"cadastrarButton\" class=\"btn btn-primary\" type=\"submit\" value=\"Submit\">Cadastrar</button>");
		pWriter.println("</div>");
		

		pWriter.println("</form>");
		pWriter.println("</div>");
		pWriter.println("<br><br><br>");
		pWriter.println("<script src=\"JavaScript/Project/CadastrarObjeto.js\"></script>");
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
			String numero = request.getParameter("Numero");
			String descricao = request.getParameter("Descricao"); 
			double peso = Double.parseDouble(request.getParameter("Peso")); 
			double altura = Double.parseDouble(request.getParameter("Altura")); 
			double largura = Double.parseDouble(request.getParameter("Largura")); 
			double profundidade = Double.parseDouble(request.getParameter("Profundidade"));
			double valor = Double.parseDouble(request.getParameter("ValorObjeto"));
			int remetendeId = Integer.parseInt(request.getParameter("Remetente"));
			int destinatarioId = Integer.parseInt(request.getParameter("Destinatario"));
			
			int postoId = Integer.parseInt(request.getParameter("Posto"));
			String descricaoMovimentacao = request.getParameter("DescricaoMovimentacao");
			
			
			Objeto objeto = new Objeto(numero, descricao, peso, altura, largura, profundidade, valor,remetendeId,destinatarioId);
			Movimentacao mov = new Movimentacao(descricaoMovimentacao, numero, postoId);
			
			
			if(new RepositorioObjeto().adicionar(objeto) && new RepositorioMovimentacao().adicionar(mov)){
				sucess(pWriter);
			}else{
				fail(pWriter);
			}		
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			fail(pWriter);
		}
		
		dispatcher = request.getRequestDispatcher("Paginas/rodape.html");
		dispatcher.include(request, response);
		
		pWriter.close();
	}
	
	public void sucess(PrintWriter pWriter){
		pWriter.println("<h2>");
		pWriter.println("Cadastro Realizado com sucesso!");
		pWriter.println("</h2>");
	}
	public void fail(PrintWriter pWriter){
		pWriter.println("<h2>");
		pWriter.println("Campos inválidos ou em branco");
		pWriter.println("</h2>");		
	}
}
