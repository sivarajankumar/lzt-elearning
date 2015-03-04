package org.lztvn.elearning.dao;

import java.util.List;

import org.lztvn.elearning.entities.Test1;


public interface ITestDao {
	 public Long addTest(Test1 u);
	 public List<Test1> getlistTest();
	 public List<Test1> getlistTestbyUserId(Long userid);
	 public void deleteTest(Long idtset);
	 public void editTest1(Test1 t);
	 public Test1 getTestbyID(Long id);
}
