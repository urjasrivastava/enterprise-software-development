package com.iiitb.esdacademicerp.model;


import java.util.ArrayList;

public class CourseEnroll {
    private Course course;
    private ArrayList<Course> prerequisites;
    private short value;

    public CourseEnroll(Course course, short value, ArrayList<Course> prerequisites) {

        this.course = course;
        this.value = value;
        this.prerequisites = prerequisites;
    }

    public CourseEnroll() {

    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public short getValue() {
        return value;
    }

    public void setValue(short value) {
        this.value = value;
    }

    public ArrayList<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(ArrayList<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }
}
