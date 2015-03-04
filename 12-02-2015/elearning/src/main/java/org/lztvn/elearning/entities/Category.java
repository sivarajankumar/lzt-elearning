package org.lztvn.elearning.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "category")
public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategory;
	@NotEmpty
	@Size(min = 4, max = 20)
	private String nameCat;
	private String descriptionCat;
	@Lob
	private byte[] photo;
	private String nomPhoto;
	private boolean inHome;
	public boolean isInHome() {
		return inHome;
	}

	public void setInHome(boolean inHome) {
		this.inHome = inHome;
	}

	@OneToMany(mappedBy = "category")
	private Collection<Course> lstCourses;

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCat() {
		return nameCat;
	}

	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}

	public String getDescriptionCat() {
		return descriptionCat;
	}

	public void setDescriptionCat(String descriptionCat) {
		this.descriptionCat = descriptionCat;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public Collection<Course> getLstCourses() {
		return lstCourses;
	}

	public void setLstCourses(Collection<Course> lstCourses) {
		this.lstCourses = lstCourses;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String nameCat, String descriptionCat, byte[] photo,
			String nomPhoto, Boolean inHome) {
		super();
		this.nameCat = nameCat;
		this.descriptionCat = descriptionCat;
		this.photo = photo;
		this.nomPhoto = nomPhoto;
		this.inHome=inHome;
	}

}
