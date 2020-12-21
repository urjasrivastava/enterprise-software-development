package com.iiitb.esdacademicerp.service;

import com.iiitb.esdacademicerp.dao.CourseRepository;
import com.iiitb.esdacademicerp.dao.PrerequisiteRepository;
import com.iiitb.esdacademicerp.dao.StudentCourseRepository;
import com.iiitb.esdacademicerp.dao.StudentRepository;
import com.iiitb.esdacademicerp.model.Course;
import com.iiitb.esdacademicerp.model.CourseEnroll;
import com.iiitb.esdacademicerp.model.Student;
import com.iiitb.esdacademicerp.model.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// TODO : Work on this class please!
@Service
public class CourseEnrollmentService {

    @Autowired
    private StudentRepository student;


    @Autowired
    private StudentCourseRepository studentCourseRepository;


    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private PrerequisiteRepository prerequisiteRepository;


    // The student object will be sent by the controller
    public Map<String, Object> getCourseEnrollmentData(Student student) {
//    public ArrayList<CourseEnroll> getCourseEnrollmentData(Student student) {
        if (studentCourseRepository == null) {
            System.out.println("NULL");
            return null;
        }

        ArrayList<Long> studentCourseList = studentCourseRepository.getStudentCoursesByStudentId(student.getStudentId());
        ArrayList<Course> courseList = courseRepository.getCourseByYearAndAvailableSeats((short) 2020);
        HashMap<Long, ArrayList<Course>> satisfiedPrerequisiteMap = new HashMap<Long, ArrayList<Course>>();

        for (int courseIndex = 0; courseIndex < courseList.size(); courseIndex++) {

            ArrayList<Long> prerequisiteList = prerequisiteRepository.getPrerequisiteByCourseId(courseList.get(courseIndex).getCourseId());

            boolean isPrerequisiteSatisfied = true;

            for (int prereqIndex = 0; prereqIndex < prerequisiteList.size(); prereqIndex++) {
                if (!studentCourseList.contains(prerequisiteList.get(prereqIndex))) {
                    isPrerequisiteSatisfied = false;
                    break;
                }
            }
            if (!isPrerequisiteSatisfied)
                courseList.remove(courseIndex);
            else {
                ArrayList<Course> prereqList = courseRepository.getCourseByCourseIdIn(prerequisiteList);
                if(prereqList != null && prereqList.size() != 0) {
                    System.out.println(prereqList.get(0).getName());
                }
                satisfiedPrerequisiteMap.put(courseList.get(courseIndex).getCourseId(), prereqList);
            }

        }

        // TODO : Better variable name
        Map<String, Object> coursePrerequisiteMap = new HashMap<>(); // {"course_enroll" : enrollArrayList, "prerequisite" : "satisfiedPrerequisiteMap"}


        ArrayList<CourseEnroll> enrollArrayList = new ArrayList<>();
        for (int coursesIter = 0; coursesIter < courseList.size(); coursesIter++) {

            CourseEnroll courseEnroll = new CourseEnroll();
            courseEnroll.setCourse(courseList.get(coursesIter));
            courseEnroll.setPrerequisites(satisfiedPrerequisiteMap.get(courseList.get(coursesIter).getCourseId()));
            if (studentCourseList.contains(courseList.get(coursesIter).getCourseId())) {
                courseEnroll.setValue((short) 1);
            } else {
                courseEnroll.setValue((short) 0);
            }
            enrollArrayList.add(courseEnroll);
        }

        if (enrollArrayList.isEmpty()) return null;

        coursePrerequisiteMap.put("course_enroll", enrollArrayList);
        coursePrerequisiteMap.put("prerequisite", satisfiedPrerequisiteMap);

        return coursePrerequisiteMap;

    }

    // The student object will be sent by the controller
    public void setCourseEnrollmentStatus(Student student, ArrayList<CourseEnroll> enrollArrayList) {
        for (int i = 0; i < enrollArrayList.size(); i++) {
            CourseEnroll en = enrollArrayList.get(i);
            Course c = en.getCourse();
            short val = en.getValue();
            if (val == 3) {
                c.setAvailableSeats((short) (c.getAvailableSeats() - 1));
                courseRepository.save(c);
                StudentCourse s = new StudentCourse();
                s.setCourse(c);
                s.setComments("Enrolled");
                s.setStudent(student);
                studentCourseRepository.save(s);
            } else if (val == 2) {
                c.setAvailableSeats((short) (c.getAvailableSeats() + 1));
                courseRepository.save(c);
                StudentCourse s = studentCourseRepository.getStudentCoursesByStudentIdAndCourseId(student.getStudentId(), c.getCourseId());
                studentCourseRepository.delete(s);
            }
        }
    }

}
