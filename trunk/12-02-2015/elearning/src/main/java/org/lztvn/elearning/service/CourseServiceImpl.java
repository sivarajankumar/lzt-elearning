package org.lztvn.elearning.service;

import java.util.List;

import org.lztvn.elearning.dao.ICourseDao;
import org.lztvn.elearning.entities.Category;
import org.lztvn.elearning.entities.Course;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CourseServiceImpl implements ICourseService {
	ICourseDao dao;

	@Override
	public Long addCourse(Course c) {
		return dao.addCourse(c);
	}

	public void deleteCourse(Long idCors) {
		dao.deleteCourse(idCors);
	}

	@Override
	public void modifierCourse(Course c) {
		dao.modifierCourse(c);
	}

	@Override
	public List<Course> listCourse() {
		return dao.listCourse();
	}

	@Override
	public Course getCourse(Long idCors) {
		return dao.getCourse(idCors);
	}

	public void setDao(ICourseDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Course> listCourseInHome() {
		return dao.listCourseInHome();
	}

	@Override
	public List<Course> listCourseByUserId(Long idUser, int position, int nb_course) {

		return dao.listCourseByUserId(idUser, position, nb_course);
	}

	@Override
	public Long getNbCourseByUserId(Long idUser) {
		return dao.getNbCourseByUserId(idUser);
	}
}
