package com.iiitb.esdacademicerp.model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
@Table(name = "prerequisite")
public class Prerequisite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prerequisite")
    private Course prerequisite;

    @Column(name = "description")
    private String description;

    // Default Constructor
    public Prerequisite() {
    }

    // Parameterized Constructor
    public Prerequisite(long id, Course course, Course prerequisite, String description) {
        this.id = id;
        this.course = course;
        this.prerequisite = prerequisite;
        this.description = description;
    }

    // Getters & Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Course prerequisite) {
        this.prerequisite = prerequisite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
