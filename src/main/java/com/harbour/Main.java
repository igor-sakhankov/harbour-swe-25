package com.harbour;


import com.harbour.selfwrittendi.ClassRoom;
import com.harbour.selfwrittendi.ObjectFactory;

public class Main {
    public static void main(String[] args) {
        ClassRoom classRoom = ObjectFactory.getInstance().createObject(ClassRoom.class);
        classRoom.conductClass();
    }
}