package org.lztvn.elearning.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.CascadeType;

@Entity
@Table(name = "user")
public class User implements Serializable{
	/**
	 * abc
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	@Size(min = 4, max = 30, message="your username must be between 4 and 30")
	private String username;
	@NotEmpty
	@Size(min = 4, max = 30)
	private String password;
	@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE)
	private List<Test1> test;
	private String description;
	public String getDescription() {
		return description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String typeUser;
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	private String photo;
	
	@OneToMany(mappedBy="teacher",cascade=CascadeType.REMOVE)
	private Collection<Course> lstCourses;
	

	@NotEmpty
	@Size(min = 4, max = 30)
	private String firstName;
	@NotEmpty
	@Size(min = 4, max = 30)

	private String lastName;
	@Size(min = 6, message="your email is too short")
	@Email
	private String email;

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	private boolean active;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private Date birthdayDate;
	@NotEmpty
	@Size(min = 4, max = 30)
	private String address;
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Date getBirthdayDate() {
		return birthdayDate;
	}
	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE)
    private Collection<UserRole> userRoles;
    @OneToMany(mappedBy="userA")
    private Collection<Friend> friendFromMe;
    
    @OneToMany(mappedBy="userB")
    private Collection<Friend> friendToMe;
    
    @OneToMany(mappedBy="userB")
    private Collection<Message> messageToMe;
    
    public Collection<Course> getLstCourses() {
		return lstCourses;
	}
	public void setLstCourses(Collection<Course> lstCourses) {
		this.lstCourses = lstCourses;
	}
	public Collection<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Collection<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public Collection<Friend> getFriendFromMe() {
		return friendFromMe;
	}
	public void setFriendFromMe(Collection<Friend> friendFromMe) {
		this.friendFromMe = friendFromMe;
	}
	public Collection<Friend> getFriendToMe() {
		return friendToMe;
	}
	public void setFriendToMe(Collection<Friend> friendToMe) {
		this.friendToMe = friendToMe;
	}
	public Collection<Message> getMessageToMe() {
		return messageToMe;
	}
	public void setMessageToMe(Collection<Message> messageToMe) {
		this.messageToMe = messageToMe;
	}
	public Collection<Message> getMessageFromMe() {
		return messageFromMe;
	}
	public void setMessageFromMe(Collection<Message> messageFromMe) {
		this.messageFromMe = messageFromMe;
	}
	@OneToMany(mappedBy="userA")
    private Collection<Message> messageFromMe;
//	public Collection<Course> getLstCourses() {
//		return lstCourses;
//	}
//	public void setLstCourses(Collection<Course> lstCourses) {
//		this.lstCourses = lstCourses;
//	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password,
			String firstName, String lastName, Date birthdayDate, String address,  String email, boolean active, String typeUser, String description, String photo) {
		super();
		this.username = username;
		this.password = password;
	    this.firstName = firstName;
		this.lastName = lastName;
		this.birthdayDate = birthdayDate;
		this.address = address;
	    this.photo=photo;
		this.email=email;
		this.active=active;
		this.typeUser = typeUser;
		this.description=description;
	}	
}
