package com.iiitb.esdacademicerp.service;

import com.iiitb.esdacademicerp.dao.CourseRepository;
import com.iiitb.esdacademicerp.dao.PrerequisiteRepository;
import com.iiitb.esdacademicerp.dao.StudentCourseRepository;
import com.iiitb.esdacademicerp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

// TODO : Work on this class please!
@Service
public class CourseEnrollmentService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private PrerequisiteRepository prerequisiteRepository;

    /* TODO : Function that returns the course enrollment data to the controller
    Return type: ArrayList<HashMap<String, ?>>
    Contents of the map: (For a course with pre-requisite)
    {
        "course_id" : 8,
        "name" : "Natural Language Processing"
        "code" : "AI829",
        "faculty" : "Prof. G Srinivasa",
        "description" : "blah blah blah",
        "prerequisite" : [
            {
                "name" : "Machine Learning",
                "code" : "AI101"
            },
            {
                "name" : "Mathematics for Machine Leaning",
                "code" : "AI102"
            }
         ], // If the course has no prerequisites then let this `prerequisite` array be empty
        "total_credits" : 4,
        "available_seats" : 100,
        "is_enrolled" : true // true -> Student is currently enrolled, false -> not enrolled
    }


     */
    // The student object will be sent by the controller
    public ArrayList<HashMap<String, ?>> getCourseEnrollmentData(Student student) {

        return null;
    }

    /* TODO: Function that enroll/de-enrolls the student from a course

        It takes a ArrayList<HashMap<String, ?> as the input
        Contents of the map
        {
            "course_id" : 8,
            "enroll" : true // true -> Student wants to enroll, false -> doesn't want to enroll (de-enroll)
            // NOTE : You'll have to verify whether student is already enrolled or not we can change this logic if needed

        }

        OPTIONAL TODO : You'll have to re-fetch the current available seat status before changing it (concurrency issues)
     */
    // The student object will be sent by the controller
    public void setCourseEnrollmentStatus(Student student) {

    }

}
