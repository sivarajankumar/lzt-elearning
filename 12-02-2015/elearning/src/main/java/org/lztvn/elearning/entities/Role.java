package org.lztvn.elearning.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_role")
public class Role{
	/**
	 * 
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	@Column(unique=true)
    private String roleName;
    private String decription;
    @Column(unique=true)
    private int value;
    
    public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Role(){
    	super();
    }
    public Role(String roleString,String descrString){
    	this.roleName = roleString;
    	this.decription = descrString;
    }
    
    @OneToMany(mappedBy="role")
    private Collection<UserRole> userRoles;
	public Collection<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Collection<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
}
