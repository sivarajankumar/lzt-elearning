package org.lztvn.elearning.service;

import java.util.List;

import org.lztvn.elearning.dao.ITestDao;
import org.lztvn.elearning.entities.Test1;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class TestServiceImpl implements ITestService{
    ITestDao dao;
	public ITestDao getDao() {
		return dao;
	}
	public void setDao(ITestDao dao) {
		this.dao = dao;
	}
	@Override
	public Long addTest(Test1 u) {
		// TODO Auto-generated method stub
		return dao.addTest(u);
	}
	@Override
	public List<Test1> getlistTest() {
		// TODO Auto-generated method stub
		return dao.getlistTest();
	}

	public List<Test1> getlistTestbyId(Long userId) {
		// TODO Auto-generated method stub
		return dao.getlistTestbyUserId(userId);
	}
	public void editTest1(Test1 t){
		dao.editTest1(t);
	}
	public void deleteTest(Long idtset){
		dao.deleteTest(idtset);
	}

	 public Test1 getTestbyID(Long id){
		 return dao.getTestbyID(id);
	 }
}
