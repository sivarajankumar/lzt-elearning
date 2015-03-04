package org.lztvn.elearning.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContent;
	private String typeContent;
	@NotEmpty
	@Size(min = 4, max = 30)
	private String title;
	private String description;
	@Lob
	private byte[] photo;
	private String nomPhoto;
	private boolean active;

	public Long getIdContent() {
		return idContent;
	}

	public void setIdContent(Long idContent) {
		this.idContent = idContent;
	}

	public String getTypeContent() {
		return typeContent;
	}

	public void setTypeContent(String typeContent) {
		this.typeContent = typeContent;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Content(String typeContent, String title, String description,
			byte[] photo, String nomPhoto, boolean active) {
		super();
		this.typeContent = typeContent;
		this.title = title;
		this.description = description;
		this.photo = photo;
		this.nomPhoto = nomPhoto;
		this.active = active;
	}

	
}
