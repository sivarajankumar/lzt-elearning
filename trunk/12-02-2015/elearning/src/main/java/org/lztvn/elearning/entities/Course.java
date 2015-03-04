package org.lztvn.elearning.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "course")
public class Course implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCourse;
	@NotEmpty
	@Size(min = 4, max = 30)
	private String titleCourse;
	@NotEmpty
	@Size(min = 4, max = 1500)
	private String description;
	private Date dateCreation;
	
	private Date dateStart;
	
	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	private Integer minutes;
	@Lob
	
	private String photoStr;
	
	public String getPhotoStr() {
		return photoStr;
	}

	public void setPhotoStr(String photoStr) {
		this.photoStr = photoStr;
	}

	private byte[] photo;
	private String nomPhoto;
	@NotEmpty
	@URL(message="Your video link is not valid")
	private String videoLink;
	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	private boolean inHome;
	public boolean isInHome() {
		return inHome;
	}

	public void setInHome(boolean inHome) {
		this.inHome = inHome;
	}

	@ManyToOne
	@JoinColumn(name="idUser")
	private User teacher;
	
	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	@OneToMany(mappedBy = "course")
	private Collection<StudenCourse> studentCourseLine;
	@ManyToOne()
	@JoinColumn(name = "idCategory")
	private Category category;

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public String getTitleCourse() {
		return titleCourse;
	}

	public void setTitleCourse(String titleCourse) {
		this.titleCourse = titleCourse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Collection<StudenCourse> getStudentCourseLine() {
		return studentCourseLine;
	}

	public void setStudentCourseLine(Collection<StudenCourse> studentCourseLine) {
		this.studentCourseLine = studentCourseLine;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String titleCourse, String description, Date dateCreation,
			Integer minutes, Boolean inHome, Date dateStart, String videoLink, String photoStr) {
		super();
		this.titleCourse = titleCourse;
		this.description = description;
		this.dateCreation = dateCreation;
		this.minutes = minutes;
		this.inHome = inHome;
		this.dateStart=dateStart;
		this.videoLink=videoLink;
		this.photoStr= photoStr;
	}

}
