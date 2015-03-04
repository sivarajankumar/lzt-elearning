package org.lztvn.elearning.service;

import java.util.List;

import org.lztvn.elearning.entities.Course;

public interface ICourseService {
	public Long addCourse(Course c);

	public void deleteCourse(Long idCors);

	public void modifierCourse(Course c);

	public List<Course> listCourse();
	
	public List<Course> listCourseInHome();
	
	public Course getCourse(Long idCors);
	
	public List<Course> listCourseByUserId(Long idUser, int position, int nb_course);
	
	public Long getNbCourseByUserId(Long idUser);
}
