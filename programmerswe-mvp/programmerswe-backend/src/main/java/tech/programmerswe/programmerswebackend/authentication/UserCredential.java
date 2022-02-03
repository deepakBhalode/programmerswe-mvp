package tech.programmerswe.programmerswebackend.authentication;

/**
 * @author Deepak Bhalode
 *
 */
public class UserCredential {

	//properties
	private String username;
	private String password;

	//getter and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	
}