package com.iiitb.esdacademicerp.dao;

import com.iiitb.esdacademicerp.model.Course;
import com.iiitb.esdacademicerp.model.Prerequisite;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PrerequisiteRepository extends CrudRepository<Prerequisite, Long> {

    public ArrayList<Prerequisite> getPrerequisiteByCourse(Course course);

    public ArrayList<Prerequisite> getPrerequisiteByCourseIn(ArrayList<Course> course);

    public ArrayList<Prerequisite> getAllBy();

}
