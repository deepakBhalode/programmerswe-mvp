package tech.programmerswe.programmerswebackend.authentication;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.programmerswe.programmerswebackend.utility.Route;
import tech.programmerswe.programmerswebackend.utility.JwtUtility;
import tech.programmerswe.programmerswebackend.utility.LogMessage;

/**
 * This class comprises of API to handle user authentication.
 * @author Deepak Bhalode
 *
 */
@RestController
@RequestMapping(Route.AUTHENTICATE)
public class AuthenticationController {
	Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    
	private AuthenticationManager authenticationManager;
	private AuthenticationService authenticationService;
    private JwtUtility jwtTokenUtil;
    
    //constructor
    public AuthenticationController (
    		AuthenticationService authenticationService,
    		AuthenticationManager authenticationManager,
    		JwtUtility jwtTokenUtil
    ) {
    	this.authenticationService = authenticationService;
    	this.authenticationManager = authenticationManager;
    	this.jwtTokenUtil = jwtTokenUtil;
    }
    
    /**
     * This method authenticates the user and returns object comprising of user 
     * basic details and generated JWT token. 
     * It throws exception if user name or password is invalid.
     * @param userCredential
     * @return jwtResponse
     */
	@PostMapping(Route.AUTHENTICATE_USER)
	public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody UserCredential userCredential) throws Exception {
		logger.trace(LogMessage.IN_AUTHENTICATE_USER_API);
		
		Authentication authentication;
		try {
			authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                		userCredential.getUsername(), userCredential.getPassword()
	                )
	        );
		} catch(BadCredentialsException exp) {
			logger.error(LogMessage.ERR_INVALID_CRDENTIAL);
			throw new Exception(LogMessage.ERR_INVALID_CRDENTIAL);
		}
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		CurrentUser currentUserDetail = authenticationService.getCurrentUserDetail();
		final String generatedToken = jwtTokenUtil.generateToken(authentication);
        final JwtResponse jwtResponse = new JwtResponse(generatedToken, currentUserDetail);
		
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
	}
	
}