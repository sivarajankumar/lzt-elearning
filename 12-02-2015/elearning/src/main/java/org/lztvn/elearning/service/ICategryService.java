package org.lztvn.elearning.service;

import java.util.List;

import org.lztvn.elearning.entities.Category;

public interface ICategryService {
	public Long addCategory(Category c);

	public void deleteCat(Long idCat);

	public void modifierCat(Category c);

	public List<Category> listCat();

	public List<Category> listCatInHome();

	public Category getCategory(Long idCat);
}
