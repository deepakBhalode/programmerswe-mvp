package tech.programmerswe.programmerswebackend.authentication;

/**
 * This class comprises of the current loggedin user details 
 * as well as the access token associated with it.
 * @author Deepak Bhalode
 *
 */
public class JwtResponse {

	//properties
	private CurrentUser currentUserDetail;
	private String token;

	//constructor
	public JwtResponse(String token, CurrentUser currentUserDetail){
        this.token = token;
        this.currentUserDetail = currentUserDetail;
    }

	//getter and setter
	public CurrentUser getCurrentUserDetail() {
		return currentUserDetail;
	}

	public void setCurrentUserDetail(CurrentUser currentUserDetail) {
		this.currentUserDetail = currentUserDetail;
	}
	
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
	
}