package org.lztvn.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_user_role")
public class UserRole {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    private long userId;
	private long roleId;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="userId",referencedColumnName="id",insertable = false, updatable = false)
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="roleId",referencedColumnName="id",insertable = false, updatable = false)
	private Role role;
	
	public UserRole() {
	    	super();
	    }
	public UserRole(long userId,long roleId){
		this.roleId=roleId;
		this.userId=userId;
	}
	
    public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
