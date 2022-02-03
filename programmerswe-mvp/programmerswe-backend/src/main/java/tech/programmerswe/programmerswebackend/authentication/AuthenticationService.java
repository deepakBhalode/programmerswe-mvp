package tech.programmerswe.programmerswebackend.authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthenticationService {

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

	CurrentUser getCurrentUserDetail();
	
}