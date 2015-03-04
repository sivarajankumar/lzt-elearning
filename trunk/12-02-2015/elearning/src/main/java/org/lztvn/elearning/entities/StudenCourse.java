package org.lztvn.elearning.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudenCourse implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStudentCourse;
	@ManyToOne
	@JoinColumn(name="idStudent")
	private Student student;
	@ManyToOne
	@JoinColumn(name="idCourse")
	private Course course;
	private Date dateEnrollforCourse;
	private float mark;
	public Long getIdStudentCourse() {
		return idStudentCourse;
	}
	public void setIdStudentCourse(Long idStudentCourse) {
		this.idStudentCourse = idStudentCourse;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Date getDateEnrollforCourse() {
		return dateEnrollforCourse;
	}
	public void setDateEnrollforCourse(Date dateEnrollforCourse) {
		this.dateEnrollforCourse = dateEnrollforCourse;
	}
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
	public StudenCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudenCourse(Date dateEnrollforCourse, float mark) {
		super();
		this.dateEnrollforCourse = dateEnrollforCourse;
		this.mark = mark;
	}
	
	
	
	
}
