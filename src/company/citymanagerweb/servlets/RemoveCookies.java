package company.citymanagerweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveCookies
 */
@WebServlet("/removecookies.do")
public class RemoveCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Cookie[] MyCookies = request.getCookies();
		
		if (MyCookies != null && MyCookies.length > 0 ) {
			for ( Cookie c : MyCookies ) {
				if ( c.getName().toLowerCase().contains("credentials") ) {
					c.setMaxAge(0);
					response.addCookie(c);
				}
			}
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h3>Cookies Expired</h3></body></html>");
	}
}
