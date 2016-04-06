package Server;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.net.Socket;

/**
 * This class groups together all handlers for all types of packets.  All the handlers have passed
 * the caller Respond instance and the request in JSON java format.
 * @version     1.0.0
 * @university  University of Illinois at Chicago
 * @course      CS342 - Software Design
 * @category    Project #04 - Ninja: Chat Application
 * @package     Server
 * @author      Rafael Grigorian
 * @author      Byambasuren Gansukh
 * @license     GNU Public License <http://www.gnu.org/licenses/gpl-3.0.txt>
 */
public class Handler {

	/**
	 * This data member holds a reference to the parent Server instance that is the caller to this
	 * instance.  It is stored, because we want to user many useful function from that class.
	 * @var     Server          parent              The Server instance that spawned this instance
	 */
	private Server parent;

	/**
	 * This constructor simply saves the parent reference and thats all it does.  It also
	 * initializes the data base instances.
	 * @param   Server          parent              The Server instance that spawned this instance
	 */
	public Handler ( Server parent ) {
		// Save the parent reference internally
		this.parent = parent;
	}

	/**
	 *
	 */
	protected void handleLogin ( Respond callback, JSONObject request ) {
		System.out.println ( "[LOGIN]\t\t" + request.toString () );
		callback.write ( this.failTemplate ( "login", "Failed to login!" ).toString () );
		// callback.write ( this.parent.clientsOnline ().toString () );
	}

	/**
	 *
	 */
	protected void handleCreate ( Respond callback, JSONObject request ) {
		System.out.println ( "[CREATE]\t\t" + request.toString () );
		callback.write ( this.failTemplate ( "create", "Failed to create account!" ).toString () );
	}

	/**
	 *
	 */
	protected void handleMessage ( Respond callback, JSONObject request ) {
		System.out.println ( "[MESSAGE]\t" + request.toString () );
		callback.write ( this.failTemplate ( "message", "Failed to send message!" ).toString () );
	}

	/**
	 *
	 */
	protected void handleLogout ( Respond callback, JSONObject request ) {
		System.out.println ( "[LOGOUT]\t\t" + request.toString () );
		callback.write ( this.failTemplate ( "logout", "Failed to logout!" ).toString () );
	}

	/**
	 * This function creates a failed json object and uses the passed type and message and returns
	 * the JSONObject.  Please note that you can easily turn this to a json string by using the
	 * toString () function.
	 * @param   String          type                The type of response it will be
	 * @param   String          message             The error message to include
	 * @return  JSONObject                          A JSON java object with populated information
	 */
	private JSONObject failTemplate ( String type, String message ) {
		// Initialize a json object
		JSONObject json = new JSONObject ();
		// Put in the key pair values
		json.put ( "type", type );
		json.put ( "status", "fail" );
		json.put ( "message", message );
		// Return the JSON object
		return json;
	}

}