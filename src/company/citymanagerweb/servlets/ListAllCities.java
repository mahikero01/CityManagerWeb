package company.citymanagerweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.citymanagerweb.helpers.DBWorldQueries;
import company.citymanagerweb.models.DBManager;
import company.citymanagerweb.models.MySQLServerConnectionBehavior;
import company.citymanagerweb.models.ServerConnectionBehavior;

/**
 * Servlet implementation class ListAllCities
 */
@WebServlet("/listallcities.do")
public class ListAllCities extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllCities() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder("<html><body>");
		DBManager dbm = (DBManager)getServletContext().getAttribute("WorldDBManager");
		
		/*
		String uid = getServletContext().getInitParameter("dbuserid");
		String pwd = getServletContext().getInitParameter("dbuserpwd");
		String cat = getServletContext().getInitParameter("dbinitcat");
		
		ServerConnectionBehavior scb = new MySQLServerConnectionBehavior(uid, pwd, cat);
		System.out.println(scb.getConnectionDetails());
		System.out.println(scb.getConnectionURL());
		
		DBManager dbm = new DBManager(scb);
		*/
		try {
			if ( !dbm.isConnected() ) {
				if ( !dbm.openConnection() ) {
					sb.append("Could not connect to the database");
				} 
			}
			
			sb.append("<table border=1>" 
					+ "<tr><td>ID</td><td>NAME</td><td>COUNTRY_CODE</td>"
					+ "<td>DISTRICT</td><td>POPULATION</td></tr>");
			
			//String query = "SELECT * FROM districts ORDER BY id ASC";
			String query = DBWorldQueries.getCitiesByDistrictByPopulation();
			ResultSet rs = dbm.ExecuteResultSet(query);
			
			while (rs.next())
			{
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String ctry = rs.getString("CountryCode"); 
				String dist = rs.getString("District"); 
				int pop = rs.getInt("Population");
				
				sb.append("<tr><td>" + id + "</td>" 
						+ "<td>" + name + "</td>" 
						+ "<td>" + ctry + "</td>" +
						"<td>" + dist + "</td>" +
						"<td>" + pop + "</td></tr>");
			}
			
			sb.append("</table>");
			
		} catch (Exception e) {
			sb.append("<h1>ERROR: " + e.getMessage() + "</h1>");
		}
		sb.append("</body></html>");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(sb);
	}

}
