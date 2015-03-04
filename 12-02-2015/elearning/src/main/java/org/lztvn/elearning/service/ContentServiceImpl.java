package org.lztvn.elearning.service;

import java.util.List;

import org.lztvn.elearning.dao.IContentDao;
import org.lztvn.elearning.entities.Content;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class ContentServiceImpl implements IContentService{
    private IContentDao dao;
	

	public IContentDao getDao() {
		return dao;
	}

	@Override
	public Long addContent(Content c) {
		// TODO Auto-generated method stub
		return dao.addContent(c);
	}

	@Override
	public void deleteCon(Long idCon) {
		dao.deleteCon(idCon);
		
	}

	@Override
	public void modifierCon(Content c) {
		dao.modifierCon(c);
		
	}

	@Override
	public Content getContent(Long idCon) {
		// TODO Auto-generated method stub
		return dao.getContent(idCon);
	}
	

	public void setDao(IContentDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Content> listCon() {
		return dao.listCon();
	}

	@Override
	public List<Content> listConType(String typeContent) {
		return dao.listConType(typeContent);
	}
}
