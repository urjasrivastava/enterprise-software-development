package com.iiitb.esdacademicerp.service;

import com.iiitb.esdacademicerp.dao.StudentRepository;
import com.iiitb.esdacademicerp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServices
{

    public Student getCurrentlyLoggedInStudent(Authentication authentication)
    {
        Student student=null;
        Object principal= authentication.getAuthorities();
        if(principal instanceof StudentAuthorizationDetail)
        {
            student= ((StudentAuthorizationDetail) principal).getStudent();
        }
        return student;
    }

}
