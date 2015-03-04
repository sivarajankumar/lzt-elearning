package org.lztvn.elearning.service;

import java.util.List;

import org.lztvn.elearning.dao.ICategoryDao;
import org.lztvn.elearning.dao.IUserDao;
import org.lztvn.elearning.entities.Category;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CatServiceImpl implements ICategryService {
	private ICategoryDao dao;

	@Override
	public Long addCategory(Category c) {
		// TODO Auto-generated method stub
		return dao.addCategory(c);
	}

	@Override
	public void deleteCat(Long idCat) {
		dao.deleteCat(idCat);
    }

	@Override
	public void modifierCat(Category c) {
		dao.modifierCat(c);
    }

	@Override
	public List<Category> listCat() {
		return dao.listCat();
	}

	@Override
	public Category getCategory(Long idCat) {
		return dao.getCategory(idCat);
	}

	public void setDao(ICategoryDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Category> listCatInHome() {
		// TODO Auto-generated method stub
		return dao.listCatInHome();
	}

}
