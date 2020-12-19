package com.iiitb.esdacademicerp.dao;

import com.iiitb.esdacademicerp.model.Course;
import com.iiitb.esdacademicerp.model.Student;
import com.iiitb.esdacademicerp.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, Long> {

    public ArrayList<StudentCourse> getStudentCourseByStudent(Student student);
    @Query("select s.course.courseId from StudentCourse s where s.student.studentId=?1")
    public ArrayList<Long> getStudentCoursesByStudentId(long id);
    @Query("select s from StudentCourse s where s.student.studentId=?1 and s.course.courseId=?2")
    public StudentCourse getStudentCoursesByStudentIdAndCourseId(long studentId, long courseId);

}
