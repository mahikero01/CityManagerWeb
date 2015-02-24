package company.citymanagerweb.helpers;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import company.citymanagerweb.models.DBManager;
import company.citymanagerweb.models.MySQLServerConnectionBehavior;
import company.citymanagerweb.models.ServerConnectionBehavior;

/**
 * Application Lifecycle Listener implementation class DBManagerSetup
 *
 */
@WebListener
public class DBManagerSetup implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBManagerSetup() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    
    private DBManager dbm = null;
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0)  { 
         if ( dbm != null ) {
			if ( dbm.isConnected() ) {
				dbm.closeConnection(false);
			}
		}
         dbm = null;
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce)  { 
        ServletContext sc = sce.getServletContext();
        String uid = sc.getInitParameter("dbuserid");
        String pwd = sc.getInitParameter("dbuserpwd");
        String cat = sc.getInitParameter("dbinitcat");
        
        ServerConnectionBehavior scb = new MySQLServerConnectionBehavior(uid, pwd, cat);
        dbm = new DBManager(scb);
        
        sc.setAttribute("WorldDBManager", dbm);
        
        System.out.println("World DB saved in context");
    }
	
}
