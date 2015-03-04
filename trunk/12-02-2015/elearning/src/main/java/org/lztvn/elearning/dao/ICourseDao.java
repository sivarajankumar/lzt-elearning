package org.lztvn.elearning.dao;

import java.util.List;

import org.lztvn.elearning.entities.Course;

public interface ICourseDao {
	public Long addCourse(Course c);

	public void deleteCourse(Long idCors);

	public void modifierCourse(Course c);

	public List<Course> listCourse();
	
	public List<Course> listCourseByUserId(Long idUser, int position, int nb_course);
	
	public List<Course> listCourseInHome();

	public Course getCourse(Long idCors);
	
	public Long getNbCourseByUserId(Long idUser);
	
}
