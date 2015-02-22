package company.citymanagerweb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLoginCookies
 */
@WebServlet("/userlogincookies.do")
public class UserLoginCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("userID");
		String pwd = request.getParameter("pwd");
		boolean remember = false;
		
		if (request.getParameter("remember") != null) {
			String rememberMe = request.getParameter("remember");
			if (rememberMe.equalsIgnoreCase("on")) {
				remember = true;
			}
		}
	}

}
