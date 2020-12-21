package com.iiitb.esdacademicerp.model;

import java.util.ArrayList;

public class CourseEnrollWrapper {

    private ArrayList<CourseEnroll> enrollment = new ArrayList<>();

    public ArrayList<CourseEnroll> getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(ArrayList<CourseEnroll> enrollment) {
        this.enrollment = enrollment;
    }
}
