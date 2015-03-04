package org.lztvn.elearning.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "Test1")
public class Test1 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long id;
	
	
	@NotEmpty
	private String title;
	
	private String description;
	@Column
	private String photo;
	@Column
	private String videolink;
	
	
	@OneToMany(mappedBy="test",cascade=CascadeType.REMOVE)
	private List<Question> quest;
	
	
	@ManyToOne
	@JoinColumn(name = "IdUser")
	private User user;
	
	
	
	
	public Test1(String title, String description, String photo, String links) {
		super();
		this.title = title;
		this.description = description;
		this.photo = photo;
		this.videolink = links;
	}
	public Test1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getVideolink() {
		return videolink;
	}
	public void setVideolink(String videolink) {
		this.videolink = videolink;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
