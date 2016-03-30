package web.servelets.busca.opcoes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RepositorioPessoa;
import domain.entitys.Pessoa;

/**
 * Servlet implementation class AlterarPessoa
 */
@WebServlet("/AlterarPessoa")
public class AlterarPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pWriter = response.getWriter();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/topo.html");
		dispatcher.include(request, response);
		
		
		try{
			int id = Integer.parseInt(request.getParameter("PessoaId"));
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
			pessoa.setId(id);
			new RepositorioPessoa().alterar(pessoa);
			
			
			
			pWriter.println("<h2>");
			pWriter.println("Alteração Realizada com sucesso!");
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
