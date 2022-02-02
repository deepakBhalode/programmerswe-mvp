package tech.programmerswe.programmerswebackend.authentication;

import java.util.Set;
import java.util.HashSet;
import org.springframework.stereotype.Service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tech.programmerswe.programmerswebackend.user.User;
import tech.programmerswe.programmerswebackend.user.UserRepository;

@Service(value = "authenticationService")
public class AuthenticationServiceImpl implements UserDetailsService, AuthenticationService {

    private UserRepository userRepository;
	
    public AuthenticationServiceImpl(UserRepository userRepository) {
    	this.userRepository = userRepository;
    }
	
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		UserDetails userDetail = new org.springframework.security.core.userdetails.User (
				user.getUserName(), user.getPassword(), getAuthority(user)
			);
		
		return userDetail;
	}
	
	public Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        return authorities;
    }
    
}