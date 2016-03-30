package web.servelets.cadastro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RepositorioCidade;
import domain.entitys.Cidade;

/**
 * Servlet implementation class CadastrarPessoasGetCidades
 */
@WebServlet("/CadastrarPessoasGetCidades")
public class CadastrarPessoasGetCidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = "";
		String EstadoId = request.getParameter("EstadoId");
		if(EstadoId.equalsIgnoreCase("0")){
			codigo += "		<option value=\"\">Selecione a cidade...</option>";			
		}else{
			ArrayList<Cidade> cidades = new RepositorioCidade().getList(EstadoId);
			codigo += "		<option value=\"\">Selecione a cidade...</option>";
			for(Cidade elemento : cidades){
				codigo +="<option value="+elemento.getId()+">"+elemento.getNome()+"</option>";
			}
			
		}
		
		response.setContentType("text/plain");
		PrintWriter pWriter = response.getWriter();
		pWriter.write(codigo);			
		
		pWriter.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
