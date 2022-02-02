package tech.programmerswe.programmerswebackend.user;

import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 * @author Deepak Bhalode
 *
 */
@Service
public class UserServiceImpl implements UserService {

    private BCryptPasswordEncoder bcryptEncoder;
    private ModelMapper modelMapper;
    private UserRepository userRepository;
 
	public UserServiceImpl (BCryptPasswordEncoder bcryptEncoder, ModelMapper modelMapper, UserRepository userRepository) {
		this.bcryptEncoder = bcryptEncoder;
		this.modelMapper = modelMapper;
		this.userRepository = userRepository;
	}
	
	/**
	 * This method registers the user 
	 */
	@Override
	public void registerUser(UserDetail userDetail) {
		User user = modelMapper.map(userDetail, User.class);
		user.setPassword(bcryptEncoder.encode(userDetail.getPassword()));
		System.out.println(user.toString());
		userRepository.save(user);
	}

	
}