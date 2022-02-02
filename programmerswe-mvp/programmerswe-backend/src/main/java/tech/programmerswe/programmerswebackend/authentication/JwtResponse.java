package tech.programmerswe.programmerswebackend.authentication;

public class JwtResponse {

	//properties
	private String token;

	//constructor
	public JwtResponse(String token){
        this.token = token;
    }

	//getter and setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
	
}