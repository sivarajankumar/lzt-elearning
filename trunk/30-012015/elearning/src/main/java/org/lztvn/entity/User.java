package org.lztvn.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="User")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique=true, nullable=false)
    private long id;
    private String firstName;
    private String lastName;
    private String password;

    public User() {
    	super();
    	this.messageFromMe = new ArrayList<Message>();
    	this.messageToMe = new ArrayList<Message>();
    }

    public User(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.messageFromMe = new ArrayList<Message>();
    	this.messageToMe = new ArrayList<Message>();
    }
    @OneToMany(cascade = CascadeType.ALL,mappedBy="user")
    private List<UserRole> userRoles;
    public List<UserRole> getUserRoles() {
		return userRoles;
	}
    @OneToMany(cascade = CascadeType.ALL,mappedBy="userA")
    private List<Friend> friendFromMe;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy="userB")
    private List<Friend> friendToMe;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy="userB")
    private List<Message> messageToMe;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy="userA")
    private List<Message> messageFromMe;
    
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Friend> getFriendFromMe() {
		return friendFromMe;
	}

	public void setFriendFromMe(List<Friend> friendFromMe) {
		this.friendFromMe = friendFromMe;
	}

	public List<Friend> getFriendToMe() {
		return friendToMe;
	}

	public void setFriendToMe(List<Friend> friendToMe) {
		this.friendToMe = friendToMe;
	}

	public List<Message> getMessageToMe() {
		return messageToMe;
	}

	public void setMessageToMe(List<Message> messageToMe) {
		this.messageToMe = messageToMe;
	}

	public List<Message> getMessageFromMe() {
		return messageFromMe;
	}

	public void setMessageFromMe(List<Message> messageFromMe) {
		this.messageFromMe = messageFromMe;
	}
}
