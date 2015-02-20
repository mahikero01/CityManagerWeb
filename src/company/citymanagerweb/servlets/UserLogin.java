package company.citymanagerweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/userlogin.do")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = "authorizeduser";
		int authLevel = 1;
		
		HttpSession s = request.getSession();
		s.setAttribute("userName", uid);
		s.setAttribute("userAuthLevel", authLevel);
		
		if ( authLevel < 1 || uid == null || uid == "" ) {
			response.sendRedirect("Login.html");
		} else {
			response.sendRedirect("/CityManagerWeb/destinationpage.do");
		}
	}

}
