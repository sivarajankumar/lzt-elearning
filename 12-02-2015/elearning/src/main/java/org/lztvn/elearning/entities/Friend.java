package org.lztvn.elearning.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_friend")
public class Friend implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private long fromUser;
    private long toUser;
    private Boolean status=false;
    private Boolean checked=false;
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public User getUserA() {
		return userA;
	}
	public void setUserA(User userA) {
		this.userA = userA;
	}
	public User getUserB() {
		return userB;
	}
	public void setUserB(User userB) {
		this.userB = userB;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Friend(){
    	super();
    }
    public Friend(Long fromUser,Long toUser){
    	this.setFromUser(fromUser);
    	this.toUser = toUser;
    }
    @ManyToOne
	@JoinColumn(name="fromUser",insertable = false, updatable = false)
	private User userA;
    
    @ManyToOne
	@JoinColumn(name="toUser",insertable = false, updatable = false)
	private User userB;
    
	/**
	 * @return the fromUser
	 */
	public long getFromUser() {
		return fromUser;
	}
	public long getToUser() {
		return toUser;
	}
	public void setToUser(long toUser) {
		this.toUser = toUser;
	}
	/**
	 * @param fromUser the fromUser to set
	 */
	public void setFromUser(long fromUser) {
		this.fromUser = fromUser;
	}

}
