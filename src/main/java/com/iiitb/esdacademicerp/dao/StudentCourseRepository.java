package com.iiitb.esdacademicerp.dao;

import com.iiitb.esdacademicerp.model.Student;
import com.iiitb.esdacademicerp.model.StudentCourse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentCourseRepository extends CrudRepository<StudentCourse, Long> {

    @Query("SELECT student_courses FROM StudentCourse student_courses WHERE student_courses.student.studentId=?1")
    // @Query("SELECT student FROM Student student WHERE student.email=?1")
    public List<StudentCourse> getStudentCourseByStudent(Student student);
}
