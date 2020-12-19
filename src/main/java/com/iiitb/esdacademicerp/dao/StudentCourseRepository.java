package com.iiitb.esdacademicerp.dao;

import com.iiitb.esdacademicerp.model.Student;
import com.iiitb.esdacademicerp.model.StudentCourse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface StudentCourseRepository extends CrudRepository<StudentCourse, Long> {

    public ArrayList<StudentCourse> getStudentCourseByStudent(Student student);
}
