package tech.programmerswe.programmerswebackend.utility;

/**
 * This class comprises of Log Messages
 * @author Deepak Bhalode
 *
 */
public class LogMessage {

	private LogMessage() {
		super();
	}
	
	/* ======================== TRACE LEVEL LOGS ======================== */
	public static final String IN_AUTHENTICATE_USER_API = "Inside authenticateUser API";
	public static final String IN_LOAD_USER_BY_USERNAME = "Inside loadUserByUsername service";
	public static final String IN_SET_CURRENT_USER_DETAIL = "Inside setCurrentUserDetail service.";
	public static final String IN_GET_CURRENT_USER_DETAIL = "Inside getCurrentUserDetail service.";
	
	
	/* ======================== ERROR LEVEL LOGS ======================== */
	public static final String ERR_INVALID_CRDENTIAL = "Invalid Credentials. Please provide valid username or password.";
	
	
}