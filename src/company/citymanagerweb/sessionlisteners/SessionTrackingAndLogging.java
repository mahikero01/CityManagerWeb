package company.citymanagerweb.sessionlisteners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class SessionTrackingAndLogging
 *
 */
@WebListener
public class SessionTrackingAndLogging implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public SessionTrackingAndLogging() {
    	//instantiate log
    }

    /*
     * NOTE: as these are listeners, and we are simulating logging, 
     *       the attribute value will require a valid 'toString()' on the objects
     *       as we aren't going to know what the object actually is (we could
     *       instanceof and assign each to be more specific if we wanted).
     */
	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent hsbe) {
    	//attribute removed from session
    	System.out.printf("Attribute Removed from session: %s\t%s\n"
    			, hsbe.getName()
    			, hsbe.getValue());
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent hsbe) {
        //attribute added to session
    	System.out.printf("Attribute Added to session: %s\t%s\n"
    			, hsbe.getName()
    			, hsbe.getValue());
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent hsbe) {
        //attribute updated in session
    	System.out.printf("Attribute Replaced in session: %s\t%s\n"
    			, hsbe.getName()
    			, hsbe.getValue());
    }
	
}
