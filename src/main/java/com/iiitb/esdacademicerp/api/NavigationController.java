package com.iiitb.esdacademicerp.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Handles general page navigation & page component building
@Controller
public class NavigationController {

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
        return "course_selection";
    }

}
