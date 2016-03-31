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
		
		
		pWriter.println("<div class=\"container-fluid\">");
		
		RepositorioEstado estadoRep = new RepositorioEstado();
		RepositorioCidade cidadeRep = new RepositorioCidade();
		
		ArrayList<Estado> estados = estadoRep.getAll();
		ArrayList<Cidade> cidades;
		
		String EstadoId = null;
		
		Pessoa pessoa = null;
		try{
			int pessoaId = Integer.parseInt(request.getParameter("Pessoaid"));
			pessoa = new RepositorioPessoa().get(pessoaId);
			EstadoId = pessoa.getEstadoId()+"";
			// início do formulário em caso de alteração
			pWriter.println("<form id=\"CadastroPessoasForm\" class=\"\" action=\"AlterarPessoa\" method=\"POST\">");
			pWriter.println("<input type='hidden' name='PessoaId' value='"+pessoaId+"'>");
		}catch(NumberFormatException e){
			//início do formulário em caso de cadastro comum
			pWriter.println("<form id=\"CadastroPessoasForm\" class=\"\" action=\"CadastrarPessoas\" method=\"POST\">");			
			
		}	
		
		 
		dispatcher = request.getRequestDispatcher("Paginas/Cadastros/CadastrarPessoasCentro.html");
		dispatcher.include(request, response);
		 
		pWriter.println("<div class=\"form-group input-group col-lg-6\">");
		pWriter.println("	<select required id='EstadoId' class=\"form-control \" required name=\"EstadoId\">");
		pWriter.println("		<option value=\"\">Selecione o estado...</option>");
		for(Estado elemento : estados){
			pWriter.println("	<option value="+elemento.getId()+">"+elemento.getNome()+"</option>");
		}			
		pWriter.println("	</select>");
		pWriter.println("</div>");		
       
		pWriter.println("<div class=\"form-group input-group col-lg-6\">");
		pWriter.println("	<select required id='CidadeId' class=\"form-control \" required name=\"Cidade\" "+((EstadoId!=null)?"":"disabled")+">");
		pWriter.println("		<option value=\"\">Selecione a cidade...</option>");
		if(EstadoId != null){
			cidades = cidadeRep.getList(EstadoId);
			// traz os dados previamente informados pela opção de alteração, se for uma alteração
			for(Cidade elemento : cidades){
				pWriter.println("<option value="+elemento.getId()+">"+elemento.getNome()+"</option>");
			}	
		}
		pWriter.println("	</select>");
		pWriter.println("</div>");
		
		pWriter.println("<div class=\"form-group\" id=\"cadastrarObjetoBtn\">");
		pWriter.println(
				"<button id=\"confirmButton\" class=\"btn btn-primary\" type=\"submit\" value=\"Submit\">"+
		((EstadoId != null)?"Alterar":"Cadastrar")+"</button>");
		pWriter.println("</div>");
		
		pWriter.println("</div>");
		
		
		pWriter.println("</form>");
		pWriter.println("</div>");
		
		
		
		pWriter.println("<script src=\"JavaScript/Project/CadastrarPessoa.js\"></script>");
		if(pessoa != null){
			// script que preenche os campos automáticamente em caso de alteração
			pWriter.println("<script>");
			pWriter.println("document.getElementById('NomeInput').value = '"+ pessoa.getNome()+"'");
			pWriter.println("document.getElementById('RuaInput').value = '"+ pessoa.getRua()+"'");
			pWriter.println("document.getElementById('NumeroInput').value = "+ pessoa.getNumero());
			pWriter.println("document.getElementById('ComplementoInput').value = '"+ pessoa.getComplemento()+"'");
			pWriter.println("document.getElementById('BairroInput').value = '"+ pessoa.getBairro()+"'");
			pWriter.println("document.getElementById('CEPInput').value = "+ pessoa.getCep());
			pWriter.println("document.getElementById('EstadoId').value = "+ pessoa.getEstadoId());
			pWriter.println("document.getElementById('CidadeId').value = "+ pessoa.getCidadeId());
			pWriter.println("</script>");
		}
		
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
