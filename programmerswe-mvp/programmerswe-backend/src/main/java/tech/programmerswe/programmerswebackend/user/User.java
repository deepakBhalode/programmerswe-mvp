package tech.programmerswe.programmerswebackend.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_user")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User {

	//properties
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;

	@NotBlank
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank
	@Column(name="user_role")
	private String role;

	@Email
	@Column(name="email_address")
	private String emailAddress;
	
	@NotBlank
	@Length(min = 10, max = 10)
	@Column(name="contact")
	private String contact;
	
	@NotBlank
	@Column(name="user_name")
	private String userName;
	
	@NotBlank
	@Column(name="password")
	private String password;
	
	@Column(name="is_active")
	private Boolean activeStatus;
	
	//constructors
	public User() {
		super();
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
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", emailAddress=" + emailAddress + ", contact=" + contact + ", userName=" + userName + ", password="
				+ password + ", activeStatus=" + activeStatus + "]";
	}

}