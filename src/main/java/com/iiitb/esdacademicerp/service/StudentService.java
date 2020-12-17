package com.iiitb.esdacademicerp.service;

import com.iiitb.esdacademicerp.dao.StudentRepository;
import com.iiitb.esdacademicerp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentRepository.getStudentByEmail(email);
        if (student == null)
            throw new UsernameNotFoundException("Invalid email or password entered!");
        return new StudentAuthorizationDetail(student);
    }

    /* Add any more Student related services */
}
