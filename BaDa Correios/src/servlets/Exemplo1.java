package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exemplo1
 */
@WebServlet("/Exemplo1")
public class Exemplo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		RequestDispatcher r = request.getRequestDispatcher("topo.html");
		r.include(request, response);
		
		out.println("Esse cointeúdo é dinamitco");
		
		r = request.getRequestDispatcher("rodape.html");
		r.include(request, response);
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
