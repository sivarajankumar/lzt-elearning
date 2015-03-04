package org.lztvn.elearning.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("teacher")
public class Teacher extends User{
	private Date dateRegister;

}
