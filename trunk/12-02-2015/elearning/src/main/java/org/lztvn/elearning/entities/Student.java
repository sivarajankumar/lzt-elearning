package org.lztvn.elearning.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue("student")
public class Student extends User {
	@NotEmpty
	private Date dateEnroll;

	public Date getDateEnroll() {
		return dateEnroll;
	}

	public void setDateEnroll(Date dateEnroll) {
		this.dateEnroll = dateEnroll;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Date dateEnroll) {
		super();
		this.dateEnroll = dateEnroll;
	}


	
	
	
	
}
