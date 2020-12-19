package com.iiitb.esdacademicerp.dao;

import com.iiitb.esdacademicerp.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("SELECT student FROM Student student WHERE student.email=?1")
    public Student getStudentByEmail(String email);

    /* Add any more Student related queries / insertions / deletion etc */

}
