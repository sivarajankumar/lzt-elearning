package org.lztvn.elearning.service;

import java.util.List;

import org.lztvn.elearning.entities.Content;

public interface IContentService {
	public Long addContent(Content c);

	public void deleteCon(Long idCon);

	public void modifierCon(Content c);

	public Content getContent(Long idCon);
	
	public List<Content> listCon();
	
	public List<Content> listConType(String typeContent);
}
