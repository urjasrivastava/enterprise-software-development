package com.iiitb.esdacademicerp.api;

import com.iiitb.esdacademicerp.dao.StudentRepository;
import com.iiitb.esdacademicerp.model.Course;
import com.iiitb.esdacademicerp.model.Student;
import com.iiitb.esdacademicerp.service.CourseEnrollmentService;
import com.iiitb.esdacademicerp.service.StudentAuthorizationDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Handles general page navigation & page component building
@Controller
public class NavigationController {
    @Autowired
    private CourseEnrollmentService courseEnrollmentService;

    @GetMapping("/")
    public String dashboard(Model dashboardModel) {
        /*
            Four things are to be sent -
            1. Image
            2. href
            3. Text
            4. Is the button clickable
        */
        ArrayList<Map<String, ?>> UIElements = new ArrayList<Map<String, ?>>();

        // Add my elements
        UIElements.add(
                Map.ofEntries(
                        Map.entry("image", "profile.png"),
                        Map.entry("href", "#"),
                        Map.entry("text", "My Profile"),
                        Map.entry("disabled", true)
                )
        );

        UIElements.add(
                Map.ofEntries(
                        Map.entry("image", "course.png"),
                        Map.entry("href", "course_selection"),
                        Map.entry("text", "Course Selection"),
                        Map.entry("disabled", false)
                )
        );

        UIElements.add(
                Map.ofEntries(
                        Map.entry("image", "schedule.jpg"),
                        Map.entry("href", "#"),
                        Map.entry("text", "Schedule"),
                        Map.entry("disabled", true)
                )
        );

        dashboardModel.addAttribute("ui", UIElements);

        return "/dashboard";
    }

    @GetMapping("/course_selection")
    public String courseSelection(Model courseModel) {


        Student student = ((StudentAuthorizationDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStudent();

        HashMap<Course, Short> coursemap = courseEnrollmentService.getCourseEnrollmentData(student);

        if(coursemap== null) {
            return "error_page"; // TODO : Configure error page
        }
        courseModel.addAttribute("Courses",coursemap);
        for (Map.Entry<Course,Short> entry :coursemap.entrySet())
            System.out.println("Key = " + entry.getKey().getName() +
                    ", Value = " + entry.getValue());
        return "course_selection";
    }
    @PostMapping("/course_selection")
    public String submit()
    {   HashMap<Course,Short> coursemap=new HashMap<>();
        Student student = ((StudentAuthorizationDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStudent();
        courseEnrollmentService.setCourseEnrollmentStatus(student,coursemap);
        return("thank_you");
    }

}
