package web.servelets.busca;

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
import domain.entitys.Pessoa;

/**
 * Servlet implementation class BuscarPessoas
 */
@WebServlet("/BuscarPessoas")
public class BuscarPessoas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pWriter = response.getWriter();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/topo.html");
		dispatcher.include(request, response);
		
		pWriter.println("<form action=\"BuscarPessoas\" method=\"GET\">  ");
			dispatcher = request.getRequestDispatcher("Paginas/Buscar/BuscarTopo.html");
			dispatcher.include(request, response);
		pWriter.println("</form>");
		
		String busca = (String) request.getParameter("busca");
		
		
		if(busca != null){
			dispatcher = request.getRequestDispatcher("Paginas/Buscar/BuscarPessoaTable.html");
			dispatcher.include(request, response);
			
			RepositorioPessoa pessoasRep = new RepositorioPessoa();
			ArrayList<Pessoa> pessoas = pessoasRep.getList(busca);
			pessoas.sort(Pessoa.getNomeComparator());
			
			
			RepositorioEstado estadoRep = new RepositorioEstado();
			RepositorioCidade cidadeRep = new RepositorioCidade();
			
			for(Pessoa p : pessoas){
				pWriter.println("					<tr>");
				pWriter.println("				<td>");
				pWriter.println(p.getNome());
				pWriter.println("				</td>");
				
				pWriter.println("				<td>");
				pWriter.println(p.getRua());
				pWriter.println("				</td>");

				pWriter.println("				<td>");
				pWriter.println(p.getNumero());
				pWriter.println("				</td>");
				
				pWriter.println("				<td>");
				pWriter.println(p.getComplemento());
				pWriter.println("				</td>");
				
				pWriter.println("				<td>");
				pWriter.println(p.getBairro());
				pWriter.println("				</td>");
				
				pWriter.println("				<td>");
				pWriter.println(p.getCep());
				pWriter.println("				</td>");
				
				pWriter.println("				<td>");
				pWriter.println(estadoRep.get(p.getEstadoId()).getNome());
				pWriter.println("				</td>");
				
				pWriter.println("				<td>");
				pWriter.println(cidadeRep.get(p.getCidadeId()).getNome());
				pWriter.println("				</td>");
				
				pWriter.println("				<td>");
				pWriter.println("<a href='CadastrarPessoas?Pessoaid="+p.getId()+"'>Alterar</a>");
				pWriter.println("				</td>");
				
				pWriter.println("				<td>");
				pWriter.println("<a>Excluir</a>");
				pWriter.println("				</td>");
				pWriter.println("					</tr>");
			}
		}
		pWriter.println("				</tbody>");
		pWriter.println("			</table>");
		pWriter.println("		</div>");
		pWriter.println("	</div>");
		pWriter.println("</div>");
		
		dispatcher = request.getRequestDispatcher("Paginas/rodape.html");
		dispatcher.include(request, response);
		
		pWriter.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
