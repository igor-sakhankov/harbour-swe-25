package com.harbour;


public class Main {
    public static void main(String[] args) {
        ClassRoom classRoom = ObjectFactory.getInstance().createObject(ClassRoom.class);
        classRoom.conductClass();

        var a = new IgorTeacher();
        var b = new IgorTeacher();


        System.out.println(a.equals(b));
    }
}