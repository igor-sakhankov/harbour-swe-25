package com.harbour;

public class ClassRoom {
    private final ITeacher teacher = ObjectFactory.getInstance().createObject(ITeacher.class);
    private final ITeacherAssistant teacherAssistant = ObjectFactory.getInstance().createObject(ITeacherAssistant.class);


    public void conductClass() {
        System.out.println("Class is starting");
        teacherAssistant.turnOnProjector();
        ITeacher teacher1 = teacher;
        teacher1.teach();
        teacherAssistant.turnOffProjector();
    }
}
