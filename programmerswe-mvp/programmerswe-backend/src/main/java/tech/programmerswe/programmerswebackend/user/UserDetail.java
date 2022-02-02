package tech.programmerswe.programmerswebackend.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDetail {

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
	private String password;
	
	@NotBlank
	private Boolean activeStatus;
	
	//constructors
	public UserDetail() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "UserDetail [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", emailAddress=" + emailAddress + ", contact=" + contact + ", userName=" + userName + ", password="
				+ password + ", activeStatus=" + activeStatus + "]";
	}
	
}