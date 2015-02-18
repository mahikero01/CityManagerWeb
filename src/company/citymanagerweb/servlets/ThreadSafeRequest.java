package company.citymanagerweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThreadSafeRequest
 */
@WebServlet("/threadsaferequest.do")
public class ThreadSafeRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThreadSafeRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder msg = new StringBuilder("");
		msg.append("<html><body>");
		int currentSeed = (int)getServletContext().getAttribute("currentSeedValue");
		msg.append(String.format("Attribute Retrieved Value: %d<br>", currentSeed));
		currentSeed *= 2;
		
		request.setAttribute("currentSeedValue", currentSeed);
		
		getServletContext().setAttribute("currentSeedValue", currentSeed);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		//getServletContext().setAttribute("currentSeedValue", currentSeed);
		
		
		currentSeed = (int)request.getAttribute("currentSeedValue");
		msg.append(String.format("Request Attribute retrieved value after process: %d<br>"
				, currentSeed));
		
		currentSeed = (int)getServletContext().getAttribute("currentSeedValue");
		msg.append(String.format("Context Attribute retrieved value after process: %d<br>"
				, currentSeed));
		
		msg.append("</body></html>");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(msg);
	}

}
