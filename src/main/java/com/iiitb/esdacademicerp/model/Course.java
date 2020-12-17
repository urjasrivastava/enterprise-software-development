package com.iiitb.esdacademicerp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id", unique = true, nullable = false)
    private long courseId;

    @Column(name = "course_code", unique = true, nullable = false)
    private String courseCode;

    @Column(name= "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "year")
    private short year;

    @Column(name = "term")
    private String term;

    // TODO : Change data type from String to List<String> to accommodate multiple faculty
    @Column(name = "faculty")
    private String faculty;

    @Column(name="credits", nullable = false)
    private short credits;

    @Column(name="capacity")
    private short capacity;

    @Column(name="available_seats")
    private short availableSeats;

    // Default Constructor
    public Course() {
    }

    // Parameterized Constructor
    public Course(long courseId, String courseCode, String name, String description, short year, String term, String faculty, short credits, short capacity, short availableSeats) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.name = name;
        this.description = description;
        this.year = year;
        this.term = term;
        this.faculty = faculty;
        this.credits = credits;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
    }

    // Getters & Setters

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public short getCredits() {
        return credits;
    }

    public void setCredits(short credits) {
        this.credits = credits;
    }

    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public short getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(short availableSeats) {
        this.availableSeats = availableSeats;
    }
}
