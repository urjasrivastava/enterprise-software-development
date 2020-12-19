package com.iiitb.esdacademicerp.dao;

import com.iiitb.esdacademicerp.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    public Course getCourseByCourseId(long id);

    @Query("select c from Course c where c.year=?1")
    public ArrayList<Course> getCourseByYear(short year);
}
