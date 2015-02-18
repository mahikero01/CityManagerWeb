package company.citymanagerweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletParameters
 */
@WebServlet("/ServletParameters")
public class ServletParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletParameters() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String secretCode = getServletConfig().getInitParameter("secretCode");
		
		String dbURL = getServletContext().getInitParameter("dbURL");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String outString = String.format("Secret Code: %s\tDB URL: %s\n"
				, secretCode
				, dbURL);
		out.println("<html><body><h3>" + outString  + "</h3></body></html>");
	}

}
