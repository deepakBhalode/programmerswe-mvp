package tech.programmerswe.programmerswebackend.authentication;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.programmerswe.programmerswebackend.utility.Route;
import tech.programmerswe.programmerswebackend.utility.JwtUtility;

@RestController
@RequestMapping(Route.AUTHENTICATE)
public class AuthenticationController {

    @Autowired
	private JwtUtility jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    
    /**
     * This method authenticates the user
     * @param userCredential
     * @return jwtResponse
     */
	@PostMapping(Route.AUTHENTICATE_USER)
	public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody UserCredential userCredential) {
		
		System.out.println("Inside AuthenticateUser API.");
		
		final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		userCredential.getUsername(), userCredential.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        final JwtResponse jwtResponse = new JwtResponse(token);
        
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
	}
	
}