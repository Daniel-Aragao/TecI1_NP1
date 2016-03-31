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

		if (busca != null) {
			dispatcher = request.getRequestDispatcher("Paginas/Buscar/BuscarObjetoTable.html");
			dispatcher.include(request, response);

			pWriter.println("					<tr>");
			pWriter.println("				<td>");
			pWriter.println(0 + ". ");
			pWriter.println("				</td>");

			pWriter.println("				<td>");
			pWriter.println("Teste");
			pWriter.println("				</td>");

			pWriter.println("				<td>");
			pWriter.println("Teste");
			pWriter.println("				</td>");

			pWriter.println("				<td>");
			pWriter.println("Teste");
			pWriter.println("				</td>");

			pWriter.println("					</tr>");

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
