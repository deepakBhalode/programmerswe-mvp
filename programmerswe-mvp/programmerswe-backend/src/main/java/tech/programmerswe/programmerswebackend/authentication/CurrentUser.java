package tech.programmerswe.programmerswebackend.authentication;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * This class comprises of the user detail who is logged in the system
 * @author Deepak Bhalode
 *
 */
public class CurrentUser {

	//properties
	private Long userId;

	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String role;
	
	@Email
	private String emailAddress;
	
	@NotBlank
	private String contact;
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private Boolean activeStatus;
	
	//constructors
	public CurrentUser() {
		super();
		this.setActiveStatus(false);
	}
	
	//getter and setters
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}	

	//to string 
	@Override
	public String toString() {
		return "CurrentUser [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", role="
				+ role + ", emailAddress=" + emailAddress + ", contact=" + contact + ", userName=" + userName
				+ ", activeStatus=" + activeStatus + "]";
	}
	
}