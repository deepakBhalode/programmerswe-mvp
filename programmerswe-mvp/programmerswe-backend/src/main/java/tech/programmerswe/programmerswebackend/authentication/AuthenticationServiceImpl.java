package tech.programmerswe.programmerswebackend.authentication;

import java.util.Set;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tech.programmerswe.programmerswebackend.user.User;
import tech.programmerswe.programmerswebackend.user.UserRepository;
import tech.programmerswe.programmerswebackend.utility.LogMessage;

@Service(value = "authenticationService")
public class AuthenticationServiceImpl implements UserDetailsService, AuthenticationService {
	Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private CurrentUser currentUserDetail;
    
    public AuthenticationServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
    	this.userRepository = userRepository;
    	this.modelMapper = modelMapper;
    }
	
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	logger.trace(LogMessage.IN_LOAD_USER_BY_USERNAME);
    	
    	User user = userRepository.findByUserName(username);
		UserDetails userDetail = new org.springframework.security.core.userdetails.User (
				user.getUserName(), user.getPassword(), getAuthority(user)
			);
		setCurrentUserDetail(user);
		
		return userDetail;
	}
	
    /**
     * This method provides the authorities
     * @param user
     * @return
     */
    public Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        
        return authorities;
    }
    
    /**
     * This method sets the current user detail i.e. user who is loggedin 
     * in the system
     * @param user
     */
    public void setCurrentUserDetail(User user) {
    	logger.trace(LogMessage.IN_SET_CURRENT_USER_DETAIL);
    	this.currentUserDetail = modelMapper.map(user, CurrentUser.class);
    }
    
    /**
     * This method provides the current user detail i.e. user who is loggedin 
     * in the system
     * @param user
     */
    public CurrentUser getCurrentUserDetail() {
    	logger.trace(LogMessage.IN_GET_CURRENT_USER_DETAIL);
    	return this.currentUserDetail;
    }
    
}