package com.iiitb.esdacademicerp.dao;

import com.iiitb.esdacademicerp.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

    public Course getCourseByCourseId(long id);
}
