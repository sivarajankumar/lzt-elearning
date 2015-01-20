package org.lztvn.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_role")
public class Role {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String roleName;
    private String decription;
    
    public Role(){
    	super();
    }
    public Role(String roleString,String descrString){
    	this.roleName = roleString;
    	this.decription = descrString;
    }
    
    @OneToMany(mappedBy="role")
    private List<UserRole> userRoles;
	public List<UserRole> getUserRoles() {
		return userRoles;
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
