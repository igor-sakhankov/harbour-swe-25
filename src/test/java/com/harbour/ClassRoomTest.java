package com.harbour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassRoomTest {

    @Test
    void conductClass() {
        ClassRoom classRoom = new ClassRoom();
        classRoom.conductClass();
    }
}