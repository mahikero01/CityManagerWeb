package company.citymanagerweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

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
		
		int authLevel = 1;
		
		HttpSession s = request.getSession();
		s.setAttribute("userName", uid);
		//s.setAttribute("userAuthLevel", authLevel);
		
		if ( remember ) {
			int cookieLife = 3600 * 24 * 7;
			Cookie uidCook = new Cookie("credentials_uid", uid);
			uidCook.setMaxAge(cookieLife);
			response.addCookie(uidCook);
			Cookie pwdCook = new Cookie("credentials_pwd", pwd);
			uidCook.setMaxAge(cookieLife);
			response.addCookie(pwdCook);
		}
		
		if ( authLevel < 1 || uid == null || uid == "" ) {
			response.sendRedirect(
					response.encodeRedirectURL("index_cookies.html"));
		} else {
			response.sendRedirect(
					response.encodeRedirectURL("/CityManagerWeb/destinationpage.do"));
		}	
	}
}
