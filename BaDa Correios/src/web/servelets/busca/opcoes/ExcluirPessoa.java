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

/**
 * Servlet implementation class ExcluirPessoa
 */
@WebServlet("/ExcluirPessoa")
public class ExcluirPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter pWriter = response.getWriter();
		//ap�s confirma��o efetua a exclus�o da pessoa selecionada
		RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/topo.html");
		dispatcher.include(request, response);
		try{
			int pessoaId = Integer.parseInt(request.getParameter("PessoaId")); 
			if(new RepositorioPessoa().removeElement(pessoaId)){
				pWriter.println("<h2>");
				pWriter.println("Remo��o conclu�da com sucesso!");
				pWriter.println("</h2>");
			}else{
				pWriter.println("<h2>");
				pWriter.println("Erro na remo��o!");
				pWriter.println("</h2>");
			}
			
		}catch(NumberFormatException e){
			pWriter.println("<h2>");
			pWriter.println("Erro na remo��o!");
			pWriter.println("</h2>");
			
		}
		
		dispatcher = request.getRequestDispatcher("Paginas/rodape.html");
		dispatcher.include(request, response);
		
		pWriter.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
