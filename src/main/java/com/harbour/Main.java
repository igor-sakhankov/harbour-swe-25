package com.harbour;


public class Main {
    public static void main(String[] args) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.conductClass();

        var a = new IgorTeacher();
        var b = new IgorTeacher();


        System.out.println(a.equals(b));
    }
}