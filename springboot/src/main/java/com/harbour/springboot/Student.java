package com.harbour.springboot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Student {
    @Id
    private Long id;

    @OneToMany
    private List<Course> courses;

    public void setId(Long id) {
	this.id = id;
    }

    public Long getId() {
	return id;
    }

    public List<Course> getCourses() {
	return courses;
    }

    public void setCourses(List<Course> courses) {
	this.courses = courses;
    }

    public int getGpa() {
	return 4;
    }

    public void setGpa(double v) {

    }
}
