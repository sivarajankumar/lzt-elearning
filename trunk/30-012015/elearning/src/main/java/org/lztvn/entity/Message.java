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
@Table(name="tbl_message")
public class Message{
	/**
	 * 
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private long fromUser;
    private long toUser;
    private String message;
    private Boolean status;
    public Message() {
    	super();
    }
    
    public Message(long fromUser, long toUser, String message) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.message = message;
    }
    @ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="fromUser",referencedColumnName="id",insertable = false, updatable = false)
	private User userA;
    
    @ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="toUser",referencedColumnName="id",insertable = false, updatable = false)
	private User userB;
    
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

	public long getFromUser() {
		return fromUser;
	}

	public void setFromUser(long fromUser) {
		this.fromUser = fromUser;
	}

	public long getToUser() {
		return toUser;
	}

	public void setToUser(long toUser) {
		this.toUser = toUser;
	}

	public String getMessage() {
		return message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	} 
}
