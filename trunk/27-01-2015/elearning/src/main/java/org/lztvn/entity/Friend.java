package org.lztvn.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    private Boolean status;
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
    @ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="fromUser",referencedColumnName="id",insertable = false, updatable = false)
	private User userA;
    
    @ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="toUser",referencedColumnName="id",insertable = false, updatable = false)
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
