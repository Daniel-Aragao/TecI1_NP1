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

import DAO.RepositorioCidade;
import DAO.RepositorioEstado;
import DAO.RepositorioPessoa;
import domain.entitys.Cidade;
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
		RepositorioCidade cidadeRep = new RepositorioCidade();
		
		ArrayList<Estado> estados = estadoRep.getAll();
		ArrayList<Cidade> cidades;
		
		String EstadoId = request.getParameter("EstadoId");
		
		
		pWriter.println("<div class=\"form-group input-group col-lg-6\">");
		pWriter.println("	<select id=EstadoId class=\"form-control \" required name=\"EstadoId\">");
		pWriter.println("		<option value=0>Selecione o estado...</option>");
		for(Estado elemento : estados){
			pWriter.println("	<option value="+elemento.getId()+">"+elemento.getNome()+"</option>");
		}			
		pWriter.println("	</select>");
		pWriter.println("</div>");		
       
		pWriter.println("<div class=\"form-group input-group col-lg-6\">");
		pWriter.println("	<select id=\"CidadeId\" class=\"form-control \" required name=\"Cidade\">");
		pWriter.println("		<option value=0>Selecione a cidade...</option>");
		if(EstadoId != null){
			cidades = cidadeRep.getList(EstadoId);
			for(Cidade elemento : cidades){
				pWriter.println("<option value="+elemento.getId()+">"+elemento.getNome()+"</option>");
			}	
		}
		pWriter.println("	</select>");
		pWriter.println("</div>");
		
		pWriter.println("<div class=\"form-group\" id=\"cadastrarObjetoBtn\">");
		pWriter.println(
				"<button id=\"confirmButton\" class=\"btn btn-primary\" type=\"submit\" value=\"Submit\">Cadastrar</button>");
		pWriter.println("</div>");
		
		pWriter.println("</div>");
		
		
		pWriter.println("</form>");
		pWriter.println("</div>");
		
		
		
		pWriter.println("<script src=\"JavaScript/Project/CadastrarPessoa.js\"></script>");
		
		dispatcher = request.getRequestDispatcher("Paginas/rodape.html");
		dispatcher.include(request, response);
		
		pWriter.close();
		
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pWriter = response.getWriter();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/topo.html");
		dispatcher.include(request, response);
		
		
		try{
			String nome = request.getParameter("Nome");
			String rua = request.getParameter("Rua"); 
			String complemento = request.getParameter("Complemento"); 
			String bairro = request.getParameter("Bairro"); 
			String cep = request.getParameter("CEP"); 
			int estadoId = Integer.parseInt(request.getParameter("EstadoId"));
			int cidadeId = Integer.parseInt(request.getParameter("Cidade"));
			String aux = request.getParameter("Numero").replace("-", "").trim();
			int numero = Integer.parseInt(aux);
			
			Pessoa pessoa = new Pessoa(nome, rua, complemento, bairro, cep, estadoId, cidadeId,numero);
			new RepositorioPessoa().adicionar(pessoa);
			
			
			
			pWriter.println("<h2>");
			pWriter.println("Cadastro Realizado com sucesso!");
			pWriter.println("</h2>");
			
			
		}catch(Exception e){
			e.printStackTrace();
			pWriter.println("<h2>");
			pWriter.println("Campos inválidos ou em branco");
			pWriter.println("</h2>");
		}
		
		dispatcher = request.getRequestDispatcher("Paginas/rodape.html");
		dispatcher.include(request, response);
		
		pWriter.close();
		
	}

}
