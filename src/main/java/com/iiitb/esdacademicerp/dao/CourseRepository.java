package com.iiitb.esdacademicerp.dao;

import com.iiitb.esdacademicerp.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CourseRepository extends CrudRepository<Course, Long> {

    public Course getCourseByCourseId(long id);

    public ArrayList<Course> getCourseByYear(short year);
}
