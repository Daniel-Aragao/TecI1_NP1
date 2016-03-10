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
 * Servlet implementation class BaDaCorreios
 */
@WebServlet("/BaDaCorreios")
public class BaDaCorreios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BaDaCorreios() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pWriter = response.getWriter();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("topo.html");
		dispatcher.include(request, response);
		
		dispatcher = request.getRequestDispatcher("Index.html");
		dispatcher.include(request, response);
		
		dispatcher = request.getRequestDispatcher("rodape.html");
		dispatcher.include(request, response);
		
		pWriter.close();		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
