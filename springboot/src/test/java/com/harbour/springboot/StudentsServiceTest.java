package com.harbour.springboot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StudentsServiceTest {

    @Test
    void isGoodStudent() {
	// Arrange
	StudentsService studentsService = new StudentsService();
	Student student = new Student();
	student.setGpa(3.5);
	// Act
	boolean goodStudent = studentsService.isGoodStudent(student);
	// Assert
	assertTrue(goodStudent);
    }

    @Test
    void isGoodStudentSolitary() {
	StudentsService studentsService = new StudentsService();
	Student student = mock(Student.class);
	when(student.getGpa()).thenReturn(3);

	assertTrue(studentsService.isGoodStudent(student));
    }

}