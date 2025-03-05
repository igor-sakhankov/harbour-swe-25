package com.harbour.springboot;

public class StudentsService {

    public boolean isGoodStudent(Student student) {
	return student.getGpa() >= 3;
    }
}
