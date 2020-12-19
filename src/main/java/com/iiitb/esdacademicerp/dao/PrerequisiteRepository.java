package com.iiitb.esdacademicerp.dao;

import com.iiitb.esdacademicerp.model.Course;
import com.iiitb.esdacademicerp.model.Prerequisite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface PrerequisiteRepository extends CrudRepository<Prerequisite, Long> {

    public ArrayList<Prerequisite> getPrerequisiteByCourse(Course course);

    @Query("select p.prerequisite.courseId from Prerequisite p where p.course.courseId=?1")
    public ArrayList<Long> getPrerequisiteByCourseId(Long id);



}
