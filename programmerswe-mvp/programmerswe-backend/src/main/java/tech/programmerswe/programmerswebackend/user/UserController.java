package tech.programmerswe.programmerswebackend.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.programmerswe.programmerswebackend.utility.Route;

/**
 * 
 * @author Deepak Bhalode
 *
 */
@RestController
@RequestMapping(Route.USER)
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * This api handles the user registration 
	 * @param userDetail
	 */
	@PostMapping(Route.REGISTER)
	public void registerUser(@RequestBody UserDetail userDetail) {	
    	userService.registerUser(userDetail);
	}
	
	@PreAuthorize("hasRole('USER')")
    @GetMapping("/userping")
    public String userPing(){
        return "Any User Can Read This";
    }
    
	@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminPing(){
        return "Only Admins Can Read This";
    }
}