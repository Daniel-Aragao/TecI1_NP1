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

import DAO.RepositorioMovimentacao;
import DAO.RepositorioObjeto;
import domain.entitys.Movimentacao;
import domain.entitys.Objeto;

/**
 * Servlet implementation class BuscarObjeto
 */
@WebServlet("/BuscarObjeto")
public class BuscarObjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscarObjeto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pWriter = response.getWriter();

		RequestDispatcher dispatcher = request.getRequestDispatcher("Paginas/topo.html");
		dispatcher.include(request, response);

		pWriter.println("<form action=\"BuscarObjeto\" method=\"GET\">  ");
		dispatcher = request.getRequestDispatcher("Paginas/Buscar/BuscarObjetoTopo.html");
		dispatcher.include(request, response);
		pWriter.println("</form>");
		
		String busca = (String) request.getParameter("busca");

		
		try{
			//buscar o objeto no banco para achar suas movimentações e informações
			RepositorioObjeto repObjeto = new RepositorioObjeto();
			RepositorioMovimentacao repMovimentacao = new RepositorioMovimentacao();
			
			Objeto objeto  = repObjeto.get(Integer.parseInt(busca));
			
			pWriter.println("<div id=\"buscaTopo\" class=\"panel panel-default col-md-8 col-lg-8 col-md-offset-2 col-lg-offset-2 \">");
			pWriter.println("<div class='col-lg-offset-2 col-lg-8'>");
			pWriter.println("<form>");
			pWriter.println("<fieldset>");
			pWriter.println(" <legend>Informações do Objeto:</legend>");
			pWriter.println("Número: <u>"+objeto.getNumero()+"</u>");
			pWriter.println("Descrição: <u>"+objeto.getDescricao()+"</u>");
			pWriter.println("Peso: <u>"+objeto.getPeso()+"</u>");		
			pWriter.println("Altura: <u>"+objeto.getAltura()+"</u>");
			pWriter.println("Profundidade: <u>"+objeto.getProfundidade()+"</u>");
			pWriter.println("Valor: <u>"+objeto.getValor()+"</u>");
			pWriter.println(" </fieldset>");
			pWriter.println("</form> ");
			pWriter.println("</div>");
			dispatcher = request.getRequestDispatcher("Paginas/Buscar/BuscarObjetoTable.html");
			dispatcher.include(request, response);
			
			// receber as movimentações para exibir a tablea
			ArrayList<Movimentacao> movimentações = repMovimentacao.getList(objeto.getNumero());
			
		
			
			int i = 1;
			for(Movimentacao m : movimentações){
				//construção da tabela
				pWriter.println("					<tr>");
				pWriter.println("				<td>");
				pWriter.println(i + ". ");
				pWriter.println("				</td>");
				
				pWriter.println("				<td>");
				pWriter.println(m.getPosto_id());
				pWriter.println("				</td>");
				
				pWriter.println("				<td>");
				pWriter.println(m.getDescricao());
				pWriter.println("				</td>");
				
				pWriter.println("				<td>");
				pWriter.println(m.getData_hora());
				pWriter.println("				</td>");
				
				pWriter.println("					</tr>");
				i++;
			}
		}catch(NumberFormatException e){
			
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
