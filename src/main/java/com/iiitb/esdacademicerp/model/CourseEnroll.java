package com.iiitb.esdacademicerp.model;


public class CourseEnroll {
    private Course course;
    private short value;

    public CourseEnroll(Course course, short value) {

        this.course = course;
        this.value = value;
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
}
